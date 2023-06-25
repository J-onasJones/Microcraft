package me.jonasjones.microcraft.util.boardmanager;


import com.fazecast.jSerialComm.SerialPort;

import java.util.ArrayList;
import java.util.List;

public class SerialNumberScanner {
    public static List<String> scan() {
        SerialPort[] ports = SerialPort.getCommPorts();
        List<String> list = new ArrayList<String>();
        for (SerialPort port : ports) {
            System.out.println(port.getSystemPortName());
            list.add(port.getSystemPortName());
        }
        return list;
    }
}
