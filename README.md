# Contrast SMP updates

The public `manifest.json` in GitHub Releases defines the managed client content for Minecraft 26.3 and Fabric Loader 0.20.1. Contrast SMP Launcher reads the latest release automatically; players do not need a GitHub account.

## Release contents

- 54 managed mod JARs, including Contrast Gear 1.0.0, the owner-developed `vyltrexsmpmod.jar`, and the quick-exit-only `contrast-quick-exit-1.3.3.jar`.
- 10 resource-pack ZIPs installed into the launcher's separate game profile.
- Minecraft Quick Play joins Contrast SMP on startup; the client exits immediately after disconnect to avoid a long mod shutdown hang.
- The launcher window opens fullscreen and prevents dragging or context-saving its images.
- SHA-256 and byte-size verification for every download.
- Incremental updates with backups and rollback, while unrelated player files are preserved.

The 51 third-party mod files and all 10 resource packs match their official Modrinth-published versions. They are downloaded from their original Modrinth CDN URLs. Several projects are All Rights Reserved or have special terms, so those files are referenced at their official hosts instead of being copied into this GitHub release. The owner-developed mods are attached here. `source-verified.json` records the resolved sources and licenses; `source-inventory.json` records the supplied archive inventory.

The resource packs are installed separately in the profile's `resourcepacks` directory. Players can enable them in Minecraft's Resource Packs screen.

## Release files

- `manifest.json`: launcher update manifest, attached to each release.
- `vyltrexsmpmod.jar`, `contrast-quick-exit-1.3.3.jar`, and `ContrastSMP-Gear-Fabric-26.3.jar`: owner-provided mods, attached to their release.
- `source-inventory.json`: clean inventory from the original archive.
- `source-verified.json`: exact source match, URLs, versions and license metadata.
- `release-metadata.json`: repository and asset conventions.
- `CHANGELOG.md`: modpack release history.

The launcher validates HTTPS URLs, downloads with retries, and verifies SHA-256 plus file size before installing. Mods and resource packs have separate managed folders and ownership state.

The latest release, v0.1.9, adds Contrast Gear 1.0.0 to the managed modpack. It is marked for client and server environments and depends on Fabric API. v0.1.8 restored the normal Minecraft interface and the earlier direct-join flow. The launcher resolves the configured server endpoint for Minecraft Quick Play; the client helper preserves the quick-exit behavior after disconnect. The custom title-menu mod and artwork are no longer in the managed modpack.

