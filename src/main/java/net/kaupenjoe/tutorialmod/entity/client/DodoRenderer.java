package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.DodoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class DodoRenderer extends MobRenderer<DodoEntity, DodoRenderState, DodoModel> {
    public DodoRenderer(EntityRendererProvider.Context context) {
        super(context, new DodoModel(context.bakeLayer(ModModelLayerLocations.DODO)), 0.65f);
    }

    @Override
    public Identifier getTextureLocation(DodoRenderState state) {
        return Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "textures/entity/dodo/dodo.png");
    }

    @Override
    public DodoRenderState createRenderState() {
        return new DodoRenderState();
    }

    @Override
    public void extractRenderState(DodoEntity entity, DodoRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }
}
