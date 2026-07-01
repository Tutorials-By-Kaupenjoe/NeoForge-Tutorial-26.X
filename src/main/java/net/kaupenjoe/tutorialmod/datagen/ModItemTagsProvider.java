package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.kaupenjoe.tutorialmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ItemIds.IRON_INGOT)
                .add(BlockItemIds.REDSTONE_DUST.item())
                .add(ItemIds.COPPER_INGOT)
                .add(ModItems.getRK(ModItems.AZURITE.get()));

        tag(ModTags.Items.AZURITE_REPAIRABLE)
                .add(ModItems.getRK(ModItems.AZURITE.get()));

        tag(ItemTags.SWORDS).add(ModItems.getRK(ModItems.AZURITE_SWORD.get()));
        tag(ItemTags.PICKAXES).add(ModItems.getRK(ModItems.AZURITE_PICKAXE.get()));
        tag(ItemTags.SHOVELS).add(ModItems.getRK(ModItems.AZURITE_SHOVEL.get()));
        tag(ItemTags.AXES).add(ModItems.getRK(ModItems.AZURITE_AXE.get()));
        tag(ItemTags.HOES).add(ModItems.getRK(ModItems.AZURITE_HOE.get()));
        tag(ItemTags.SPEARS).add(ModItems.getRK(ModItems.AZURITE_SPEAR.get()));

        tag(ItemTags.HEAD_ARMOR).add(ModItems.getRK(ModItems.AZURITE_HELMET.get()));
        tag(ItemTags.CHEST_ARMOR).add(ModItems.getRK(ModItems.AZURITE_CHESTPLATE.get()));
        tag(ItemTags.LEG_ARMOR).add(ModItems.getRK(ModItems.AZURITE_LEGGINGS.get()));
        tag(ItemTags.FOOT_ARMOR).add(ModItems.getRK(ModItems.AZURITE_BOOTS.get()));

        tag(ItemTags.BOW_ENCHANTABLE).add(ModItems.getRK(ModItems.KAUPEN_BOW.get()));

        tag(ItemTags.CREEPER_DROP_MUSIC_DISCS).add(ModItems.getRK(ModItems.BAR_BRAWL_MUSIC_DISC.get()));

    }
}
