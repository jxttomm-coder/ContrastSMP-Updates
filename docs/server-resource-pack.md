# Contrast SMP server resource pack

Minecraft's normal server resource-pack prompt is the delivery mechanism. The launcher does not download or install this pack a second time.

When the server owner has selected the actual pack and made it publicly reachable over HTTPS, add these values to the server's `server.properties`:

```properties
resource-pack=<public HTTPS URL to the selected ZIP>
resource-pack-sha1=<40-character SHA-1 of that exact ZIP>
require-resource-pack=true
```

The owner requested required acceptance. With `require-resource-pack=true`, Minecraft prompts each joining player and the server should refuse/disconnect players who decline. Do not publish this configuration with placeholders. The local resourcepacks folder currently contains multiple unrelated ZIP files, so no pack has been selected and no URL or SHA-1 is available yet.
