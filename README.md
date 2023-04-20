# Microcraft
A Minecraft mod that allows for Microcontroller and Singleboard computer control (and everything else that supports serial connections).

<a href="https://github.com/J-onasJones/Microcraft/blob/master/LICENSE"><img src="https://img.shields.io/github/license/J-onasJones/Microcraft?style=flat&color=900c3f" alt="License"></a>
<a href="https://discord.gg/V2EsuUVmWh"><img src="https://img.shields.io/discord/702180921234817135?color=5865f2&label=Discord&style=flat" alt="Discord"></a>
<a href="https://www.curseforge.com/minecraft/mc-mods/microcraft"><img src="https://cf.way2muchnoise.eu/full_663476.svg" alt="CF"></a>
<a href="https://modrinth.com/mod/microcraft"><img src="https://img.shields.io/modrinth/dt/microcraft?logo=modrinth&label=&style=flat&color=242629&labelColor=00AF5C&logoColor=white" alt="Modrinth"></a>
<a href="https://modrinth.com/mod/microcraft"><img src="https://img.shields.io/modrinth/game-versions/microcraft?logo=modrinth&color=242629&labelColor=00AF5C&logoColor=white"></a>

<a align="center"><img src="http://cdn.jonasjones.me/uploads/mod-badges/fabric-api.png" width="250px">
<img src="http://cdn.jonasjones.me/uploads/mod-badges/no-support-forge.png" width="250px">
<img src="http://cdn.jonasjones.me/uploads/mod-badges/available-modrinth.png" width="250px"><img src="http://cdn.jonasjones.me/uploads/mod-badges/support-fabric.png"  width="250px"><img src="http://cdn.jonasjones.me/uploads/mod-badges/support-quilt.png" width="250px"></a>

### Examples
You can connect a button to your Microcontroller and make your player jump when pressing it or you can make a small LED light up as soon as you crouch. You can also expand on said example by e.g. displaying your health on an LED matrix (ft. my brother). This and some more examples can be viewed on [Github](https://github.com/J-onasJones/Microcraft/tree/examples).
Literally anything can be triggered and if it isn't implemented yet, open an issue on GitHub and make a feature request

**This mod is in an early stage and may contain some bugs** - *DISCLAIMER: **big understatment** the mod is nowhere close to being in a state where it is usable*

### About the mod
This mod allows for communication between the minecraft client and a Microcontroller or singleboard computer (e.g. Raspberry PI). In general every device that supports a serial connection can be used. The connection is bi-directional, meaning that you can trigger something from both ends.

<img src="https://jonasjones.me/uploads/mod-badges/available-modrinth.png" width="250px"> (not yet but soon (TM))

### Setup

1. Download the mod jar for the correct version and place it into your mods folder
2.  If you are on Linux, run the following commands in a terminal (replace the placeholder with your username):

```
sudo usermod -a -G uucp [user]
sudo usermod -a -G dialout [user]
sudo usermod -a -G lock [user]
sudo usermod -a -G tty [user]
```

If any of these commands fail, that's ok. these groups aren't all available on every distro but as long as you're in at least one of them, the mod should work. Alternatively you can run your Minecraft client as root although this is not recommended.
