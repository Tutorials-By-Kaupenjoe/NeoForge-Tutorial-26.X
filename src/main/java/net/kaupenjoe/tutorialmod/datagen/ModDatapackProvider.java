package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.datagen.villager.ModTradeSets;
import net.kaupenjoe.tutorialmod.datagen.villager.ModVillagerTrades;
import net.kaupenjoe.tutorialmod.worldgen.ModBiomeModifiers;
import net.kaupenjoe.tutorialmod.worldgen.ModConfiguredFeatures;
import net.kaupenjoe.tutorialmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PAINTING_VARIANT, ModPaintings::bootstrap)
            .add(Registries.JUKEBOX_SONG, ModJukeboxSongs::bootstrap)
            .add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap)

            .add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap)
            .add(Registries.TRADE_SET, ModTradeSets::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TutorialMod.MOD_ID));
    }
}
