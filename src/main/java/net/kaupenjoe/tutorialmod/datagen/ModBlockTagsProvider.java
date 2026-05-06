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
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.RAW_AZURITE_BLOCK.get())
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.AZURITE_PRESSURE_PLATE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AZURITE_NETHER_ORE.get());
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.AZURITE_END_ORE.get());

        tag(ModTags.Blocks.METAL_DETECTABLES)
                .addTag(Tags.Blocks.ORES);

        tag(BlockTags.STAIRS)
                .add(ModBlocks.AZURITE_STAIRS.get());
        tag(BlockTags.SLABS)
                .add(ModBlocks.AZURITE_SLAB.get());
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.AZURITE_PRESSURE_PLATE.get());
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.AZURITE_BUTTON.get());

        tag(BlockTags.FENCES).add(ModBlocks.AZURITE_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.AZURITE_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.AZURITE_WALL.get());


    }
}
