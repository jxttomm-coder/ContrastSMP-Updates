# Changelog

## 0.1.2

- Added Raise Sound Limit Simplified for Minecraft 26.3 Fabric, satisfying the optional recommendation from Sounds.
- Removed the cancel control during direct Quick Play connection attempts.
- Closed Minecraft if a failed or cancelled attempt returns to the title, multiplayer, or disconnect screen.
- Kept closing Minecraft on server disconnect after a successful join.

## 0.1.1

- Added Minecraft Quick Play so launching opens directly into Contrast SMP.
- Resolved the server's SRV endpoint and port automatically for direct join.
- Added a client mod that closes Minecraft after disconnecting from the server.
- Installed the managed resource packs and updated the managed mod list to 52 entries.
- Opened the launcher fullscreen and blocked dragging or context-saving launcher images.

## 0.1.0

- Published 51 managed Minecraft 26.3 / Fabric 0.20.1 mod entries.
- Included the owner-provided `vyltrexsmpmod.jar` in the GitHub Release.
- Added 10 separately managed resource-pack downloads.
- Verified the 50 third-party mod JARs and 10 resource packs against their official Modrinth version hashes, sizes, and direct HTTPS download sources.
- Excluded three exact duplicate JAR entries and the superseded Fabric API 0.161.0 artifact; kept Fabric API 0.165.0.
- Third-party files remain served by their official publishers to respect their distribution terms.
