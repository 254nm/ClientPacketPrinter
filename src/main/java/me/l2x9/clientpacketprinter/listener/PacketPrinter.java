package me.l2x9.clientpacketprinter.listener;

import me.l2x9.clientpacketprinter.ClientPacketPrinter;
import me.l2x9.clientpacketprinter.packet.PacketEvent;
import me.l2x9.clientpacketprinter.packet.PacketListener;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;

import java.lang.reflect.Field;

/**
 * @author 254n_m
 * @since 2021-12-01 / 3:53 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public class PacketPrinter implements PacketListener {
    @Override
    public void incoming(PacketEvent.Incoming event) {
        if (ClientPacketPrinter.INSTANCE.toggledEh()) {
            String packetStr = parsePacket(event.getPacket());
            if (packetStr == null) return;
            TextComponentString component = new TextComponentString("PACKET -> " + packetStr);
            Minecraft.getMinecraft().ingameGUI.addChatMessage(ChatType.CHAT, component);
        }
    }

    @Override
    public void outgoing(PacketEvent.Outgoing event) {

    }

    private String parsePacket(Object o) {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(o.getClass().getName()).append("[");
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object fVal = field.get(o);
                if (fVal == null) continue;
                String fName = field.getName();
                String fType = field.getType().getName();
                builder.append(fName).append("::").append(fType).append("=").append(fVal).append(", ");
            }
            builder.append("]");
            return builder.toString();
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
}
