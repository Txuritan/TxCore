package com.github.txuritan.txcore.proxy;

import com.github.txuritan.txcore.Config;
import com.github.txuritan.txcore.References;
import com.github.txuritan.txcore.api.config.Configuration;
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
