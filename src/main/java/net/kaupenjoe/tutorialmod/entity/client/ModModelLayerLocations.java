package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayerLocations {
    public static final ModelLayerLocation DODO =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "dodo"), "main");

    public static final ModelLayerLocation WARTURTLE =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "warturtle"), "main");
    public static final ModelLayerLocation WARTURTLE_ARMOR =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "warturtle_armor"), "armor");
}
