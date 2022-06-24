package me.jonasjones.arduinoctrls;

import me.jonasjones.arduinoctrls.debug.LedBlink;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArduinoControls implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("arduinoctrls");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("UwU from Arduino Controls!");
		try {
			LedBlink.initialisation();
		} catch (InterruptedException e) {
			LOGGER.info("Failed to make Arduino LED blink. ARDUINO NOT CONNECTED!");
		}
	}
}
/*
//TODO:
- Full control over all programmable pins of all known raspberry pi's
- system to flash program onto arduino with ingame editor
- scratch system that allows for multiple event triggering when something happens
- cry because mojang UI system sucks ass
- make own library that allows for easy UI implementation

*/