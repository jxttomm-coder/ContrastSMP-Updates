# Changelog

## 0.1.5

- Restored Minecraft's original loading screen, title logo, and button artwork.
- Removed the Contrast SMP UI resource pack from the managed profile.
- Removes the old UI pack from `options.txt` on existing Launcher 2.4.0 installs.
- Kept the faster disconnect exit and direct-join protections.

## 0.1.4

- Fixed a startup crash caused by registering the loading banner before Minecraft creates its texture manager.
- Registers the banner lazily on the first loading-screen render instead.

## 0.1.3

- Replaced slow graceful shutdown after multiplayer disconnect with immediate client exit, avoiding the Distant Horizons render-thread hang.
- Added a Contrast SMP loading banner, branded title logo, and dark blue menu buttons.
- Automatically enabled the managed Contrast SMP UI resource pack.
- Launcher close and minimize modes now bring the launcher back when Minecraft exits.
- Refreshed the visible mod count after the managed content synchronizes.

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

## 0.1.6

- Replaced the quick-exit-only client helper with the CONTRAST SMP custom main menu for Minecraft 26.3.
- Removed launcher quick-play auto-join; connection begins only after selecting Connect to Server in Minecraft.
- Retained the managed server address and writes it to the client profile for the menu.


## 0.1.7

- Fixed Fabric metadata packaging so the custom client menu entrypoint is discovered in the managed Minecraft profile.
- Replaced the menu background and logo with the supplied Contrast SMP Banner and Logo PNG files.
- Added working Multiplayer, Singleplayer, Options, and Quit Game buttons alongside Connect to Server.

