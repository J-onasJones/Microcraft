# Microcraft
A Minecraft mod that allows for Microcontroller and Singleboard computer control (and everything else that supports serial connections).

<a href="https://github.com/J-onasJones/Microcraft/blob/master/LICENSE"><img src="https://img.shields.io/github/license/J-onasJones/Microcraft?style=flat&color=900c3f" alt="License"></a>
<a href="https://discord.gg/V2EsuUVmWh"><img src="https://img.shields.io/discord/702180921234817135?color=5865f2&label=Discord&style=flat" alt="Discord"></a>
<a href="https://www.curseforge.com/minecraft/mc-mods/microcraft"><img src="https://cf.way2muchnoise.eu/full_663476.svg" alt="CF"></a>
<a href="https://modrinth.com/mod/microcraft"><img src="https://img.shields.io/badge/dynamic/json?logo=data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+CjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+Cjxzdmcgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDUxMiA1MTQiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSIgeG1sbnM6c2VyaWY9Imh0dHA6Ly93d3cuc2VyaWYuY29tLyIgc3R5bGU9ImZpbGwtcnVsZTpldmVub2RkO2NsaXAtcnVsZTpldmVub2RkO3N0cm9rZS1saW5lam9pbjpyb3VuZDtzdHJva2UtbWl0ZXJsaW1pdDoyOyI+CiAgICA8Zz4KICAgICAgICA8ZyBpZD0ibW9kcmludGgiPgogICAgICAgICAgICA8cGF0aCBkPSJNNTAzLjE2LDMyMy41NkM1MTQuNTUsMjgxLjQ3IDUxNS4zMiwyMzUuOTEgNTAzLjIsMTkwLjc2QzQ2Ni41Nyw1NC4yMyAzMjYuMDQsLTI2LjggMTg5LjMzLDkuNzhDODMuODEsMzguMDIgMTEuMzksMTI4LjA3IDAuNjksMjMwLjQ3TDQzLjk5LDIzMC40N0M1NC4yOSwxNDcuMzMgMTEzLjc0LDc0LjczIDE5OS43NSw1MS43MUMzMDYuMDUsMjMuMjYgNDE1LjEzLDgwLjY3IDQ1My4xNywxODEuMzhMNDExLjAzLDE5Mi42NUMzOTEuNjQsMTQ1LjggMzUyLjU3LDExMS40NSAzMDYuMyw5Ni44MkwyOTguNTYsMTQwLjY2QzMzNS4wOSwxNTQuMTMgMzY0LjcyLDE4NC41IDM3NS41NiwyMjQuOTFDMzkxLjM2LDI4My44IDM2MS45NCwzNDQuMTQgMzA4LjU2LDM2OS4xN0wzMjAuMDksNDEyLjE2QzM5MC4yNSwzODMuMjEgNDMyLjQsMzEwLjMgNDIyLjQzLDIzNS4xNEw0NjQuNDEsMjIzLjkxQzQ2OC45MSwyNTIuNjIgNDY3LjM1LDI4MS4xNiA0NjAuNTUsMzA4LjA3TDUwMy4xNiwzMjMuNTZaIiBzdHlsZT0iZmlsbDpyZ2IoMjMsMjMsMjUpOyIvPgogICAgICAgICAgICA8cGF0aCBkPSJNMzIxLjk5LDUwNC4yMkMxODUuMjcsNTQwLjggNDQuNzUsNDU5Ljc3IDguMTEsMzIzLjI0QzMuODQsMzA3LjMxIDEuMTcsMjkxLjMzIDAsMjc1LjQ2TDQzLjI3LDI3NS40NkM0NC4zNiwyODcuMzcgNDYuNDcsMjk5LjM1IDQ5LjY4LDMxMS4yOUM1My4wNCwzMjMuOCA1Ny40NSwzMzUuNzUgNjIuNzksMzQ3LjA3TDEwMS4zOCwzMjMuOTJDOTguMTMsMzE2LjQyIDk1LjM5LDMwOC42IDkzLjIxLDMwMC40N0M2OS4xNywyMTAuODcgMTIyLjQxLDExOC43NyAyMTIuMTMsOTQuNzZDMjI5LjEzLDkwLjIxIDI0Ni4yMyw4OC40NCAyNjIuOTMsODkuMTVMMjU1LjE5LDEzM0MyNDQuNzMsMTMzLjA1IDIzNC4xMSwxMzQuNDIgMjIzLjUzLDEzNy4yNUMxNTcuMzEsMTU0Ljk4IDExOC4wMSwyMjIuOTUgMTM1Ljc1LDI4OS4wOUMxMzYuODUsMjkzLjE2IDEzOC4xMywyOTcuMTMgMTM5LjU5LDMwMC45OUwxODguOTQsMjcxLjM4TDE3NC4wNywyMzEuOTVMMjIwLjY3LDE4NC4wOEwyNzkuNTcsMTcxLjM5TDI5Ni42MiwxOTIuMzhMMjY5LjQ3LDIxOS44OEwyNDUuNzksMjI3LjMzTDIyOC44NywyNDQuNzJMMjM3LjE2LDI2Ny43OUMyMzcuMTYsMjY3Ljc5IDI1My45NSwyODUuNjMgMjUzLjk4LDI4NS42NEwyNzcuNywyNzkuMzNMMjk0LjU4LDI2MC43OUwzMzEuNDQsMjQ5LjEyTDM0Mi40MiwyNzMuODJMMzA0LjM5LDMyMC40NUwyNDAuNjYsMzQwLjYzTDIxMi4wOCwzMDguODFMMTYyLjI2LDMzOC43QzE4Ny44LDM2Ny43OCAyMjYuMiwzODMuOTMgMjY2LjAxLDM4MC41NkwyNzcuNTQsNDIzLjU1QzIxOC4xMyw0MzEuNDEgMTYwLjEsNDA2LjgyIDEyNC4wNSwzNjEuNjRMODUuNjQsMzg0LjY4QzEzNi4yNSw0NTEuMTcgMjIzLjg0LDQ4NC4xMSAzMDkuNjEsNDYxLjE2QzM3MS4zNSw0NDQuNjQgNDE5LjQsNDAyLjU2IDQ0NS40MiwzNDkuMzhMNDg4LjA2LDM2NC44OEM0NTcuMTcsNDMxLjE2IDM5OC4yMiw0ODMuODIgMzIxLjk5LDUwNC4yMloiIHN0eWxlPSJmaWxsOnJnYigyMywyMywyNSk7ZmlsbC1ydWxlOm5vbnplcm87Ii8+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4K&label=&suffix=%20&query=downloads&url=https://api.modrinth.com/api/v1/mod/[PROJECT ID]&style=flat&color=242629&labelColor=5ca424" alt="Modrinth"></a>
<a href="https://modrinth.com/mod/microcraft"><img src="https://modrinth-utils.vercel.app/api/badge/versions?id=[PROJECT ID]&last=true"></a>

<a align="center"><img src="https://jonasjones.me/uploads/mod-badges/support-fabric.png" width="250px"><img src="https://jonasjones.me/uploads/mod-badges/support-quilt.png" width="250px"><img src="https://jonasjones.me/uploads/mod-badges/no-support-forge.png" width="250px"></a>

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
