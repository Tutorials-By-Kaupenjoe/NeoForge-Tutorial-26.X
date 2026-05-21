package net.kaupenjoe.tutorialmod.item;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.food.ModFoods;
import net.kaupenjoe.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
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
            properties -> new Item(properties.food(ModFoods.ONION, ModFoods.ONION_CONSUMABLE)) {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.tutorialmod.onion.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> END_FIRE_STARTER = ITEMS.registerItem("end_fire_starter",
            properties -> new Item(properties.stacksTo(32)));

    public static final DeferredItem<Item> AZURITE_SWORD = ITEMS.registerItem("azurite_sword",
            properties -> new Item(properties.sword(ModToolTiers.AZURITE, 3, -2.4f)));
    public static final DeferredItem<Item> AZURITE_PICKAXE = ITEMS.registerItem("azurite_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.AZURITE, 1, -2.8f)));
    public static final DeferredItem<Item> AZURITE_SHOVEL = ITEMS.registerItem("azurite_shovel",
            properties -> new ShovelItem(ModToolTiers.AZURITE, 1.5f, -3.0f, properties));
    public static final DeferredItem<Item> AZURITE_AXE = ITEMS.registerItem("azurite_axe",
            properties -> new AxeItem(ModToolTiers.AZURITE, 6, -3.2f, properties));
    public static final DeferredItem<Item> AZURITE_HOE = ITEMS.registerItem("azurite_hoe",
            properties -> new HoeItem(ModToolTiers.AZURITE, 0, -3.0f, properties));
    public static final DeferredItem<Item> AZURITE_SPEAR = ITEMS.registerItem("azurite_spear",
            properties -> new Item(properties.spear(ModToolTiers.AZURITE, 0.95f, 0.7f, 0.7f,
                    3.5f, 13f, 8.5f, 5.1f, 13.37f, 4.67f)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
