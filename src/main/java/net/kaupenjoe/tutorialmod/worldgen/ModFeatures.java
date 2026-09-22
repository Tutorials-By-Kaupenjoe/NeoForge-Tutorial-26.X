package net.kaupenjoe.tutorialmod.worldgen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.worldgen.tree.InvertedPyramidFoliagePlacer;
import net.kaupenjoe.tutorialmod.worldgen.tree.SpiralTrunkPlacer;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.OffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModFeatures {
    // Feature --> Any Type of "build"
    // A Tree ==> Feature -> once Configured (you give values)
    // CF -> Describes HOW something looks like, how it is built.
    public static final ResourceKey<Feature> OVERWORLD_AZURITE_ORE_KEY = registerKey("overworld_azurite_ore");
    public static final ResourceKey<Feature> NETHER_AZURITE_ORE_KEY = registerKey("nether_azurite_ore");
    public static final ResourceKey<Feature> END_AZURITE_ORE_KEY = registerKey("end_azurite_ore");

    public static final ResourceKey<Feature> DRIFTWOOD_KEY = registerKey("driftwood");

    public static final ResourceKey<Feature> GOJI_BERRY_BUSH_KEY = registerKey("goji_berry_bush");

    public static void bootstrap(BootstrapContext<Feature> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        context.register(OVERWORLD_AZURITE_ORE_KEY, new OreFeature(List.of(
                BlockReplacement.replace(stoneReplaceables, ModBlocks.AZURITE_ORE.get().defaultBlockState()),
                BlockReplacement.replace(deepslateReplaceables, ModBlocks.AZURITE_DEEPSLATE_ORE.get().defaultBlockState())),9));
        context.register(NETHER_AZURITE_ORE_KEY, new OreFeature(netherrackReplaceables,
                ModBlocks.AZURITE_NETHER_ORE.get().defaultBlockState(), 7));
        context.register(END_AZURITE_ORE_KEY, new OreFeature(endReplaceables,
                ModBlocks.AZURITE_END_ORE.get().defaultBlockState(), 12));

        context.register(DRIFTWOOD_KEY, new TreeFeature.Builder(
                BlockStateProvider.of(ModBlocks.DRIFTWOOD_LOG.get()),
                new SpiralTrunkPlacer(4, 3, 4),
                //new ForkingTrunkPlacer(4, 3, 4),

                BlockStateProvider.of(ModBlocks.DRIFTWOOD_LEAVES.get()),
                new InvertedPyramidFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 3),
                // new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2),
                BlockStateProvider.holderOf(Blocks.DIRT)).build());

        context.register(GOJI_BERRY_BUSH_KEY, new SimpleRandomSelectorFeature(
                        HolderSet.direct(PlacementUtils.inlinePlaced(
                                new SimpleBlockFeature(BlockStateProvider.of(ModBlocks.GOJI_BERRY_BUSH.get())),
                                CountPlacement.of(96),
                                OffsetPlacement.ofTriangle(7, 3),
                                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
                        ))));
    }

    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
