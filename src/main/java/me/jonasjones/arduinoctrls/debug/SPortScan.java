package me.jonasjones.arduinoctrls.debug;

import java.util.Enumeration;

import gnu.io.*;
import me.jonasjones.arduinoctrls.ArduinoControls;

public class SPortScan {
    private String activePort;

    public SPortScan(){
        CommPortIdentifier serialPortId;

        Enumeration enumComm;

        enumComm = CommPortIdentifier.getPortIdentifiers(); // get active ports
        ArduinoControls.LOGGER.info("Found Ports: " + enumComm.toString());

        /*
            go throught ports and identify the serial
         */
        while(enumComm.hasMoreElements())
        {
            serialPortId = (CommPortIdentifier) enumComm.nextElement(); // get next one
            if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) // check if is serial type
            {
                this.activePort = (String) serialPortId.getName();
            }
        }
    }

    public String getActivePort(){
        return this.activePort;
    }
}
