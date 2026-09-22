package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TutorialMod.MOD_ID);
    }

    @Override
    protected void start() {
        var blocks = registries.lookupOrThrow(Registries.BLOCK);

        add("onion_seeds_to_grass",
                new AddTableLootModifier(Optional.of(Holder.direct(
                        MatchBlock.blockMatches(blocks, Blocks.SHORT_GRASS).build()))
                        , 10, ModExtraLootProvider.ONION_SEEDS));

        add("onion_seeds_to_grass",
                new AddTableLootModifier(Optional.of(Holder.direct(
                        MatchBlock.blockMatches(blocks, Blocks.TALL_GRASS).build()))
                        , 10, ModExtraLootProvider.ONION_SEEDS));

        this.add("metal_detector_from_jungle_temple",
                new AddTableLootModifier(Optional.of(Holder.direct(
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("chests/jungle_temple")).build()))
                        , 10, ModExtraLootProvider.METAL_DETECTOR_FOUND));

        this.add("raw_azurite_from_creeper",
                new AddTableLootModifier(Optional.of(Holder.direct(
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/creeper")).build()))
                        , 10, ModExtraLootProvider.RAW_AZURITE));
    }
}
