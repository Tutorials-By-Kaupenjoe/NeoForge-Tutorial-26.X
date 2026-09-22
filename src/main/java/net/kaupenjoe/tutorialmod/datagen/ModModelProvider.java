package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.block.custom.AzuriteLampBlock;
import net.kaupenjoe.tutorialmod.block.custom.GojiBerryBushBlock;
import net.kaupenjoe.tutorialmod.block.custom.OnionCropBlock;
import net.kaupenjoe.tutorialmod.block.custom.RiceCropBlock;
import net.kaupenjoe.tutorialmod.data.ModDataComponents;
import net.kaupenjoe.tutorialmod.item.ModArmorMaterials;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.data.PackOutput;

import java.util.Map;
import java.util.Optional;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.AZURITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_AZURITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.METAL_DETECTOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.ONION.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.END_FIRE_STARTER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.AZURITE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.AZURITE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.AZURITE_SPEAR.get());

        itemModels.generateTrimmableArmorSet(ModItems.AZURITE_HELMET.get(), ModItems.AZURITE_CHESTPLATE.get(), ModItems.AZURITE_LEGGINGS.get(), ModItems.AZURITE_BOOTS.get(),
                false, Map.of());

        itemModels.generateFlatItem(ModItems.AZURITE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        ItemModel.Unbaked unbakedDataTablet = ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.DATA_TABLET.get(), ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked unbakedDataTabletOn = ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.DATA_TABLET.get(), "_on", ModelTemplates.FLAT_ITEM));
        itemModels.itemModelOutput.register(ModItems.DATA_TABLET.get(),
                new ClientItem(new ConditionalItemModel.Unbaked(Optional.empty(), new HasComponent(ModDataComponents.COORDINATES.get(), false),
                        unbakedDataTabletOn, unbakedDataTablet), new ClientItem.Properties(false, false, 1f)));

        itemModels.createFlatItemModel(ModItems.KAUPEN_BOW.get(), ModelTemplates.BOW);
        itemModels.generateBow(ModItems.KAUPEN_BOW.get());

        itemModels.declareCustomModelItem(ModItems.BLIZZARD_STAFF.get());

        itemModels.generateFlatItem(ModItems.BAR_BRAWL_MUSIC_DISC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RADIATION_STAFF.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModels.generateFlatItem(ModItems.DODO_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);


        /* BLOCKS */
        // blockModels.createTrivialCube(ModBlocks.AZURITE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.RAW_AZURITE_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_NETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.AZURITE_END_ORE.get());
        blockModels.createTrivialCube(ModBlocks.MAGIC_BLOCK.get());

        blockModels.family(ModBlocks.AZURITE_BLOCK.get())
                .stairs(ModBlocks.AZURITE_STAIRS.get())
                .slab(ModBlocks.AZURITE_SLAB.get())
                .pressurePlate(ModBlocks.AZURITE_PRESSURE_PLATE.get())
                .button(ModBlocks.AZURITE_BUTTON.get())
                .fence(ModBlocks.AZURITE_FENCE.get())
                .fenceGate(ModBlocks.AZURITE_FENCE_GATE.get())
                .wall(ModBlocks.AZURITE_WALL.get())
                .door(ModBlocks.AZURITE_DOOR.get())
                .trapdoor(ModBlocks.AZURITE_TRAPDOOR.get());

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.AZURITE_LAMP.get()).with(BlockModelGenerators.createBooleanModelDispatch(AzuriteLampBlock.CLICKED,
                        BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ModBlocks.AZURITE_LAMP.get(), "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube)),
                        BlockModelGenerators.plainVariant(TexturedModel.CUBE.create(ModBlocks.AZURITE_LAMP.get(), blockModels.modelOutput)))));

        blockModels.createNonTemplateModelBlock(ModBlocks.PEDESTAL_BLOCK.get());

        blockModels.createCropBlock(ModBlocks.ONION_CROP.get(), OnionCropBlock.AGE, 0, 1, 2, 3);
        blockModels.createCropBlock(ModBlocks.GOJI_BERRY_BUSH.get(), GojiBerryBushBlock.AGE, 0, 1, 2, 3);
        blockModels.createCropBlock(ModBlocks.RICE_CROP.get(), RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

        blockModels.createFurnace(ModBlocks.CRYSTALLIZER.get(), TexturedModel.ORIENTABLE);

        blockModels.woodProvider(ModBlocks.DRIFTWOOD_LOG.get()).logWithHorizontal(ModBlocks.DRIFTWOOD_LOG.get()).wood(ModBlocks.DRIFTWOOD_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_DRIFTWOOD_LOG.get()).logWithHorizontal(ModBlocks.STRIPPED_DRIFTWOOD_LOG.get()).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.get());

        blockModels.createTrivialCube(ModBlocks.DRIFTWOOD_PLANKS.get());
        blockModels.createTintedLeaves(ModBlocks.DRIFTWOOD_LEAVES.get(), TexturedModel.LEAVES, -12012265);

        blockModels.createPlantWithDefaultItem(ModBlocks.DRIFTWOOD_SAPLING.get(), ModBlocks.POTTED_DRIFTWOOD_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        blockModels.createTrivialCube(ModBlocks.KAUPEN_PORTAL.get());
    }
}
