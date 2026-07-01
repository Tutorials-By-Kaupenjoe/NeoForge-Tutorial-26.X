package net.kaupenjoe.tutorialmod.sound;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TutorialMod.MOD_ID);

    public static final Supplier<SoundEvent> VALUABLES_FOUND = SOUND_EVENTS.register("valuables_found",
            () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "valuables_found")));
    public static final Supplier<SoundEvent> VALUABLES_NOT_FOUND = SOUND_EVENTS.register("valuables_not_found",
            () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "valuables_not_found")));


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
