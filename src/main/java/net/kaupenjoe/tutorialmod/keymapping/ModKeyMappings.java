package net.kaupenjoe.tutorialmod.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    private static final KeyMapping KEY_MAPPING_KAUPEN = new KeyMapping("key.tutorialmod.kaupen",
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, KeyMapping.Category.MISC);
    public static final Lazy<KeyMapping> PRESS_KAUPEN = Lazy.of(() -> KEY_MAPPING_KAUPEN);


    public static void register() {

    }
}
