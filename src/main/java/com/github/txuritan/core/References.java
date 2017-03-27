package com.github.txuritan.core;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class References {

    public static File minecraft;


    public static final String MOD_ID = "txcore";
    public static final String MOD_NAME = "TXCore";
    public static final String VERSION = "1.11.2-17.3.0001";
    public static final String DEPENDENCIES = "before:metal;";

    public static final String CLIENT_PROXY_CLASS = "com.github.txuritan.core.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.github.txuritan.core.proxy.CommonProxy";


    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    static {
        try {
            minecraft = Minecraft.getMinecraft().mcDataDir.getCanonicalFile();
        } catch (IOException ioException) {
            LOGGER.error("Tried to get Minecraft's CanonicalFile threw IOException", ioException);
        }
    }
}
