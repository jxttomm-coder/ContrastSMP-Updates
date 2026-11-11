# Contrast SMP Season 2 client pack

This repository hosts the Forge 1.20.1 client manifest used by Contrast SMP Launcher. Release `v0.4.5` contains all 52 client JARs in `manifest.json`: the 45 JARs from the supplied `Mod.zip`, their required standalone libraries, Dynamic Light 0.3, Runes 1.3.2, BetterF3 7.0.2, Better Smithing Table 2.2.1, and Xaero’s Minimap 26.6.0. Architectury was already included. Create 6.0.8 embeds Flywheel and Ponder, so those libraries are not duplicated.

The launcher validates each file by byte size and SHA-256, installs it into its isolated profile, and keeps resource packs disabled.

The dedicated-server ZIP contains 46 server-capable JARs, including Dynamic Light and Runes. See `server-mods.json` and `SERVER-SIDE-MODS.md`.
