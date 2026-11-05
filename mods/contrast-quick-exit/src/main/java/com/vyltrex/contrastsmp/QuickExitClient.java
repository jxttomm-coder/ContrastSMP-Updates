package com.vyltrex.contrastsmp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.multiplayer.JoinMultiplayerScreen;
import net.minecraft.network.chat.CommonComponents;

/** Exit the standalone client instead of returning to Minecraft's title screen after disconnect. */
public final class QuickExitClient implements ClientModInitializer {
    private boolean directJoinStarted;

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> exitAfterDisconnect());
        ScreenEvents.AFTER_INIT.register((client, screen, width, height) -> onScreenOpened(client, screen));
    }

    private static void exitAfterDisconnect() {
        // Mods such as Distant Horizons can block Minecraft's render thread for
        // several seconds while client.stop() shuts down background workers.
        // No local world is being saved here; multiplayer state is server-side.
        Thread exitThread = new Thread(() -> Runtime.getRuntime().halt(0), "contrast-smp-exit");
        exitThread.setDaemon(true);
        exitThread.start();
    }

    private void onScreenOpened(net.minecraft.client.Minecraft client, Screen screen) {
        if (screen instanceof ConnectScreen) {
            directJoinStarted = true;
            for (var child : screen.children()) {
                if (child instanceof AbstractWidget widget &&
                    CommonComponents.GUI_CANCEL.equals(widget.getMessage())) {
                    widget.visible = false;
                    widget.active = false;
                }
            }
            return;
        }

        // Cancelling or failing before entering the world must not strand the
        // launcher-launched client at Minecraft's title or multiplayer menu.
        if (directJoinStarted && client.level == null &&
            (screen instanceof TitleScreen || screen instanceof JoinMultiplayerScreen ||
                screen instanceof DisconnectedScreen)) {
            exitAfterDisconnect();
        }
    }
}
