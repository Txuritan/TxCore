package com.github.txuritan.txcore.api.config;

import com.github.txuritan.txcore.References;
import com.github.txuritan.txcore.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@SuppressWarnings("SameParameterValue")
public enum Configuration {
    INSTANCE;

    private Object configClass;

    public void registerConfig(Object configClass) {
        if (configClass instanceof IIniConfig) {
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
                    //noinspection ResultOfMethodCallIgnored
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

    public Boolean getKeyBoolean(Ini ini, String section, String option) {
        String value = INSTANCE.getKeyString(ini, section, option);
        if (value != null) {
            return Boolean.valueOf(value);
        } else {
            return null;
        }
    }

    public void setKeyBoolean(Ini ini, String section, String option, Boolean defualt) {
        ini.put(section, option, defualt);
    }



    public Double getSetKeyDouble(Ini ini, String section, String option, Double defualt) {
        return Double.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Double getKeyDouble(Ini ini, String section, String option) {
        String value = INSTANCE.getKeyString(ini, section, option);
        if (value != null) {
            return Double.valueOf(value);
        } else {
            return null;
        }
    }

    public void setKeyDouble(Ini ini, String section, String option, Double defualt) {
        ini.put(section, option, defualt);
    }



    public Float getSetKeyFloat(Ini ini, String section, String option, Float defualt) {
        return Float.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Float getKeyFloat(Ini ini, String section, String option) {
        String value = INSTANCE.getKeyString(ini, section, option);
        if (value != null) {
            return Float.valueOf(value);
        } else {
            return null;
        }
    }

    public void setKeyFloat(Ini ini, String section, String option, Float defualt) {
        ini.put(section, option, defualt);
    }



    public Integer getSetKeyInteger(Ini ini, String section, String option, Integer defualt) {
        return Integer.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Integer getKeyInteger(Ini ini, String section, String option) {
        String value = INSTANCE.getKeyString(ini, section, option);
        if (value != null) {
            return Integer.valueOf(value);
        } else {
            return null;
        }
    }

    public void setKeyInteger(Ini ini, String section, String option, Integer defualt) {
        ini.put(section, option, defualt);
    }



    public Long getSetKeyLong(Ini ini, String section, String option, Long defualt) {
        return Long.valueOf(INSTANCE.getSetKeyString(ini, section, option, defualt.toString()));
    }

    public Long getKeyLong(Ini ini, String section, String option) {
        String value = INSTANCE.getKeyString(ini, section, option);
        if (value != null) {
            return Long.valueOf(value);
        } else {
            return null;
        }
    }

    public void setKeyLong(Ini ini, String section, String option, Long defualt) {
        ini.put(section, option, defualt);
    }



    public String getSetKeyString(Ini ini, String section, String option, String defualt) {
        if (ini.get(section, option) != null) {
            return ini.get(section, option);
        } else {
            ini.put(section, option, defualt);
            return ini.get(section, option);
        }
    }

    public String getKeyString(Ini ini, String section, String option) {
        if (ini.get(section, option) != null) {
            return ini.get(section, option);
        } else {
            return null;
        }
    }

    public void setKeyString(Ini ini, String section, String option, String defualt) {
        ini.put(section, option, defualt);
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
