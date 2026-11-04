# Contrast SMP update repository

This repository contains the public update manifest and source inventory for Contrast SMP Launcher.

The manifest at the root is a **draft** for Minecraft 26.3 and Fabric Loader 0.20.1. It has no mod entries yet, so no release has been published. Before a release, verify each artifact's official HTTPS URL, version, SHA-256, file size, and redistribution terms. The complete inventory of 51 unique candidate JARs is in `source-inventory.json`; the three identical duplicates were removed and the superseded Fabric API copy was excluded.

Contrast SMP Launcher fetches `manifest.json` from the latest public GitHub Release. Players do not need GitHub accounts. Third-party JARs should only be attached when their licenses allow it; otherwise list their verified official download URLs in the manifest. The owner's custom `vyltrexsmpmod` is retained in the inventory and can be added as an owner-authorized release artifact.

See `docs/server-resource-pack.md` for the server-side resource-pack properties. The pack URL and hash must come from the actual selected ZIP and hosting location; no placeholders should be deployed.
