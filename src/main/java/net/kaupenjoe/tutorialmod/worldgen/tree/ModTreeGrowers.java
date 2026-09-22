package net.kaupenjoe.tutorialmod.worldgen.tree;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.worldgen.ModFeatures;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower DRIFTWOOD = new TreeGrower(TutorialMod.MOD_ID + ":driftwood",
            WeightedList.of(ModFeatures.DRIFTWOOD_KEY), WeightedList.of(), WeightedList.of(), null);
}
