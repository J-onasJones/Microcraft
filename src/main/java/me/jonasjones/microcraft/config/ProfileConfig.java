package me.jonasjones.microcraft.config;

import me.jonasjones.microcraft.object.BoardData;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProfileConfig {
    public static void uwu() throws IOException, ParseException {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject defaultBoardProfile = new JSONObject();
        JSONArray defaultBoardProfilePinMaps = new JSONArray();
        JSONObject pin1 = new JSONObject();
        pin1.put("A1", "advancement.uwu");
        JSONObject pin2 = new JSONObject();
        pin2.put("D4", "read.pin");
        defaultBoardProfilePinMaps.add(pin1);
        defaultBoardProfilePinMaps.add(pin2);
        defaultBoardProfile.put("displayname", "Default Profile");
        defaultBoardProfile.put("board", BoardData.board.Custom);
        defaultBoardProfile.put("pinmapping", defaultBoardProfilePinMaps);
        jsonArray.add(defaultBoardProfile);
        jsonObject.put("profiles", jsonArray);

        FileWriter file = new FileWriter("uwu.txt");
        file.write(jsonObject.toJSONString());
        file.close();

        //TODO: check if file can be read and interpreted as json

        String str = Files.readString(Path.of("uwu.txt"));

        JSONParser jsonParser = new JSONParser();


        JSONObject uwu = (JSONObject) jsonParser.parse(str);
        /*System.out.print(uwu.toJSONString());*/
    }
}
