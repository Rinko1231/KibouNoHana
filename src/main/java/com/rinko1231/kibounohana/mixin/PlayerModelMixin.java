package com.rinko1231.kibounohana.mixin;

import de.maxhenkel.corpse.Main;
import de.maxhenkel.corpse.entities.DummyPlayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public abstract class PlayerModelMixin<T extends LivingEntity> extends HumanoidModel<T> {

    @Unique
    private static final float CORPSE_LEFT_ARM_X_ROT = (float) Math.toRadians(-180);
    @Unique
    private static final float CORPSE_LEFT_ARM_Z_ROT = (float) Math.toRadians(13);
    @Unique
    private static final float CORPSE_RIGHT_LEG_Z_ROT = (float) Math.toRadians(10);
    @Unique
    private static final float CORPSE_RIGHT_LEG_Y_ROT = (float) Math.toRadians(2);
    @Final
    @Shadow
    public ModelPart leftSleeve;
    @Final
    @Shadow
    public ModelPart rightPants;
    @Unique
    private float Corpse$leftArmXRot, Corpse$leftArmZRot, Corpse$leftArmX, Corpse$leftArmY, Corpse$leftArmZ;


    // 存储原始信息
    @Unique
    private float Corpse$rightLegOriginalX, Corpse$rightLegOriginalY, Corpse$rightLegOriginalZ;
    @Unique
    private float Corpse$rightLegOriginalZRot, Corpse$rightLegOriginalYRot;
    @Unique
    private boolean Corpse$originalStateSaved = false;

    public PlayerModelMixin(ModelPart root) {
        super(root);
    }

    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At("HEAD"))
    private void saveOriginalState(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        //只在首次调用时保存原始状态
        if (!Corpse$originalStateSaved) {
            Corpse$rightLegOriginalX = this.rightLeg.x;
            Corpse$rightLegOriginalY = this.rightLeg.y;
            Corpse$rightLegOriginalZ = this.rightLeg.z;
            Corpse$rightLegOriginalZRot = this.rightLeg.zRot;
            Corpse$rightLegOriginalYRot = this.rightLeg.yRot;

            Corpse$leftArmX = this.leftArm.x;
            Corpse$leftArmY = this.leftArm.y;
            Corpse$leftArmZ = this.leftArm.z;
            Corpse$leftArmXRot = this.leftArm.xRot;
            Corpse$leftArmZRot = this.leftArm.zRot;


            Corpse$originalStateSaved = true;
        }
    }

    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At("TAIL"))
    private void modifyCorpsePose(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (entity instanceof DummyPlayer && Main.SERVER_CONFIG.spawnCorpseOnFace.get()) {
            //左臂
            this.leftArm.xRot = CORPSE_LEFT_ARM_X_ROT;
            this.leftArm.zRot = CORPSE_LEFT_ARM_Z_ROT;
            this.leftArm.setPos(5.0F, 0.0F, 0.0F);
            this.leftSleeve.copyFrom(leftArm);

            //右腿
            this.rightLeg.zRot = CORPSE_RIGHT_LEG_Z_ROT;
            this.rightLeg.yRot = CORPSE_RIGHT_LEG_Y_ROT;
            this.rightLeg.setPos(-2.2F, 12.0F, 0.0F);
            this.rightPants.copyFrom(this.rightLeg);
        } else {
            // 非遗体实体：恢复右腿原始状态
            this.rightLeg.setPos(Corpse$rightLegOriginalX, Corpse$rightLegOriginalY, Corpse$rightLegOriginalZ);
            this.rightLeg.zRot = Corpse$rightLegOriginalZRot;
            this.rightLeg.yRot = Corpse$rightLegOriginalYRot;


            this.leftArm.xRot = Corpse$leftArmXRot;
            this.leftArm.zRot = Corpse$leftArmZRot;
            this.leftArm.setPos(Corpse$leftArmX, Corpse$leftArmY, Corpse$leftArmZ);


        }
        // 无论如何都要更新服装部件
        this.leftSleeve.copyFrom(leftArm);
        this.rightPants.copyFrom(rightLeg);
    }
}