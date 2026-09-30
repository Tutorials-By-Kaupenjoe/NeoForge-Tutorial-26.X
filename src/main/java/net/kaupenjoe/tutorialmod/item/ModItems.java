package net.kaupenjoe.tutorialmod.item;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.entity.ModEntities;
import net.kaupenjoe.tutorialmod.food.ModFoods;
import net.kaupenjoe.tutorialmod.item.custom.DataTabletItem;
import net.kaupenjoe.tutorialmod.item.custom.MetalDetectorItem;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> AZURITE = ITEMS.registerSimpleItem("azurite");
    public static final DeferredItem<Item> RAW_AZURITE = ITEMS.registerSimpleItem("raw_azurite");

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("metal_detector",
            properties -> new MetalDetectorItem(properties.durability(64)));

    public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion",
            properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE).compostable(ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH)) {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.tutorialmod.onion.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> END_FIRE_STARTER = ITEMS.registerItem("end_fire_starter",
            properties -> new Item(properties.stacksTo(32).cookingFuel(ContextIntProviders.COOKING_TIME_COAL_BLOCK)));

    public static final DeferredItem<Item> AZURITE_SWORD = ITEMS.registerItem("azurite_sword",
            properties -> new Item(properties.sword(ModToolTiers.AZURITE, 3, -2.4f)));
    public static final DeferredItem<Item> AZURITE_PICKAXE = ITEMS.registerItem("azurite_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.AZURITE, 1, -2.8f)));
    public static final DeferredItem<Item> AZURITE_SHOVEL = ITEMS.registerItem("azurite_shovel",
            properties -> new Item(properties.shovel(ModToolTiers.AZURITE, 1.5f, -3.0f)));
    public static final DeferredItem<Item> AZURITE_AXE = ITEMS.registerItem("azurite_axe",
            properties -> new Item(properties.axe(ModToolTiers.AZURITE, 6, -3.2f)));
    public static final DeferredItem<Item> AZURITE_HOE = ITEMS.registerItem("azurite_hoe",
            properties -> new Item(properties.hoe(ModToolTiers.AZURITE, 0, -3.0f)));
    public static final DeferredItem<Item> AZURITE_SPEAR = ITEMS.registerItem("azurite_spear",
            properties -> new Item(properties.spear(ModToolTiers.AZURITE, 0.95f, 0.7f, 0.7f,
                    3.5f, 13f, 8.5f, 5.1f, 13.37f, 4.67f)));

    public static final DeferredItem<Item> AZURITE_HELMET = ITEMS.registerItem("azurite_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> AZURITE_CHESTPLATE = ITEMS.registerItem("azurite_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> AZURITE_LEGGINGS = ITEMS.registerItem("azurite_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> AZURITE_BOOTS = ITEMS.registerItem("azurite_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> AZURITE_HORSE_ARMOR = ITEMS.registerItem("azurite_horse_armor",
            properties -> new Item(properties.horseArmor(ModArmorMaterials.AZURITE_ARMOR_MATERIAL)));

    public static final DeferredItem<Item> DATA_TABLET = ITEMS.registerItem("data_tablet",
            properties -> new DataTabletItem(properties.stacksTo(1)));

    public static final DeferredItem<Item> KAUPEN_BOW = ITEMS.registerItem("kaupen_bow",
            properties -> new BowItem(properties.durability(500)));

    public static final DeferredItem<Item> BLIZZARD_STAFF = ITEMS.registerItem("blizzard_staff",
            properties -> new Item(properties.stacksTo(1)));

    public static final DeferredItem<Item> ONION_SEEDS = ITEMS.registerItem("onion_seeds",
            properties -> new BlockItem(ModBlocks.ONION_CROP.get(), properties.compostable(ContextIntProviders.COMPOSTABLE_LOW)));
    public static final DeferredItem<Item> GOJI_BERRIES = ITEMS.registerItem("goji_berries",
            properties -> new BlockItem(ModBlocks.GOJI_BERRY_BUSH.get(), properties.food(ModFoods.GOJI_BERRIES)));

    public static final DeferredItem<Item> RICE_SHOOT = ITEMS.registerItem("rice_shoot",
            properties -> new PlaceOnWaterBlockItem(ModBlocks.RICE_CROP.get(), properties));

    public static final DeferredItem<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.registerItem("bar_brawl_music_disc",
            properties -> new Item(properties.jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).rarity(Rarity.EPIC).stacksTo(1)));

    public static final DeferredItem<Item> RADIATION_STAFF = ITEMS.registerItem("radiation_staff",
            properties -> new Item(properties.rarity(Rarity.EPIC).stacksTo(1)));

    public static final DeferredItem<Item> DODO_SPAWN_EGG = ITEMS.registerItem("dodo_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.DODO.get())));
    public static final DeferredItem<Item> WARTURTLE_SPAWN_EGG = ITEMS.registerItem("warturtle_spawn_egg",
            properties -> new SpawnEggItem(properties.spawnEgg(ModEntities.WARTURTLE.get())));

    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
