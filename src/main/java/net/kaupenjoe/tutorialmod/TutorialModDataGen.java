package net.kaupenjoe.tutorialmod;

import net.kaupenjoe.tutorialmod.datagen.*;
import net.kaupenjoe.tutorialmod.datagen.villager.ModPOITags;
import net.kaupenjoe.tutorialmod.datagen.villager.ModTradeSets;
import net.kaupenjoe.tutorialmod.datagen.villager.ModVillagerTradeTags;
import net.kaupenjoe.tutorialmod.datagen.villager.ModVillagerTrades;
import net.kaupenjoe.tutorialmod.worldgen.ModBiomeModifiers;
import net.kaupenjoe.tutorialmod.worldgen.ModFeatures;
import net.kaupenjoe.tutorialmod.worldgen.ModPlacedFeatures;
import net.kaupenjoe.tutorialmod.worldgen.dimension.ModDimensions;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class TutorialModDataGen {
    @SubscribeEvent
    public static void gatherDataRegistryEntries(GatherDataRegistryEntriesEvent event) {
        event.gatherFor(TutorialMod.MOD_ID, Identifier.DEFAULT_NAMESPACE)
                .add(Registries.DAMAGE_TYPE, ModDamageTypes::bootstrap)
                .add(Registries.FEATURE, ModFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
                .add(Registries.JUKEBOX_SONG, ModJukeboxSongs::bootstrap)
                .add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap)
                .add(Registries.TRADE_SET, ModTradeSets::bootstrap)
                .add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
                .add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
                .add(Registries.BLOCK_TRANSFORMER, ModBlockTransformers::bootstrap)

                .add(Registries.LOOT_TABLE, new LootTableProvider(Set.of(), List.of(
                        new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK),
                        new LootTableProvider.SubProviderEntry(ModExtraLootProvider::new, LootContextParamSets.ALL_PARAMS),
                        new LootTableProvider.SubProviderEntry(ModEntityLootTableProvider::new, LootContextParamSets.ENTITY))))
                .add(Registries.ADVANCEMENT, ModAdvancements::new)
                .add(ModRecipeProvider.create());
    }

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getReloadableLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModDataMapProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModItemTagsProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModEquipmentAssetProvider(packOutput));
        generator.addProvider(true, new ModPaintingTagsProvider(packOutput, lookupProvider));

        generator.addProvider(true, new ModSoundsProvider(packOutput));

        generator.addProvider(true, new ModVillagerTradeTags(packOutput, lookupProvider));
        generator.addProvider(true, new ModPOITags(packOutput, lookupProvider));

        generator.addProvider(true, new ModGlobalLootModifierProvider(packOutput, lookupProvider));
    }
}
