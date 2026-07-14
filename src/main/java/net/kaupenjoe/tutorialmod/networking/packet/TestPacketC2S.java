package net.kaupenjoe.tutorialmod.networking.packet;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record TestPacketC2S(String name, int value) implements CustomPacketPayload {
    public static final Type<TestPacketC2S> TYPE = new Type<>(Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "test_packet"));

    // Codec --> JSON FILES (reading and writing)
    // Turns Java Class (Sometimes Record) into a JSON file
    // Creates a Java Class instance from a JSON File

    // StreamCodec --> Networking
    // Turns Java Class (Record) into bits for the network
    // Turns "bits" from the network into a java class instance

    public static final StreamCodec<RegistryFriendlyByteBuf, TestPacketC2S> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            TestPacketC2S::name,

            ByteBufCodecs.VAR_INT,
            TestPacketC2S::value,

            TestPacketC2S::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
