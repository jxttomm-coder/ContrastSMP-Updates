# Contrast SMP Season 2 client pack

This repository hosts the Forge 1.20.1 client manifest used by Contrast SMP Launcher. Release `v0.4.4` contains the 45 JARs from the supplied `Mod.zip`, their required standalone libraries, and the two additional JARs supplied by the user: Dynamic Light 0.3 and Runes 1.3.2. Create 6.0.8 embeds Flywheel and Ponder, so those libraries are not duplicated.

The launcher validates each file by byte size and SHA-256, installs it into its isolated profile, and keeps resource packs disabled.

The dedicated-server ZIP contains 46 server-capable JARs, including Dynamic Light and Runes. See `server-mods.json` and `SERVER-SIDE-MODS.md`.
