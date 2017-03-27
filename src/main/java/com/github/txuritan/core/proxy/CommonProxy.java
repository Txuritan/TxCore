package com.github.txuritan.core.proxy;

import com.github.txuritan.core.Config;
import com.github.txuritan.core.References;
import com.github.txuritan.core.api.config.Configuration;
import net.minecraft.world.DimensionType;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        Configuration.INSTANCE.registerConfig(new Config(Configuration.INSTANCE));
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
