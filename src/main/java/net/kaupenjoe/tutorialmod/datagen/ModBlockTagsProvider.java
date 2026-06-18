package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.RAW_AZURITE_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_DEEPSLATE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_NETHER_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_END_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.MAGIC_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_STAIRS.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_SLAB.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_PRESSURE_PLATE.get()))
                .add(ModBlocks.getRK(ModBlocks.AZURITE_LAMP.get()))
                .add(ModBlocks.getRK(ModBlocks.PEDESTAL_BLOCK.get()));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_DEEPSLATE_ORE.get()));
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_NETHER_ORE.get()));
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_END_ORE.get()));

        tag(ModTags.Blocks.METAL_DETECTABLES)
                .addTag(Tags.Blocks.ORES);

        tag(BlockTags.STAIRS)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_STAIRS.get()));
        tag(BlockTags.SLABS)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_SLAB.get()));
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_PRESSURE_PLATE.get()));
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.getRK(ModBlocks.AZURITE_BUTTON.get()));

        tag(BlockTags.FENCES).add(ModBlocks.getRK(ModBlocks.AZURITE_FENCE.get()));
        tag(BlockTags.FENCE_GATES).add(ModBlocks.getRK(ModBlocks.AZURITE_FENCE_GATE.get()));
        tag(BlockTags.WALLS).add(ModBlocks.getRK(ModBlocks.AZURITE_WALL.get()));

        tag(BlockTags.DOORS).add(ModBlocks.getRK(ModBlocks.AZURITE_DOOR.get()));
        tag(BlockTags.TRAPDOORS).add(ModBlocks.getRK(ModBlocks.AZURITE_TRAPDOOR.get()));

        tag(ModTags.Blocks.NEEDS_AZURITE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.MAGIC_BLOCK.get()))
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_AZURITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_AZURITE_TOOL);


    }
}
