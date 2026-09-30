package net.kaupenjoe.tutorialmod.creativemodetab;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITE.get()))
                    .title(Component.translatable("creativetab.tutorialmod.azurite_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .withTabsAfter(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "azurite_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AZURITE);
                        output.accept(ModItems.RAW_AZURITE);

                        output.accept(ModItems.METAL_DETECTOR);
                        output.accept(ModItems.ONION);
                        output.accept(ModItems.END_FIRE_STARTER);

                        output.accept(ModItems.AZURITE_SWORD);
                        output.accept(ModItems.AZURITE_PICKAXE);
                        output.accept(ModItems.AZURITE_SHOVEL);
                        output.accept(ModItems.AZURITE_AXE);
                        output.accept(ModItems.AZURITE_HOE);
                        output.accept(ModItems.AZURITE_SPEAR);

                        output.accept(ModItems.AZURITE_HELMET);
                        output.accept(ModItems.AZURITE_CHESTPLATE);
                        output.accept(ModItems.AZURITE_LEGGINGS);
                        output.accept(ModItems.AZURITE_BOOTS);

                        output.accept(ModItems.AZURITE_HORSE_ARMOR);

                        output.accept(ModItems.DATA_TABLET);
                        output.accept(ModItems.KAUPEN_BOW);
                        output.accept(ModItems.BLIZZARD_STAFF);

                        output.accept(ModItems.ONION_SEEDS);
                        output.accept(ModItems.GOJI_BERRIES);
                        output.accept(ModItems.RICE_SHOOT);

                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
                        output.accept(ModItems.RADIATION_STAFF);

                        output.accept(ModItems.DODO_SPAWN_EGG);
                        output.accept(ModItems.WARTURTLE_SPAWN_EGG);


                    }).build());


    public static final Supplier<CreativeModeTab> AZURITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("azurite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AZURITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.tutorialmod.azurite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AZURITE_BLOCK);
                        output.accept(ModBlocks.RAW_AZURITE_BLOCK);

                        output.accept(ModBlocks.AZURITE_ORE);
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE);
                        output.accept(ModBlocks.AZURITE_NETHER_ORE);
                        output.accept(ModBlocks.AZURITE_END_ORE);

                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModBlocks.AZURITE_STAIRS);
                        output.accept(ModBlocks.AZURITE_SLAB);
                        output.accept(ModBlocks.AZURITE_PRESSURE_PLATE);
                        output.accept(ModBlocks.AZURITE_BUTTON);
                        output.accept(ModBlocks.AZURITE_FENCE);
                        output.accept(ModBlocks.AZURITE_FENCE_GATE);
                        output.accept(ModBlocks.AZURITE_WALL);
                        output.accept(ModBlocks.AZURITE_DOOR);
                        output.accept(ModBlocks.AZURITE_TRAPDOOR);

                        output.accept(ModBlocks.AZURITE_LAMP);
                        output.accept(ModBlocks.PEDESTAL_BLOCK);

                        output.accept(ModBlocks.CRYSTALLIZER);

                        output.accept(ModBlocks.DRIFTWOOD_LOG);
                        output.accept(ModBlocks.DRIFTWOOD_WOOD);
                        output.accept(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        output.accept(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

                        output.accept(ModBlocks.DRIFTWOOD_PLANKS);
                        output.accept(ModBlocks.DRIFTWOOD_LEAVES);

                        output.accept(ModBlocks.DRIFTWOOD_SAPLING);
                        output.accept(ModBlocks.KAUPEN_PORTAL);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
