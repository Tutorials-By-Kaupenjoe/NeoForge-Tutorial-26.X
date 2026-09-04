package net.kaupenjoe.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.DodoEntity;
import net.kaupenjoe.tutorialmod.entity.variant.DodoVariant;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class DodoRenderer extends MobRenderer<DodoEntity, DodoRenderState, DodoModel> {
    private static final Map<DodoVariant, Identifier> VARIANT_TO_TEXTURE =
            Util.make(Maps.newEnumMap(DodoVariant.class), map -> {
                map.put(DodoVariant.DEFAULT, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/dodo/dodo.png"));
                map.put(DodoVariant.BLUE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/dodo/dodo_blue.png"));
    });

    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, new DodoModel(context.bakeLayer(ModModelLayerLocations.DODO)), 0.65f);
    }

    @Override
    public Identifier getTextureLocation(DodoRenderState state) {
        return VARIANT_TO_TEXTURE.get(state.variant); // Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/dodo/dodo.png");
    }

    @Override
    public DodoRenderState createRenderState() {
        return new DodoRenderState();
    }

    @Override
    public void extractRenderState(DodoEntity entity, DodoRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.variant = entity.getVariant();
    }
}
