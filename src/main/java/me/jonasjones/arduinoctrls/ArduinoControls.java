package me.jonasjones.arduinoctrls;

import me.jonasjones.arduinoctrls.config.ModConfigs;
import me.jonasjones.arduinoctrls.debug.LedBlink;
import me.jonasjones.arduinoctrls.util.VerboseLogger;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArduinoControls implements ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "arduinoctrls";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Logger VERBOSELOGGER = LoggerFactory.getLogger(MOD_ID + " - VERBOSE LOGGER");

	@Override
	public void onInitializeClient() {
		//message from mod to confirm that it has been loaded
		LOGGER.info("UwU from Arduino Controls!");

		// register configs
		ModConfigs.registerConfigs();

		//blink LED on startup
		/*try {
			LedBlink.initialisation();
		} catch (InterruptedException e) {
			LOGGER.info("Failed to make Arduino LED blink. ARDUINO NOT CONNECTED!");
		}*/
	}
}