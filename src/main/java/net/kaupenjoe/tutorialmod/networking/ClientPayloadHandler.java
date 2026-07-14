package net.kaupenjoe.tutorialmod.networking;

import net.kaupenjoe.tutorialmod.networking.packet.TestPacketC2S;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.neoforged.neoforge.network.handling.IPayloadContext;

// Handle Packets FROM THE CLIENT to the Server
public class ClientPayloadHandler {
    // HERE WE ARE ON THE SERVER
    public static void handleTestPacket(TestPacketC2S testPacketC2S, IPayloadContext context) {
        EntityTypes.COW.spawn(((ServerLevel) context.player().level()), context.player().getOnPos(), EntitySpawnReason.TRIGGERED);
    }
}
