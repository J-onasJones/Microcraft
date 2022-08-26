package me.jonasjones.microcraft.util;

import me.jonasjones.microcraft.Microcraft;
import me.jonasjones.microcraft.config.ModConfigs;

public class VerboseLogger {
    public static void info(String message) {
        if (ModConfigs.VERBOSE) {
            Microcraft.VERBOSELOGGER.info(message);
        }
    }
    public void debug(String message) {
        if (ModConfigs.VERBOSE) {
            Microcraft.VERBOSELOGGER.debug(message);
        }
    }
    public static void error(String message) {
        if (ModConfigs.VERBOSE) {
            Microcraft.VERBOSELOGGER.error(message);
        }
    }
    public static void trace( String message) {
        if (ModConfigs.VERBOSE) {
            Microcraft.VERBOSELOGGER.trace(message);
        }
    }
    public static void warn( String message) {
        if (ModConfigs.VERBOSE) {
            Microcraft.VERBOSELOGGER.warn(message);
        }
    }
}
