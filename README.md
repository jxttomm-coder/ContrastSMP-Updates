# Contrast SMP Season 2

Season 2 uses Minecraft 1.20.1 with Forge 47.4.28. The launcher reads `manifest.json`, installs the client mod list and seven supplied resource packs, and validates downloads with SHA-256.

The Forge server list is in `server-mods.json`. `setup-server-mods.ps1` installs those files into an existing server's `mods` folder from their official download hosts.

## Owner-developed server mods

- `season2-ore-boost` 1.0.1: multiplies vanilla ore placement attempts by 5 and emerald attempts by 7 for new chunks. This includes ancient debris (netherite ore), quartz, and nether gold. Large totals use multiple legal count placements to stay within Minecraft's 256-value limit.
- `season2-underground-control`: disables vanilla mineshafts, ancient cities, buried treasure, Nether fossils, dungeons, and amethyst geodes for new chunks. It leaves strongholds available and does not override the Trial Chambers backport.
- `Trials-2.3.4.jar` is the Forge backport used to provide Trial Chambers on Minecraft 1.20.1. Its official CurseForge download is referenced in the manifests, not mirrored here.

Install both Contrast SMP mods, the Trial Chambers backport, and every entry from `server-mods.json` on the server. The two Contrast SMP mods also need to be installed in the client profile.
