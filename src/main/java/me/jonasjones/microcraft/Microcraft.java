package me.jonasjones.microcraft;

import me.jonasjones.microcraft.config.ModConfigs;
import me.jonasjones.microcraft.config.ProfileConfig;
import net.fabricmc.api.ClientModInitializer;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Microcraft implements ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "microcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Logger VERBOSELOGGER = LoggerFactory.getLogger(MOD_ID + " - VERBOSE LOGGER");

	public static boolean enabled = true;

	public static void toggle() {
		enabled = !enabled;
	}

	@Override
	public void onInitializeClient() {
		//message from mod to confirm that it has been loaded
		LOGGER.info("Microcraft Initialized!");

		// register configs
		ModConfigs.registerConfigs();

		//blink LED on startup
		/*try {
			LedBlink.initialisation();
		} catch (InterruptedException e) {
			LOGGER.info("Failed to make Arduino LED blink. ARDUINO NOT CONNECTED!");
		}*/
		try {
			ProfileConfig.uwu();
		} catch (IOException e) {
			LOGGER.error("AHHHHHHHHHHHHHHHHHHHHH IO");
			System.out.print(e);
		}
	}
}