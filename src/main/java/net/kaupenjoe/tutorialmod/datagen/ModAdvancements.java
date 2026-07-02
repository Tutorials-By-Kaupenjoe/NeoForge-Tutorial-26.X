package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.ItemUsedOnLocationTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.minecraft.advancements.triggers.ItemUsedOnLocationTrigger.TriggerInstance.placedBlock;

public class ModAdvancements extends AdvancementProvider {
    public ModAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new TutorialModAdvancements()));
    }

    public static class TutorialModAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
            var items = registries.lookupOrThrow(Registries.ITEM);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModItems.AZURITE,
                            Component.translatable("advancements.tutorialmod.root.title"),
                            Component.translatable("advancements.tutorialmod.root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false
                    )
                    .addCriterion("has_azurite", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.AZURITE.asItem())))
                    .save(output, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorialmod/root"));

            AdvancementHolder plantSeed = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.RICE_SHOOT,
                            Component.translatable("advancements.tutorialmod.plant_custom.title"),
                            Component.translatable("advancements.tutorialmod.plant_custom.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .requirements(AdvancementRequirements.Strategy.OR)
                    .addCriterion("berries", placedBlock(ModBlocks.GOJI_BERRY_BUSH.get()))
                    .addCriterion("rice", placedBlock(ModBlocks.RICE_CROP.get()))
                    .addCriterion("onion", placedBlock(ModBlocks.ONION_CROP.get()))
                    .save(output, "tutorialmod/plant_custom");

            AdvancementHolder metalDetector = Advancement.Builder.advancement()
                    .parent(plantSeed)
                    .display(
                            ModItems.METAL_DETECTOR,
                            Component.translatable("advancements.tutorialmod.metal_detector.title"),
                            Component.translatable("advancements.tutorialmod.metal_detector.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("metal_detector", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setCanSeeSky(true),
                            ItemPredicate.Builder.item().of(items, ModItems.METAL_DETECTOR.asItem())))
                    .save(output, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "tutorialmod/metal_detector"));

        }
    }
}
