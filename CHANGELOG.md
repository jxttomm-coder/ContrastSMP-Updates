# Contrast SMP Season 2 updates

## v0.3.4 — Add NukaTeam's Gun Lib

- Add NTGL 3.1.2 for Forge 1.20.1 to the client and server manifests.
- Update the launcher mod list and publish the supplied LGPL-licensed JAR.

## v0.3.3 — Fix Forge metadata URL in launcher

- Pass Forge's full Maven version (`1.20.1-47.4.28`) to the launcher library so it requests the correct Forge metadata and installer artifact.
- Publish Contrast SMP Launcher 2.6.2.

## v0.3.2 — Fix ore boost datapack counts

- Split Emerald and upper iron placement counts into multiple legal count modifiers, preserving 7× emerald and 5× ore attempts without exceeding Minecraft's 256 per-modifier limit.
- Publish Ore Boost mod version 1.0.1 and refresh the client and server manifests.

## v0.3.1 — Fix Trial Chambers manifest checksum

- Correct the Trial Chambers backport SHA-256 to its full 64-character value so the launcher accepts and verifies the JAR.
- Republish the latest launcher manifests and release assets.

## v0.3.0 — Add Create Ore Excavation

- Add Create Ore Excavation 1.6.6 and its GeckoLib 4.8.4 dependency to client and server manifests.
- Publish both supplied Forge JARs and a quick server import ZIP.
- Update the launcher mod list for the two additions.
- Keep the pack on Minecraft 1.20.1 / Forge 47.4.28.

## v0.2.0 — Season 2 Forge launch

- Move the managed profile from Minecraft 26.3 / Fabric to Minecraft 1.20.1 / Forge 47.4.28.
- Curate the supplied archive to Forge-compatible 1.20.1 client mods and seven resource packs; remove Fabric-only mods.
- Add the Trial Chambers 2.3.4 Forge backport because Minecraft 1.20.1 does not include Trial Chambers.
- Add owner-developed Forge mods for vanilla ore frequency, underground generation, and the server's Season 2 rules.
- Reference third-party downloads at their official Modrinth or CurseForge source URLs and verify all artifacts with SHA-256 and size.
- Add a server mod manifest and a PowerShell installer.
