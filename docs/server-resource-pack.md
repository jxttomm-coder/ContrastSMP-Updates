# Contrast SMP server resource pack

All 10 resource packs from the supplied local folder are listed in `manifest.json`. The launcher downloads and verifies them into the isolated Contrast SMP profile's `resourcepacks` folder. The player can then enable them from Minecraft's Resource Packs screen.

Minecraft's `server.properties` has one `resource-pack` URL field, so the server can automatically offer one ZIP, not all 10 separate packs. Pick the one pack to enforce, or prepare a combined ZIP and review the asset conflicts before using it. Then set these properties on the actual server:

```properties
resource-pack=<public HTTPS URL to the selected ZIP>
resource-pack-sha1=<40-character SHA-1 of that exact ZIP>
require-resource-pack=true
```

The archive files are available from their official Modrinth-hosted URLs in `manifest.json`; third-party files with restrictive terms are not mirrored to GitHub. The server's `server.properties` was not present, and no server host/file access was available, so these settings have not been applied to the running server.
