package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.JukeboxSong;

public class ModJukeboxSongs {
    public static void bootstrap(BootstrapContext<JukeboxSong> context) {
        register(context, ModSounds.BAR_BRAWL_KEY, ((Holder.Reference<SoundEvent>) ModSounds.BAR_BRAWL.getDelegate()), 162, 15);

    }

    private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key,
                                 Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(soundEvent,
                Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())), lengthInSeconds, comparatorOutput));
    }
}
