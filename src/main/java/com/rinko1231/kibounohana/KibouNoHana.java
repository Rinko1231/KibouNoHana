package com.rinko1231.kibounohana;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.common.Mod;


@Mod(KibouNoHana.MODID)
public class KibouNoHana
{
    public static final String MODID = "kibounohana";


    public KibouNoHana()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

}
