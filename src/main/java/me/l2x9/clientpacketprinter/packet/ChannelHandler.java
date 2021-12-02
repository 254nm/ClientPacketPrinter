package me.l2x9.clientpacketprinter.packet;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import me.l2x9.clientpacketprinter.ClientPacketPrinter;

/**
 * @author 254n_m
 * @since 2021-12-01 / 3:44 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public class ChannelHandler extends ChannelDuplexHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {
        PacketEvent.Incoming incomingEvent = new PacketEvent.Incoming(packet);
        ClientPacketPrinter.INSTANCE.getListeners().forEach((l) -> l.incoming(incomingEvent));
        super.channelRead(ctx, packet);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object packet, ChannelPromise promise) throws Exception {
        PacketEvent.Outgoing outgoingEvent = new PacketEvent.Outgoing(packet);
        ClientPacketPrinter.INSTANCE.getListeners().forEach((l) -> l.outgoing(outgoingEvent));
        super.write(ctx, packet, promise);
    }
}