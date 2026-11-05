package com.vyltrex.contrastsmp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

/** Exit the standalone client instead of returning to Minecraft's title screen after disconnect. */
public final class QuickExitClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> client.execute(client::stop));
    }
}
