package me.jonasjones.arduinoctrls.config;

import com.mojang.datafixers.util.Pair;

import me.jonasjones.arduinoctrls.ArduinoControls;

public class ModConfigs {
    public static SimpleConfig CONFIGMAIN;
    public static SimpleConfig CONFIGLISTS;
    private static ModConfigProvider configMain;
    private static ModConfigProvider configLists;

    //configMain
    public static Boolean ISENABLED;
    public static String DEFAULTBOARDFALLBACK;
    public static int LOOPINTERVAL;
    public static Boolean BOARDMELTING;
    public static Boolean VERBOSE = false; //needs to be set to false since the verbose logger is called before config file is fully loaded
    public static String EDITOR;

    //configList
    public static Boolean DISPLAYENTRYALL;
    public static Boolean DISPLAYENTRYPLAYERJUMP;
    public static Boolean DISPLAYENTRYPLAYERSPRINT;
    public static Boolean DISPLAYENTRYPLAYERWALKFORWARDS;
    public static Boolean DISPLAYENTRYPLAYERWALKBACKWARDS;
    public static Boolean DISPLAYENTRYPLAYERWALKRIGHT;
    public static Boolean DISPLAYENTRYPLAYERWALKLEFT;
    public static Boolean DISPLAYENTRYPLAYERSNEAK;
    public static Boolean DISPLAYENTRYISALL;
    public static Boolean DISPLAYENTRYISPLAYERJUMP;
    public static Boolean DISPLAYENTRYISPLAYERSPRINT;
    public static Boolean DISPLAYENTRYISPLAYERWALKFORWARDS;
    public static Boolean DISPLAYENTRYISPLAYERWALKBACKWARDS;
    public static Boolean DISPLAYENTRYISPLAYERWALKRIGHT;
    public static Boolean DISPLAYENTRYISPLAYERWALKLEFT;
    public static Boolean DISPLAYENTRYISPLAYERSNEAK;


    public static void registerConfigs() {
        configMain = new ModConfigProvider();
        configLists = new ModConfigProvider();

        createConfigs();

        CONFIGMAIN = SimpleConfig.of(ArduinoControls.MOD_ID + "-main").provider(configMain).request();
        CONFIGLISTS = SimpleConfig.of(ArduinoControls.MOD_ID + "-lists").provider(configLists).request();

        assignConfigs();
    }

    private static void createConfigs() {
        //configMain
        configMain.addKeyValuePair(new Pair<>("basic.isEnabled", true), "whether or not the mod is enabled");
        configMain.addKeyValuePair(new Pair<>("basic.defaultBoardFallback", "A-nano"), "The board to automatically be selected if failed to detect automatically. All valid ID's can be found at: https://github.com/J-onasJones/MicrocontrollerMC/wiki/Microcontroller-Boards#supported-boards");
        configMain.addKeyValuePair(new Pair<>("advanced.loopInterval", 50), "The Delay in ms between each check.");
        configMain.addKeyValuePair(new Pair<>("fun.boardMelting", false), "Whether or not the board should have a flame overlay instead of being greyed out when not connected.");
        configMain.addKeyValuePair(new Pair<>("debug.verbose", false), "Toggle verbose console output.");
        configMain.addKeyValuePair(new Pair<>("editor.default", "ingame"), "The default editor for the board program. All valid default Editors can be found at: https://github.com/J-onasJones/MicrocontrollerMC/wiki/Board-Program-Editors#available-editors");

        //configLists
        configLists.addKeyValuePair(new Pair<>("displayEntry.all", false), "Whether or not to display all entries. This overrides all other states except for debug and experimental entries. More infos can be found at: https://github.com/J-onasJones/MicrocontrollerMC/wiki/Pin-Map-Entries#list-of-all-entries");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerJump", true), "Display Player Jump Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerSprint", true), "Display Player Sprint Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerWalkForwards", true), "Display Player Walk Forwards Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerWalkBackwards", true), "Display Player Walk Backwards Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerWalkRight", true), "Display Player Walk Right Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerWalkLeft", true), "Display Player Walk Left Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntry.playerSneak", true), "Display Player Sneak Entry");

        configLists.addKeyValuePair(new Pair<>("displayEntryIs.all", false), "Whether or not to display all 'Is' entries. This overrides all other states except for debug and experimental entries. More infos can be found at: https://github.com/J-onasJones/MicrocontrollerMC/wiki/Pin-Map-Entries#list-of-all-entries");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerJump", true), "Display Is Player Jumping Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerSprint", true), "Display Is Player Sprinting Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerWalkForwards", true), "Display Is Player Walking Forwards Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerWalkBackwards", true), "Display Is Player Walking Backwards Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerWalkRight", true), "Display Is Player Walking Right Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerWalkLeft", true), "Display Is Player Walking Left Entry");
        configLists.addKeyValuePair(new Pair<>("displayEntryIs.playerSneak", true), "Display Is Player Sneaking Entry");
        
    }

    private static void assignConfigs() {
        ISENABLED = CONFIGMAIN.getOrDefault("basic.isEnabled", true);
        DEFAULTBOARDFALLBACK = CONFIGMAIN.getOrDefault("basic.defaultBoardFallback", "A-nano");
        LOOPINTERVAL = CONFIGMAIN.getOrDefault("advanced.loopInterval", 50);
        BOARDMELTING = CONFIGMAIN.getOrDefault("fun.boardMelting", false);
        VERBOSE = CONFIGMAIN.getOrDefault("debug.verbose", false);
        EDITOR = CONFIGMAIN.getOrDefault("editor.default", "ingame");

        DISPLAYENTRYALL = CONFIGLISTS.getOrDefault("displayEntry.all", false);
        DISPLAYENTRYPLAYERJUMP = CONFIGLISTS.getOrDefault("displayEntry.playerJump", true);
        DISPLAYENTRYPLAYERSPRINT = CONFIGLISTS.getOrDefault("displayEntry.playerSprint", true);
        DISPLAYENTRYPLAYERWALKFORWARDS = CONFIGLISTS.getOrDefault("displayEntry.playerWalkForwards", true);
        DISPLAYENTRYPLAYERWALKBACKWARDS = CONFIGLISTS.getOrDefault("displayEntry.playerWalkBackwards", true);
        DISPLAYENTRYPLAYERWALKRIGHT = CONFIGLISTS.getOrDefault("displayEntry.playerWalkRight", true);
        DISPLAYENTRYPLAYERWALKLEFT = CONFIGLISTS.getOrDefault("displayEntry.playerWalkRight", true);
        DISPLAYENTRYPLAYERSNEAK = CONFIGLISTS.getOrDefault("displayEntry.playerSneak", true);

        DISPLAYENTRYISALL = CONFIGLISTS.getOrDefault("displayEntryIs.all", false);
        DISPLAYENTRYISPLAYERJUMP = CONFIGLISTS.getOrDefault("displayEntryIs.playerJump", true);
        DISPLAYENTRYISPLAYERSPRINT = CONFIGLISTS.getOrDefault("displayEntryIs.playerSprint", true);
        DISPLAYENTRYISPLAYERWALKFORWARDS = CONFIGLISTS.getOrDefault("displayEntryIs.playerWalkForwards", true);
        DISPLAYENTRYISPLAYERWALKBACKWARDS = CONFIGLISTS.getOrDefault("displayEntryIs.playerWalkBackwards", true);
        DISPLAYENTRYISPLAYERWALKRIGHT = CONFIGLISTS.getOrDefault("displayEntryIs.playerWalkRight", true);
        DISPLAYENTRYISPLAYERWALKLEFT = CONFIGLISTS.getOrDefault("displayEntryIs.playerWalkLeft", true);
        DISPLAYENTRYISPLAYERSNEAK = CONFIGLISTS.getOrDefault("displayEntryIs.playerSneak", true);

        System.out.println("All " + configMain.getConfigsList().size() + " have been set properly");
    }
}
