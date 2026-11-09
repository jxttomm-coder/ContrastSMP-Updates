package com.vyltrex.contrastsmp;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/** Adds the Season 2 worldgen datapack overrides. Install on every server and client. */
@Mod(ContrastS2Worldgen.MOD_ID)
public final class ContrastS2Worldgen {
    public static final String MOD_ID = "contrast_s2_underground";

    public ContrastS2Worldgen(FMLJavaModLoadingContext context) {
        // World generation is supplied by the data resources in this mod jar.
    }
}
