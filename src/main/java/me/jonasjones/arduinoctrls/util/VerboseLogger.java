package me.jonasjones.arduinoctrls.util;

import jdk.jfr.StackTrace;
import me.jonasjones.arduinoctrls.ArduinoControls;
import me.jonasjones.arduinoctrls.config.ModConfigs;

public class VerboseLogger {
    public static void info(String message) {
        if (ModConfigs.VERBOSE) {
            ArduinoControls.VERBOSELOGGER.info(message);
        }
    }
    public void debug(String message) {
        if (ModConfigs.VERBOSE) {
            ArduinoControls.VERBOSELOGGER.debug(message);
        }
    }
    public static void error(String message) {
        if (ModConfigs.VERBOSE) {
            ArduinoControls.VERBOSELOGGER.error(message);
        }
    }
    public static void trace( String message) {
        if (ModConfigs.VERBOSE) {
            ArduinoControls.VERBOSELOGGER.trace(message);
        }
    }
    public static void warn( String message) {
        if (ModConfigs.VERBOSE) {
            ArduinoControls.VERBOSELOGGER.warn(message);
        }
    }
}
