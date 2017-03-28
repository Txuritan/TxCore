package com.github.txuritan.txcore.api.config;

import com.github.txuritan.txcore.ini4j.Ini;
import org.apache.logging.log4j.Logger;

/**
 * @author Ian 'Txuritan' Cronkright
 */
public interface IIniConfig {
    void config(Ini ini);

    Logger getLogger();

    String configPath();

    String modId();
}