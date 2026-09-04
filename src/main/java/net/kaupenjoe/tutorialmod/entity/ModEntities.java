package net.kaupenjoe.tutorialmod.entity;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.entity.custom.DodoEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.createEntities(TutorialMod.MOD_ID);

    public static final ResourceKey<EntityType<?>> DODO_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "dodo"));


    public static final Supplier<EntityType<DodoEntity>> DODO = ENTITY_TYPES.register("dodo",
            () -> EntityType.Builder.of(DodoEntity::new, MobCategory.CREATURE).sized(1f, 2.5f).build(DODO_KEY));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
