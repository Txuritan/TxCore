package com.github.txuritan.core.api.config;

import com.github.txuritan.core.ini4j.Ini;
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