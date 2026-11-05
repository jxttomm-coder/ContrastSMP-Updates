package com.vyltrex.contrastsmp.mixin;

import com.mojang.blaze3d.platform.NativeImage;
import com.vyltrex.contrastsmp.QuickExitClient;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.renderer.texture.MipmapStrategy;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.client.gui.screens.LoadingOverlay$LogoTexture")
abstract class LoadingOverlayMixin {
    @Inject(method = "loadContents", at = @At("HEAD"), cancellable = true)
    private void contrast$loadBanner(ResourceManager resources, CallbackInfoReturnable<TextureContents> callback)
        throws IOException {
        InputStream stream = LoadingOverlayMixin.class.getResourceAsStream(
            "/assets/contrast_quick_exit/textures/gui/brand_logo.png");
        if (stream != null) {
            try (stream) {
                NativeImage image = NativeImage.read(stream);
                callback.setReturnValue(new TextureContents(image,
                    new TextureMetadataSection(false, false, MipmapStrategy.AUTO, 0.0F)));
            }
        }
    }
}
