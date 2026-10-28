package net.kaupenjoe.tutorialmod.datagen;

import com.google.common.collect.ImmutableList;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.CopyPropertiesProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;

public class ModBlockTransformers {
    public static void bootstrap(BootstrapContext<BlockTransformer> context) {
        context.register(BlockTransformers.AXE,
                new BlockTransformer(ImmutableList.<BlockTransformer.BlockTransformData>builder()
                        .add(BlockTransformer.BlockTransformData.builder(
                                RuleBasedStateProvider.builder()
                                        .ifTrueThenProvide(BlockPredicate.matchesBlocks(
                                                ModBlocks.DRIFTWOOD_LOG.get()
                                                ),
                                                new CopyPropertiesProvider(
                                                        ModBlocks.STRIPPED_DRIFTWOOD_LOG.get()
                                                ))

                                        .ifTrueThenProvide(BlockPredicate.matchesBlocks(
                                                ModBlocks.STRIPPED_DRIFTWOOD_WOOD.get()
                                                ),
                                                new CopyPropertiesProvider(
                                                        ModBlocks.STRIPPED_DRIFTWOOD_WOOD.get()
                                                ))

                                        .build())
                                .sound(SoundEvents.AXE_STRIP)
                                .build()).build()));
    }
}
