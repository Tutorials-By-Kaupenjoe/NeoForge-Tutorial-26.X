package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TutorialMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("onion_seeds_to_grass",
                new AddTableLootModifier(new LootItemCondition[]{
                        AnyOfCondition.anyOf(
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS),
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS)).build()
                }, 1000, ModExtraLootProvider.ONION_SEEDS));

        this.add("metal_detector_from_jungle_temple",
                new AddTableLootModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("chests/jungle_temple")).build()
                }, 1000, ModExtraLootProvider.METAL_DETECTOR_FOUND));

        this.add("raw_azurite_from_creeper",
                new AddTableLootModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/creeper")).build()
                }, 1000, ModExtraLootProvider.RAW_AZURITE));
    }
}
