---
title: Developer
layout: wiki
---
TXCore comes with a an embedded INI4J and a wrapper around it for use with Forge mods.

#### Example

This is the code for TXCore's INI check system. Your class must implement IIniConfig or else your class wont be recognized.

```java
package com.github.txuritan.core;

import com.github.txuritan.core.api.config.Configuration;
import com.github.txuritan.core.api.config.IIniConfig;
import com.github.txuritan.core.ini4j.Ini;
import org.apache.logging.log4j.Logger;

public class Config implements IIniConfig {
    private Configuration configuration;

    public Config(Configuration configuration) {
        this.configuration = configuration;
    }

    public Boolean debug;

    public Boolean testBoolean;
    public Double testDouble;
    public Float testFloat;
    public Integer testInteger;
    public Long testLong;
    public String testString;

    @Override
    public void config(Ini ini) {

        debug = configuration.getSetKeyBoolean(ini, "txcore", "debug", false);

        if(debug) {
            getLogger().info("Preforming CoreIni Check");

            testBoolean = configuration.getSetKeyBoolean(ini, "txcore.test", "testBoolean", false);
            getLogger().info("Default value: false, gotten: " + testBoolean);

            testDouble = configuration.getSetKeyDouble(ini, "txcore.test", "testDouble", 1.0);
            getLogger().info("Default value: 1.0, gotten: " + testDouble);

            testFloat = configuration.getSetKeyFloat(ini, "txcore.test", "testFloat", 1.0f);
            getLogger().info("Default value: 1.0f, gotten: " + testFloat);

            testInteger = configuration.getSetKeyInteger(ini, "txcore.test", "testInteger", 1);
            getLogger().info("Default value: 1, gotten: " + testInteger);

            testLong = configuration.getSetKeyLong(ini, "txcore.test", "testLong", 1L);
            getLogger().info("Default value: 1L, gotten: " + testLong);

            testString = configuration.getSetKeyString(ini, "txcore.test", "testString", "yay it works");
            getLogger().info("Default value: \"yay it works\", gotten: " + testString);
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
```

#### Register

You will need to register your config class with TXCore commonly done in the FMLPreInitializationEvent.

```java
package com.github.txuritan.core.proxy;

import com.github.txuritan.core.Config;
import com.github.txuritan.core.api.config.Configuration;
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
```

#### Output

```ini
[txcore.test]
testBoolean = false
testDouble = 1.0
testFloat = 1.0
testInteger = 1
testLong = 1
testString = yay it works

[txcore]
debug = false
```
