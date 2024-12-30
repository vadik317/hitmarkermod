package vadik.hitmarker.client;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.FriendlyByteBuf;
import vadik.hitmarker.network.ClientHandler;
import vadik.hitmarker.network.ModPacket;
import vadik.hitmarker.network.S2CHitPacket;
import vadik.hitmarker.network.S2CModPacket;

import java.util.function.Function;

public class ClientPacketHandlerFabric {

    public static void registerClientMessages() {
        ClientPlayNetworking.registerGlobalReceiver(ModPacket.HIT, wrapS2C(S2CHitPacket::new));

    }

    public static <MSG extends S2CModPacket> ClientPlayNetworking.PlayChannelHandler wrapS2C(Function<FriendlyByteBuf,MSG> decodeFunction) {
        return new ClientHandler<>(decodeFunction);
    }
}
