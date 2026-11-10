# Contrast SMP Season 2 client pack

This repository hosts the Forge 1.20.1 client manifest used by Contrast SMP Launcher. Release `v0.4.3` contains the 45 JARs from the supplied `Mod.zip` and two standalone libraries required by those mods. No quick-exit mod is shipped; the Windows launcher closes Minecraft after its multiplayer server connection ends. Create 6.0.8 embeds Flywheel and Ponder, so those libraries are not duplicated.

The launcher validates each file by byte size and SHA-256, installs it into its isolated profile, and keeps resource packs disabled.

The dedicated-server deployment remains separate and contains 44 server-capable JARs. See `server-mods.json` and `SERVER-SIDE-MODS.md`.
