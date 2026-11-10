# Contrast SMP Season 2 client pack

This repository hosts the Forge 1.20.1 client manifest used by Contrast SMP Launcher. Release `v0.4.2` contains the 45 JARs from the supplied `Mod.zip`, two standalone libraries required by those mods, and a small client-only launcher helper that closes Minecraft after a multiplayer disconnect. Create 6.0.8 embeds Flywheel and Ponder, so those libraries are not duplicated.

The launcher validates each file by byte size and SHA-256, installs it into its isolated profile, and keeps resource packs disabled.

The dedicated-server deployment remains separate; its ZIP excludes client-only files, including the quick-exit helper. See `server-mods.json` and `SERVER-SIDE-MODS.md`.
