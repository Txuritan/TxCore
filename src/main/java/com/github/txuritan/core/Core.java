package com.github.txuritan.core;

import com.github.txuritan.core.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        name = References.MOD_NAME,
        modid = References.MOD_ID,
        version = References.VERSION,
        dependencies = References.DEPENDENCIES
)
public class Core {
    @SuppressWarnings("unused")
    @SidedProxy(
            serverSide = References.COMMON_PROXY_CLASS,
            clientSide = References.CLIENT_PROXY_CLASS,
            modId = References.MOD_ID
    )
    private static CommonProxy proxy;

    @Mod.Instance(References.MOD_ID)
    public static Core instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
