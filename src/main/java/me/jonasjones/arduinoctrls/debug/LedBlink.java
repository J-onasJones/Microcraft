package me.jonasjones.arduinoctrls.debug;

import arduino.Arduino;
import me.jonasjones.arduinoctrls.ArduinoControls;

public class LedBlink {
    public static void initialisation() throws InterruptedException {

        //do portscan
        //String port = (new SPortScan()).getActivePort();
        String port = "/dev/ttyUSB0";
        //establish connection to Ardiuno
        Arduino ArduinoCon = new Arduino(port, 9600);
        boolean isOn = true; //Led state off
        String[] commands = {"turnOff", "turnOn"}; //commands for Arduino

        ArduinoCon.openConnection();
        Thread.sleep(4000);
        ArduinoCon.serialWrite(commands[1]);
        Thread.sleep(1000);
        ArduinoCon.serialWrite(commands[0]);
        Thread.sleep(1000);
        ArduinoCon.serialWrite(commands[1]);
        Thread.sleep(1000);
        ArduinoCon.serialWrite(commands[0]);
        ArduinoCon.closeConnection();
    }

    public static boolean blink(Arduino ArduinoCon, String[] commands, boolean isOn) throws InterruptedException {
        ArduinoCon.openConnection();
        Thread.sleep(4000);
        isOn = !isOn;
        if (isOn) {
            ArduinoCon.serialWrite(commands[1]);
        } else {
            ArduinoCon.serialWrite(commands[0]);
        }
        ArduinoCon.closeConnection();
        return isOn;
    }







}
