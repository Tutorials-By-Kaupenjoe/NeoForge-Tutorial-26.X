package net.kaupenjoe.tutorialmod.datagen;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.kaupenjoe.tutorialmod.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundsProvider extends SoundDefinitionsProvider {
    public ModSoundsProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID);
    }

    @Override
    public void registerSounds() {
        add(ModSounds.VALUABLES_FOUND.get(), definition().subtitle("sounds.tutorialmod.valuables_found")
                .with(sound(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "valuables_found"))));
        add(ModSounds.VALUABLES_NOT_FOUND.get(), definition().subtitle("sounds.tutorialmod.valuables_not_found")
                .with(sound(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "valuables_not_found"))));

    }
}
