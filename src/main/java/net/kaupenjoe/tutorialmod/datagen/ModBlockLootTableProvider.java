package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.custom.OnionCropBlock;
import net.kaupenjoe.tutorialmod.block.custom.RiceCropBlock;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchBlock;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(LootTableSubProvider.Context context) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), context);
    }

    @Override
    protected void generate() {
        var enchantments = output.lookup(Registries.ENCHANTMENT);

        dropSelf(ModBlocks.AZURITE_BLOCK.get());
        dropSelf(ModBlocks.RAW_AZURITE_BLOCK.get());

        add(ModBlocks.AZURITE_ORE.get(),
                createOreDrop(ModBlocks.AZURITE_ORE.get(), ModItems.RAW_AZURITE.get()));
        add(ModBlocks.AZURITE_DEEPSLATE_ORE.get(),
                createOreDrop(ModBlocks.AZURITE_DEEPSLATE_ORE.get(), ModItems.RAW_AZURITE.get()));

        add(ModBlocks.AZURITE_NETHER_ORE.get(),
                createMultipleOreDrops(ModBlocks.AZURITE_NETHER_ORE.get(), ModItems.RAW_AZURITE.get(), 4, 7));
        add(ModBlocks.AZURITE_END_ORE.get(),
                createMultipleOreDrops(ModBlocks.AZURITE_END_ORE.get(), ModItems.RAW_AZURITE.get(), 5, 9));

        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.AZURITE_STAIRS.get());
        add(ModBlocks.AZURITE_SLAB.get(), this::createSlabItemTable);

        dropSelf(ModBlocks.AZURITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.AZURITE_BUTTON.get());
        dropSelf(ModBlocks.AZURITE_FENCE.get());
        dropSelf(ModBlocks.AZURITE_FENCE_GATE.get());
        dropSelf(ModBlocks.AZURITE_WALL.get());
        dropSelf(ModBlocks.AZURITE_TRAPDOOR.get());

        add(ModBlocks.AZURITE_DOOR.get(), this::createDoorTable);

        dropSelf(ModBlocks.AZURITE_LAMP.get());
        dropSelf(ModBlocks.PEDESTAL_BLOCK.get());
        dropSelf(ModBlocks.CRYSTALLIZER.get());

        add(ModBlocks.ONION_CROP.get(), createCropDrops(ModBlocks.ONION_CROP.get(),
                ModItems.ONION.get(), ModItems.ONION_SEEDS.get(), MatchBlock.blockMatches(blocks, ModBlocks.ONION_CROP.get(),
                        StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 3))));

        this.add(ModBlocks.GOJI_BERRY_BUSH.get(), block -> this.applyExplosionDecay(block, LootTable.lootTable().withPool(
                LootPool.lootPool().when(MatchBlock.blockMatches(blocks, ModBlocks.GOJI_BERRY_BUSH.get(),
                                StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(ModItems.GOJI_BERRIES))
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 3)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
        ).withPool(LootPool.lootPool().when(MatchBlock.blockMatches(blocks, ModBlocks.GOJI_BERRY_BUSH.get(),
                                StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                        ).add(LootItem.lootTableItem(ModItems.GOJI_BERRIES))
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
        )));


        add(ModBlocks.RICE_CROP.get(), createCropDrops(ModBlocks.RICE_CROP.get(),
                ModItems.RICE_SHOOT.get(), ModItems.RICE_SHOOT.get(), MatchBlock.blockMatches(blocks, ModBlocks.RICE_CROP.get(),
                        StatePropertiesPredicate.Builder.properties().hasProperty(RiceCropBlock.AGE, 7))));


        dropSelf(ModBlocks.DRIFTWOOD_LOG.get());
        dropSelf(ModBlocks.DRIFTWOOD_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_DRIFTWOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.get());
        dropSelf(ModBlocks.DRIFTWOOD_PLANKS.get());
        dropSelf(ModBlocks.DRIFTWOOD_SAPLING.get());

        add(ModBlocks.DRIFTWOOD_LEAVES.get(), block -> createLeavesDrops(block, ModBlocks.DRIFTWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.POTTED_DRIFTWOOD_SAPLING.get(), createPotFlowerItemTable(ModBlocks.DRIFTWOOD_SAPLING));

        dropSelf(ModBlocks.KAUPEN_PORTAL.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, int minDrops, int maxDrops) {
        var enchantments = this.output.lookup(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
