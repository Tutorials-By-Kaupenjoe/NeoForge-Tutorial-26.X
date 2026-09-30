package net.kaupenjoe.tutorialmod.entity.client;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.item.ItemStack;

public class WarturtleRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState hidingAnimationState = new AnimationState();
    public final AnimationState emergeAnimationState = new AnimationState();
    public final AnimationState sittingAnimationState = new AnimationState();

    public boolean hasTier1Chest = false;
    public boolean hasTier2Chest = false;
    public boolean hasTier3Chest = false;

    public ItemStack armorItem = ItemStack.EMPTY;
}
