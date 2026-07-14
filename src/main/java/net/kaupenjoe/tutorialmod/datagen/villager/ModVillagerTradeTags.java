package net.kaupenjoe.tutorialmod.datagen.villager;

import net.kaupenjoe.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VillagerTradesTagsProvider;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.VillagerTradeTags;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradeTags extends VillagerTradesTagsProvider {
    public ModVillagerTradeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(VillagerTradeTags.FARMER_LEVEL_1)
                .add(TagEntry.element(ModVillagerTrades.FARMER_1_EMERALD_ONION_SEEDS.identifier()))
                .add(TagEntry.element(ModVillagerTrades.FARMER_1_DIAMOND_ONION.identifier()));
        getOrCreateRawBuilder(VillagerTradeTags.FARMER_LEVEL_2)
                .add(TagEntry.element(ModVillagerTrades.FARMER_2_GOJI_BERRIES_EMERALD.identifier()));

        getOrCreateRawBuilder(VillagerTradeTags.LIBRARIAN_LEVEL_1)
                .add(TagEntry.element(ModVillagerTrades.LIBRARIAN_1_AZURITE_ENCHANTED.identifier()));


        getOrCreateRawBuilder(ModTags.Trades.KAUPENGER_LEVEL_1)
                .add(TagEntry.element(ModVillagerTrades.KAUPENGER_1_EMERALD_METAL_DETECTOR.identifier()))
                .add(TagEntry.element(ModVillagerTrades.KAUPENGER_1_EMERALD_RAW_AZURITE.identifier()));
        getOrCreateRawBuilder(ModTags.Trades.KAUPENGER_LEVEL_2)
                .add(TagEntry.element(ModVillagerTrades.KAUPENGER_2_EMERALD_METAL_DETECTOR.identifier()))
                .add(TagEntry.element(ModVillagerTrades.KAUPENGER_2_AZURITE_MAGIC_BLOCK.identifier()));

    }
}
