package net.kaupenjoe.tutorialmod.worldgen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
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
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    // Feature --> Any Type of "build"
    // A Tree ==> Feature -> once Configured (you give values)
    // CF -> Describes HOW something looks like, how it is built.
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AZURITE_ORE_KEY = registerKey("overworld_azurite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_AZURITE_ORE_KEY = registerKey("nether_azurite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_AZURITE_ORE_KEY = registerKey("end_azurite_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DRIFTWOOD_KEY = registerKey("driftwood");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GOJI_BERRY_BUSH_KEY = registerKey("goji_berry_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        register(context, OVERWORLD_AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.AZURITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.AZURITE_DEEPSLATE_ORE.get().defaultBlockState())),9));
        register(context, NETHER_AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.AZURITE_NETHER_ORE.get().defaultBlockState(), 7));
        register(context, END_AZURITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.AZURITE_END_ORE.get().defaultBlockState(), 12));

        register(context, DRIFTWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.DRIFTWOOD_LOG.get()),
                new SpiralTrunkPlacer(4, 3, 4),
                //new ForkingTrunkPlacer(4, 3, 4),

                BlockStateProvider.simple(ModBlocks.DRIFTWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2),
                BlockStateProvider.simple(Blocks.DIRT)).build());

        register(context, GOJI_BERRY_BUSH_KEY, Feature.SIMPLE_RANDOM_SELECTOR,
                new CompositeFeatureConfiguration(
                        HolderSet.direct(PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GOJI_BERRY_BUSH.get()
                                        .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))),
                                CountPlacement.of(32),
                                RandomOffsetPlacement.ofTriangle(6, 3),
                                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
