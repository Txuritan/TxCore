package com.github.txuritan.txcore;

import com.github.txuritan.txcore.api.config.Configuration;
import com.github.txuritan.txcore.api.config.IIniConfig;
import com.github.txuritan.txcore.ini4j.Ini;
import org.apache.logging.log4j.Logger;

public class Config implements IIniConfig {
    private Configuration configuration;

    public Config(Configuration configuration) {
        this.configuration = configuration;
    }

    private String section = "txcore";
    private String sectionTest = section + ".test";

    public Boolean debug;

    public Boolean testBoolean;
    public Double testDouble;
    public Float testFloat;
    public Integer testInteger;
    public Long testLong;
    public String testString;

    @Override
    public void config(Ini ini) {

        debug = configuration.getSetKeyBoolean(ini, section, "debug", false);

        if(debug) {
            getLogger().info("Preforming CoreIni Check");

            testBoolean = configuration.getSetKeyBoolean(ini, sectionTest, "testBoolean", false);
            getLogger().info("Default value: false, gotten: " + configuration.getKeyBoolean(ini, sectionTest, "testBoolean"));

            testDouble = configuration.getSetKeyDouble(ini, sectionTest, "testDouble", 1.0);
            getLogger().info("Default value: 1.0, gotten: " + configuration.getKeyDouble(ini, sectionTest, "testDouble"));

            testFloat = configuration.getSetKeyFloat(ini, sectionTest, "testFloat", 1.0f);
            getLogger().info("Default value: 1.0f, gotten: " + configuration.getKeyFloat(ini, sectionTest, "testFloat"));

            testInteger = configuration.getSetKeyInteger(ini, sectionTest, "testInteger", 1);
            getLogger().info("Default value: 1, gotten: " + configuration.getKeyInteger(ini, sectionTest, "testInteger"));

            testLong = configuration.getSetKeyLong(ini, sectionTest, "testLong", 1L);
            getLogger().info("Default value: 1L, gotten: " + configuration.getKeyLong(ini, sectionTest, "testLong"));

            testString = configuration.getSetKeyString(ini, sectionTest, "testString", "yay it works");
            getLogger().info("Default value: \"yay it works\", gotten: " + configuration.getKeyString(ini, sectionTest, "testString"));
        }
    }

    @Override
    public Logger getLogger() {
        return References.LOGGER;
    }

    @Override
    public String configPath() {
        return configuration.getSuggestedConfig();
    }

    @Override
    public String modId() {
        return References.MOD_ID;
    }
}
