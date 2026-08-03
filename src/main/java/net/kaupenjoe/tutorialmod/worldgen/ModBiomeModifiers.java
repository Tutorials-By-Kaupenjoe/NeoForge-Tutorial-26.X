package net.kaupenjoe.tutorialmod.worldgen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    // PF to BiomeModifier
    // NeoForge Class -> Places PlacedFeatures into specific Biomes

    public static void bootstrap(BootstrapContext<BiomeModifier>  context) {

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
