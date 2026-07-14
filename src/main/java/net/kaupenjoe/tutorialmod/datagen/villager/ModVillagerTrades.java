package net.kaupenjoe.tutorialmod.datagen.villager;

import net.kaupenjoe.tutorialmod.TutorialMod;
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

import java.util.List;
import java.util.Optional;

public class ModVillagerTrades {
    public static final ResourceKey<VillagerTrade> FARMER_1_EMERALD_ONION_SEEDS = createKey("farmer/1/emerald_onion_seeds");
    public static final ResourceKey<VillagerTrade> FARMER_1_DIAMOND_ONION = createKey("farmer/1/diamond_onion");

    public static final ResourceKey<VillagerTrade> FARMER_2_GOJI_BERRIES_EMERALD = createKey("farmer/2/goji_berries_emerald");

    public static final ResourceKey<VillagerTrade> LIBRARIAN_1_AZURITE_ENCHANTED = createKey("librarian/1/azurite_enchanted");

    public static void bootstrap(BootstrapContext<VillagerTrade> context) {
        var items = context.lookup(Registries.ITEM);
        var enchantments = context.lookup(Registries.ENCHANTMENT);

        context.register(FARMER_1_EMERALD_ONION_SEEDS, new VillagerTrade(
                new TradeCost(Items.EMERALD, 4),
                new ItemStackTemplate(ModItems.ONION_SEEDS, 2),
                12, 6, 0.05f, Optional.empty(), List.of()));
        context.register(FARMER_1_DIAMOND_ONION, new VillagerTrade(
                new TradeCost(Items.DIAMOND, 2),
                new ItemStackTemplate(ModItems.ONION, 10),
                9, 6, 0.05f, Optional.empty(), List.of()));

        context.register(FARMER_2_GOJI_BERRIES_EMERALD, new VillagerTrade(
                new TradeCost(ModItems.GOJI_BERRIES, 12),
                new ItemStackTemplate(Items.EMERALD),
                12, 6, 0.05f, Optional.empty(), List.of()));

        context.register(LIBRARIAN_1_AZURITE_ENCHANTED, new VillagerTrade(
                new TradeCost(ModItems.AZURITE, 32),
                new ItemStackTemplate(Items.ENCHANTED_BOOK),
                12, 6, 0.05f,
                Optional.empty(),
                VillagerTrades.enchantedBook(items,
                        HolderSet.direct(enchantments.getOrThrow(Enchantments.INFINITY),
                                enchantments.getOrThrow(Enchantments.MULTISHOT)))));

    }


    private static ResourceKey<VillagerTrade> createKey(String name) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}
