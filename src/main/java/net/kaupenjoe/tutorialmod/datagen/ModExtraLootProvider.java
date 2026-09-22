package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModExtraLootProvider implements LootTableSubProvider {
    public static final ResourceKey<LootTable> ONION_SEEDS = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "extra/glm/onion_seeds"));
    public static final ResourceKey<LootTable> METAL_DETECTOR_FOUND = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "extra/glm/metal_detector_found"));
    public static final ResourceKey<LootTable> RAW_AZURITE = ResourceKey.create(Registries.LOOT_TABLE,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "extra/glm/raw_azurite"));

    private final LootTableSubProvider.Context context;

    public ModExtraLootProvider(LootTableSubProvider.Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        context.accept(ONION_SEEDS,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.25f))
                        .add(LootItem.lootTableItem(ModItems.ONION_SEEDS.get()))));

        context.accept(METAL_DETECTOR_FOUND, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(1f)) // Drops 100% of the time
                        .add(LootItem.lootTableItem(ModItems.METAL_DETECTOR))
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 2)))));

        context.accept(RAW_AZURITE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .when(LootItemRandomChanceCondition.randomChance(0.5f)) // Drops 50% of the time
                        .add(LootItem.lootTableItem(ModItems.RAW_AZURITE))
                        .apply(SetItemCountFunction.setCount(ContextIntProviders.between(2, 4)))));
    }
}
