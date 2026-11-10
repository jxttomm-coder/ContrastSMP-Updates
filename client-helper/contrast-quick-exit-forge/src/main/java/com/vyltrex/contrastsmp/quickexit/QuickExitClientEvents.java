package com.vyltrex.contrastsmp.quickexit;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ContrastQuickExit.MOD_ID, value = Dist.CLIENT)
public final class QuickExitClientEvents {
    private static boolean connectedToMultiplayer;

    private QuickExitClientEvents() {}

    @SubscribeEvent
    public static void onPlayerLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        connectedToMultiplayer = Minecraft.getInstance().getCurrentServer() != null;
    }

    @SubscribeEvent
    public static void onPlayerLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        if (!connectedToMultiplayer) return;
        connectedToMultiplayer = false;

        Minecraft minecraft = Minecraft.getInstance();
        minecraft.execute(minecraft::stop);
    }
}
