package com.vyltrex.contrastsmp.mixin;

import com.vyltrex.contrastsmp.QuickExitClient;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.renderer.texture.SimpleTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LoadingOverlay.class)
abstract class LoadingOverlayBackgroundMixin {
    @Unique
    private static volatile boolean contrast$bannerRegistered;

    @Inject(method = "extractRenderState", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/gui/GuiGraphicsExtractor;fill(IIIII)V", shift = At.Shift.AFTER, ordinal = 0))
    private void contrast$drawBanner(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta,
        CallbackInfo callback) {
        if (!contrast$bannerRegistered && Minecraft.getInstance().getTextureManager() != null) {
            Minecraft.getInstance().getTextureManager().registerAndLoad(
                QuickExitClient.BRAND_BANNER, new SimpleTexture(QuickExitClient.BRAND_BANNER));
            contrast$bannerRegistered = true;
        }
        graphics.blit(RenderPipelines.GUI_TEXTURED, QuickExitClient.BRAND_BANNER,
            0, 0, 0.0F, 0.0F, graphics.guiWidth(), graphics.guiHeight(), 1280, 720);
    }
}
