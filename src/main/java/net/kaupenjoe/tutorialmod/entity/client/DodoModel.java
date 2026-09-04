package net.kaupenjoe.tutorialmod.entity.client;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DodoModel extends EntityModel<DodoRenderState> {
    private final ModelPart body;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    private final ModelPart main_body;
    private final ModelPart left_leg;
    private final ModelPart left_leg_upper;
    private final ModelPart left_leg_lower;
    private final ModelPart left_foot;
    private final ModelPart left_back_toe;
    private final ModelPart left_front_toes;
    private final ModelPart left_right_toe;
    private final ModelPart left_left_toe;
    private final ModelPart right_leg;
    private final ModelPart right_leg_upper;
    private final ModelPart right_leg_lower;
    private final ModelPart right_foot;
    private final ModelPart right_back_toe;
    private final ModelPart right_front_toes;
    private final ModelPart right_right_toe;
    private final ModelPart right_left_toe;
    private final ModelPart chest;
    private final ModelPart lower_chest;
    private final ModelPart neck;
    private final ModelPart middle_neck;
    private final ModelPart head;

    private final KeyframeAnimation walkingAnimation;
    private final KeyframeAnimation idlingAnimation;

    public DodoModel(ModelPart root) {
        super(root);
        this.body = root.getChild("body");
        this.left_wing = this.body.getChild("left_wing");
        this.right_wing = this.body.getChild("right_wing");
        this.main_body = this.body.getChild("main_body");
        this.left_leg = this.body.getChild("left_leg");
        this.left_leg_upper = this.left_leg.getChild("left_leg_upper");
        this.left_leg_lower = this.left_leg.getChild("left_leg_lower");
        this.left_foot = this.left_leg_lower.getChild("left_foot");
        this.left_back_toe = this.left_foot.getChild("left_back_toe");
        this.left_front_toes = this.left_foot.getChild("left_front_toes");
        this.left_right_toe = this.left_front_toes.getChild("left_right_toe");
        this.left_left_toe = this.left_front_toes.getChild("left_left_toe");
        this.right_leg = this.body.getChild("right_leg");
        this.right_leg_upper = this.right_leg.getChild("right_leg_upper");
        this.right_leg_lower = this.right_leg.getChild("right_leg_lower");
        this.right_foot = this.right_leg_lower.getChild("right_foot");
        this.right_back_toe = this.right_foot.getChild("right_back_toe");
        this.right_front_toes = this.right_foot.getChild("right_front_toes");
        this.right_right_toe = this.right_front_toes.getChild("right_right_toe");
        this.right_left_toe = this.right_front_toes.getChild("right_left_toe");
        this.chest = this.body.getChild("chest");
        this.lower_chest = this.chest.getChild("lower_chest");
        this.neck = this.chest.getChild("neck");
        this.middle_neck = this.neck.getChild("middle_neck");
        this.head = this.neck.getChild("head");

        this.walkingAnimation = DodoAnimations.WALK.bake(root);
        this.idlingAnimation = DodoAnimations.IDLE.bake(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition bottom_fan_r1 = body.addOrReplaceChild("bottom_fan_r1", CubeListBuilder.create().texOffs(101, 29).addBox(-3.5F, -7.0F, 6.0F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -1.0F, -0.464F, 0.0F, 0.0F));

        PartDefinition top_fan_r1 = body.addOrReplaceChild("top_fan_r1", CubeListBuilder.create().texOffs(55, 25).addBox(-5.5F, -13.0F, 4.0F, 11.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, -0.6882F, 0.0F, 0.0F));

        PartDefinition left_fan_r1 = body.addOrReplaceChild("left_fan_r1", CubeListBuilder.create().texOffs(45, 28).addBox(0.0F, -14.0F, -1.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 4.0F, 5.0F, -0.1569F, 0.3357F, 0.0493F));

        PartDefinition right_fan_r1 = body.addOrReplaceChild("right_fan_r1", CubeListBuilder.create().texOffs(45, 28).addBox(0.0F, -14.0F, -1.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 4.0F, 5.0F, -0.1569F, -0.3357F, 0.05F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offset(5.0F, -5.0F, -5.0F));

        PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(83, 21).addBox(1.0038F, -1.4886F, -5.0076F, 1.0F, 10.0F, 16.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0046F, 0.0879F, -0.1728F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(83, 21).addBox(-2.013F, -1.4962F, -5.0084F, 1.0F, 10.0F, 16.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-5.0F, -5.0F, -5.0F, 0.0211F, -0.217F, 0.22F));

        PartDefinition main_body = body.addOrReplaceChild("main_body", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -3.0F));

        PartDefinition main_body_r1 = main_body.addOrReplaceChild("main_body_r1", CubeListBuilder.create().texOffs(0, 36).addBox(-6.0F, -5.0F, -8.0F, 12.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0015F, 0.0F, 0.0F));

        PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 4.0F, -1.5F, 0.0F, 3.1416F, 0.0F));

        PartDefinition left_leg_upper = left_leg.addOrReplaceChild("left_leg_upper", CubeListBuilder.create().texOffs(60, 49).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_leg_lower = left_leg.addOrReplaceChild("left_leg_lower", CubeListBuilder.create().texOffs(79, 48).addBox(-1.5F, 0.0069F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.1F))
                .texOffs(79, 112).addBox(-1.5F, 0.0069F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.35F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition left_foot = left_leg_lower.addOrReplaceChild("left_foot", CubeListBuilder.create(), PartPose.offset(-3.5F, -11.0F, 2.5F));

        PartDefinition left_back_toe = left_foot.addOrReplaceChild("left_back_toe", CubeListBuilder.create(), PartPose.offset(10.5F, 24.0F, 0.0F));

        PartDefinition right_back_toe_r1 = left_back_toe.addOrReplaceChild("right_back_toe_r1", CubeListBuilder.create().texOffs(104, 53).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -1.0F, -3.0F, -2.7489F, 0.0F, 0.0F));

        PartDefinition left_front_toes = left_foot.addOrReplaceChild("left_front_toes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition left_right_toe = left_front_toes.addOrReplaceChild("left_right_toe", CubeListBuilder.create(), PartPose.offset(3.5F, 24.0F, 0.0F));

        PartDefinition left_right_toe_r1 = left_right_toe.addOrReplaceChild("left_right_toe_r1", CubeListBuilder.create().texOffs(92, 54).addBox(-2.0F, -1.0F, -6.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 3.1416F, -0.0873F, -3.1416F));

        PartDefinition left_left_toe = left_front_toes.addOrReplaceChild("left_left_toe", CubeListBuilder.create(), PartPose.offset(3.5F, 24.0F, 0.0F));

        PartDefinition left_left_toe_r1 = left_left_toe.addOrReplaceChild("left_left_toe_r1", CubeListBuilder.create().texOffs(92, 54).addBox(0.0F, -1.0F, -6.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 3.1416F, 0.0873F, -3.1416F));

        PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5F, 4.0F, -1.5F, 0.0F, 3.1416F, 0.0F));

        PartDefinition right_leg_upper = right_leg.addOrReplaceChild("right_leg_upper", CubeListBuilder.create().texOffs(60, 49).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg_lower = right_leg.addOrReplaceChild("right_leg_lower", CubeListBuilder.create().texOffs(79, 112).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.35F))
                .texOffs(79, 48).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition right_foot = right_leg_lower.addOrReplaceChild("right_foot", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 13.0F, 0.5F, 0.1745F, 0.0F, 0.0F));

        PartDefinition right_back_toe = right_foot.addOrReplaceChild("right_back_toe", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_back_toe_r2 = right_back_toe.addOrReplaceChild("right_back_toe_r2", CubeListBuilder.create().texOffs(104, 53).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, -2.9671F, 0.0F, 0.0F));

        PartDefinition right_front_toes = right_foot.addOrReplaceChild("right_front_toes", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition right_right_toe = right_front_toes.addOrReplaceChild("right_right_toe", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition right_right_toe_r1 = right_right_toe.addOrReplaceChild("right_right_toe_r1", CubeListBuilder.create().texOffs(92, 54).addBox(-2.0F, -1.0F, -6.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 3.1416F, -0.0873F, -3.1416F));

        PartDefinition right_left_toe = right_front_toes.addOrReplaceChild("right_left_toe", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition right_left_toe_r1 = right_left_toe.addOrReplaceChild("right_left_toe_r1", CubeListBuilder.create().texOffs(92, 54).addBox(0.0F, -1.0F, -6.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 3.1416F, 0.0873F, -3.1416F));

        PartDefinition chest = body.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition lower_chest = chest.addOrReplaceChild("lower_chest", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, 19.0F));

        PartDefinition lower_chest_r1 = lower_chest.addOrReplaceChild("lower_chest_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -12.0F, -8.5F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 14.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition middle_neck = neck.addOrReplaceChild("middle_neck", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 1.0F));

        PartDefinition middle_neck_r1 = middle_neck.addOrReplaceChild("middle_neck_r1", CubeListBuilder.create().texOffs(36, 20).addBox(-2.0F, -12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0023F, 0.0F, 0.0F));

        PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 1.0F));

        PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -46.0F, -8.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 40.0F, 0.0F, 3.1416F, 0.0F, 3.1416F));

        PartDefinition eye_mirrored_r1 = head.addOrReplaceChild("eye_mirrored_r1", CubeListBuilder.create().texOffs(100, 0).mirror().addBox(-3.25F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(100, 0).addBox(2.25F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition right_crest_r1 = head.addOrReplaceChild("right_crest_r1", CubeListBuilder.create().texOffs(2, 2).addBox(2.0F, -6.0F, 4.5F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.9322F, 0.0F));

        PartDefinition top_crest_r1 = head.addOrReplaceChild("top_crest_r1", CubeListBuilder.create().texOffs(20, 0).addBox(-2.5F, 5.0F, 5.0F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.9322F, 0.0F, 0.0F));

        PartDefinition left_crest_r1 = head.addOrReplaceChild("left_crest_r1", CubeListBuilder.create().texOffs(2, 2).addBox(-2.0F, -6.0F, 4.5F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.9322F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(DodoRenderState state) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(state.yRot, state.xRot);

        this.walkingAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }
}
