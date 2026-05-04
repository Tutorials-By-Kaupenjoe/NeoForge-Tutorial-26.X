package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.block.ModBlocks;
import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "TutorialMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy(getHasName(ModItems.AZURITE.get()), has(ModItems.AZURITE))
                .group("azurite")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK)
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 18)
                .requires(ModBlocks.AZURITE_BLOCK)
                .requires(Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModBlocks.AZURITE_BLOCK.get()), has(ModBlocks.AZURITE_BLOCK))
                .group("azurite")
                .save(output, "tutorialmod:azurite_from_blaze_powder");

        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_AZURITE, ModBlocks.AZURITE_ORE,
                ModBlocks.AZURITE_DEEPSLATE_ORE, ModBlocks.AZURITE_NETHER_ORE, ModBlocks.AZURITE_END_ORE);

        oreSmelting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f, 200, "azurite");
        oreBlasting(AZURITE_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.AZURITE.get(), 0.25f, 100, "azurite");


    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, TutorialMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
