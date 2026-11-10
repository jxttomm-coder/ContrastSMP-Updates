# Contrast SMP Season 2 client pack

This repository hosts the Forge 1.20.1 client manifest used by Contrast SMP Launcher. Release `v0.4.0` contains the 45 JARs from the supplied `Mod.zip` and two standalone libraries required by those mods. Create 6.0.8 already embeds Flywheel and Ponder, so those libraries are not duplicated.

The launcher validates every file by expected byte size and SHA-256 before installing it. It removes other mod JARs from its isolated game profile and keeps local and server resource packs disabled.

The Forge server deployment set remains documented in `server-mods.json` and `setup-server-mods.ps1`; it is maintained separately from the supplied client archive.
