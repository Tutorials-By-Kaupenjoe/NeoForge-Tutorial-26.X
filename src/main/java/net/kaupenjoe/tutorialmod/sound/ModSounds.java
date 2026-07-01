package net.kaupenjoe.tutorialmod.sound;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TutorialMod.MOD_ID);

    public static final Supplier<SoundEvent> VALUABLES_FOUND = SOUND_EVENTS.register("valuables_found",
            () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "valuables_found")));
    public static final Supplier<SoundEvent> VALUABLES_NOT_FOUND = SOUND_EVENTS.register("valuables_not_found",
            () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "valuables_not_found")));

    public static final DeferredHolder<SoundEvent, SoundEvent> BAR_BRAWL = registerJukeboxSong("bar_brawl");
    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = createSong("bar_brawl");


    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static DeferredHolder<SoundEvent, SoundEvent> registerJukeboxSong(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
