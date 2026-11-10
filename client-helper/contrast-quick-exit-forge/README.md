# Contrast SMP Quick Exit for Forge

Forge 1.20.1 client helper. It listens for `ClientPlayerNetworkEvent.LoggingOut` after a multiplayer session and schedules `Minecraft.stop()` on the client thread. This closes the game cleanly after a player leaves the server or the server drops during a restart.

Dedicated servers do not need this mod.
