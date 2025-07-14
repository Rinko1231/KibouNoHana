package com.rinko1231.kibounohana.mixin;

import de.maxhenkel.corpse.ServerConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = ServerConfig.class, remap = false)
public class CorpseServerConfigMixin {

    @ModifyArg(method = {"<init>(Lnet/minecraftforge/common/ForgeConfigSpec$Builder;)V"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/common/ForgeConfigSpec$Builder;define(Ljava/lang/String;Z)Lnet/minecraftforge/common/ForgeConfigSpec$BooleanValue;",
                    ordinal = 2),
            index = 1)
    public boolean maxCount(boolean defaultValue) {
        return true;
    }


}
