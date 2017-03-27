package com.github.txuritan.core.api.config;

import com.github.txuritan.core.References;
import com.github.txuritan.core.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public enum Configuration {
    INSTANCE;

    private Object configClass;

    public void registerConfig(Object configClass) {
        if(configClass instanceof IIniConfig) {
            INSTANCE.configClass = configClass;
            File configFile = new File(((IIniConfig) configClass).configPath());
            if (configFile.exists()) {
                try {
                    Ini ini = new Ini(configFile);
                    ((IIniConfig) configClass).config(ini);
                    INSTANCE.saveConfig(ini, configFile);
                } catch (IOException e) {
                    References.LOGGER.error("IOException while reading: " + configFile.getName() + " from mod: " + ((IIniConfig) configClass).modId(), e);
                }
            } else {
                try {
                    configFile.createNewFile();
                    Ini ini = new Ini(configFile);
                    ((IIniConfig) configClass).config(ini);
                    INSTANCE.saveConfig(ini, configFile);
                } catch (IOException e) {
                    References.LOGGER.error("IOException while reading/making: " + configFile.getName() + " from mod: " + ((IIniConfig) configClass).modId(), e);
                }
            }
        }
    }

    public Boolean getSetKeyBoolean(Ini ini, String section, String option, Boolean defualt) {
        return Boolean.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Double getSetKeyDouble(Ini ini, String section, String option, Double defualt) {
        return Double.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Float getSetKeyFloat(Ini ini, String section, String option, Float defualt) {
        return Float.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Integer getSetKeyInteger(Ini ini, String section, String option, Integer defualt) {
        return Integer.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Long getSetKeyLong(Ini ini, String section, String option, Long defualt) {
        return Long.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public String getSetKeyString(Ini ini, String section, String option, String defualt) {
        if(ini.get(section, option) != null) {
            return ini.get(section, option);
        } else {
            ini.put(section, option, defualt);
            return ini.get(section, option);
        }
    }

    public void saveConfig(Ini ini, File configFile) {
        try {
            Writer writer = new PrintWriter(configFile);
            ini.store(writer);
            writer.close();
        } catch (IOException e) {
            References.LOGGER.error("IOException while writing to: " + configFile.getName() + " from mod: " + ((IIniConfig) INSTANCE.configClass).modId(), e);
        }
    }

    public String getSuggestedConfig() {
        return References.minecraft.toString() +
                File.separator + "config" +
                File.separator + ((IIniConfig) INSTANCE.configClass).modId() + ".ini";
    }
}
