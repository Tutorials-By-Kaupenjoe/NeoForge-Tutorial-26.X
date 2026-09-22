package net.kaupenjoe.tutorialmod.datagen.villager;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.item.trading.VillagerTrades;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.List;
import java.util.Optional;

public class ModVillagerTrades {
    public static final ResourceKey<VillagerTrade> FARMER_1_EMERALD_ONION_SEEDS = createKey("farmer/1/emerald_onion_seeds");
    public static final ResourceKey<VillagerTrade> FARMER_1_DIAMOND_ONION = createKey("farmer/1/diamond_onion");

    public static final ResourceKey<VillagerTrade> FARMER_2_GOJI_BERRIES_EMERALD = createKey("farmer/2/goji_berries_emerald");

    public static final ResourceKey<VillagerTrade> LIBRARIAN_1_AZURITE_ENCHANTED = createKey("librarian/1/azurite_enchanted");


    public static final ResourceKey<VillagerTrade> KAUPENGER_1_EMERALD_METAL_DETECTOR = createKey("kaupenger/1/emerald_chisel");
    public static final ResourceKey<VillagerTrade> KAUPENGER_1_EMERALD_RAW_AZURITE = createKey("kaupenger/1/emerald_raw_azurite");

    public static final ResourceKey<VillagerTrade> KAUPENGER_2_EMERALD_METAL_DETECTOR = createKey("kaupenger/2/emerald_chisel");
    public static final ResourceKey<VillagerTrade> KAUPENGER_2_AZURITE_MAGIC_BLOCK = createKey("kaupenger/2/azurite_magic_block");


    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        var items = context.lookup(Registries.ITEM);
        var enchantments = context.lookup(Registries.ENCHANTMENT);

        context.register(FARMER_1_EMERALD_ONION_SEEDS, new VillagerTrade.Builder(
                new TradeCost(Items.EMERALD, 4),
                new ItemStackTemplate(ModItems.ONION_SEEDS, 2),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());
        context.register(FARMER_1_DIAMOND_ONION, new VillagerTrade.Builder(
                new TradeCost(Items.DIAMOND, 2),
                new ItemStackTemplate(ModItems.ONION, 10),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());

        context.register(FARMER_2_GOJI_BERRIES_EMERALD, new VillagerTrade.Builder(
                new TradeCost(ModItems.GOJI_BERRIES, 12),
                new ItemStackTemplate(Items.EMERALD),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());

        context.register(LIBRARIAN_1_AZURITE_ENCHANTED, new VillagerTrade.Builder(
                new TradeCost(ModItems.AZURITE, 32),
                new ItemStackTemplate(Items.ENCHANTED_BOOK),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f))
                        .addModifiers(VillagerTrades.enchantedBook(items,
                        HolderSet.direct(enchantments.getOrThrow(Enchantments.INFINITY),
                                enchantments.getOrThrow(Enchantments.MULTISHOT)))).build());


        context.register(KAUPENGER_1_EMERALD_METAL_DETECTOR, new VillagerTrade.Builder(
                new TradeCost(Items.EMERALD, 12),
                new ItemStackTemplate(ModItems.METAL_DETECTOR, 1),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());
        context.register(KAUPENGER_1_EMERALD_RAW_AZURITE, new VillagerTrade.Builder(
                new TradeCost(Items.EMERALD, 12),
                new ItemStackTemplate(ModItems.RAW_AZURITE, 1),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());

        context.register(KAUPENGER_2_EMERALD_METAL_DETECTOR, new VillagerTrade.Builder(
                new TradeCost(Items.EMERALD, 10),
                new ItemStackTemplate(ModItems.METAL_DETECTOR, 1),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());
        context.register(KAUPENGER_2_AZURITE_MAGIC_BLOCK, new VillagerTrade.Builder(
                new TradeCost(ModItems.AZURITE, 10),
                new ItemStackTemplate(ModBlocks.MAGIC_BLOCK.asItem(), 1),
                ContextIntProviders.exactly(12), ContextIntProviders.exactly(6), ContextFloatProviders.exactly(0.05f)).build());
    }


    private static ResourceKey<VillagerTrade> createKey(String name) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
