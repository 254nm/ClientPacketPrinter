package me.l2x9.clientpacketprinter.packet;

/**
 * @author 254n_m
 * @since 2021-12-01
 * This file was created as a part of ClientPacketPrinter
 */
public interface PacketListener {
    void incoming(PacketEvent.Incoming event);

    void outgoing(PacketEvent.Outgoing event);
}
