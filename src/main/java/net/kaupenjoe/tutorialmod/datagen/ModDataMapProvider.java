package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.registries.datamaps.builtin.Strippable;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.END_FIRE_STARTER.getId(), new FurnaceFuel(4800), false);

        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.ONION_SEEDS.getId(), new Compostable(0.3f), false)
                .add(ModItems.ONION.getId(), new Compostable(0.5f), false);

        builder(NeoForgeDataMaps.STRIPPABLES)
                .add(ModBlocks.DRIFTWOOD_LOG, new Strippable(ModBlocks.STRIPPED_DRIFTWOOD_LOG.get()), false)
                .add(ModBlocks.DRIFTWOOD_WOOD, new Strippable(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.get()), false);
    }
}
