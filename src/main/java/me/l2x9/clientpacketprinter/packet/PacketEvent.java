package me.l2x9.clientpacketprinter.packet;

/**
 * @author 254n_m
 * @since 2021-12-01
 * This file was created as a part of ClientPacketPrinter
 */
public abstract class PacketEvent {
    private Object packet;

    protected PacketEvent(Object packet) {
        this.packet = packet;
    }

    public void setPacket(Object packet) {
        this.packet = packet;
    }

    public Object getPacket() {
        return packet;
    }

    public static class Incoming extends PacketEvent {

        protected Incoming(Object packet) {
            super(packet);
        }
    }

    public static class Outgoing extends PacketEvent {

        protected Outgoing(Object packet) {
            super(packet);
        }
    }
}