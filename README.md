# Contrast SMP updates

The public `manifest.json` in GitHub Releases defines the managed client content for Minecraft 26.3 and Fabric Loader 0.20.1. Contrast SMP Launcher reads the latest release automatically; players do not need a GitHub account.

## Release contents

- 53 managed mod JARs, including the owner-developed `vyltrexsmpmod.jar` and `contrast-quick-exit-1.2.2.jar`.
- 10 resource-pack ZIPs installed into the launcher's separate game profile.
- Minecraft Quick Play joins Contrast SMP on startup; the client exits immediately after disconnect to avoid a long mod shutdown hang.
- The launcher window opens fullscreen and prevents dragging or context-saving its images.
- SHA-256 and byte-size verification for every download.
- Incremental updates with backups and rollback, while unrelated player files are preserved.

The 51 third-party mod files and all 10 resource packs match their official Modrinth-published versions. They are downloaded from their original Modrinth CDN URLs. Several projects are All Rights Reserved or have special terms, so those files are referenced at their official hosts instead of being copied into this GitHub release. The owner-developed mods are attached here. `source-verified.json` records the resolved sources and licenses; `source-inventory.json` records the supplied archive inventory.

The resource packs are installed separately in the profile's `resourcepacks` directory. Players can enable them in Minecraft's Resource Packs screen.

## Release files

- `manifest.json`: launcher update manifest, attached to each release.
- `vyltrexsmpmod.jar` and `contrast-quick-exit-1.2.2.jar`: owner-provided client mods, attached to the current release.
- `source-inventory.json`: clean inventory from the original archive.
- `source-verified.json`: exact source match, URLs, versions and license metadata.
- `release-metadata.json`: repository and asset conventions.
- `CHANGELOG.md`: modpack release history.

The launcher validates HTTPS URLs, downloads with retries, and verifies SHA-256 plus file size before installing. Mods and resource packs have separate managed folders and ownership state.
