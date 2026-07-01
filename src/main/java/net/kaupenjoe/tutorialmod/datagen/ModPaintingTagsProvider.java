package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagsProvider extends PaintingVariantTagsProvider {
    public ModPaintingTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE)
                .add(TagEntry.optionalElement(ModPaintings.SAW_THEM_KEY.identifier()))
                .add(TagEntry.optionalElement(ModPaintings.SHRIMP_KEY.identifier()))
                .add(TagEntry.optionalElement(ModPaintings.WORLD_KEY.identifier()))
                .add(TagEntry.optionalElement(ModPaintings.WANDERER_KEY.identifier()));
    }
}
