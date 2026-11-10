# Contrast SMP Forge server mods

Install the 44 JARs in [Server-Side-Mods-Forge-1.20.1.zip](https://github.com/jxttomm-coder/ContrastSMP-Updates/releases/latest/download/Server-Side-Mods-Forge-1.20.1.zip) on the Forge 47.4.28 server (Minecraft 1.20.1, Java 17). Stop the server and back up the existing `mods` folder before replacing its contents. Do not install client-only files on the dedicated server.

The full SHA-256 verified list is in `server-mods.json`. The three files excluded from the server are:

- `appleskin-forge-mc1.20.1-2.5.1.jar`
- `entity_model_features-3.3.12-1.20.1-forge.jar`
- `entity_texture_features-7.2.7-1.20.1-forge.jar`

Create 6.0.8 includes Flywheel 1.0.5 and Ponder 1.0.91 inside its JAR. Architectury and Wizards are separate required dependencies and are already included in the server ZIP.
