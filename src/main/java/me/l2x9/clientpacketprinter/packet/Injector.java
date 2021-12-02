package me.l2x9.clientpacketprinter.packet;

import io.netty.channel.ChannelPipeline;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

/**
 * @author 254n_m
 * @since 2021-12-01 / 3:38 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public class Injector {
    private boolean shouldInject = true;

    @SubscribeEvent
    public void onLogin(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        if (shouldInject) {
            shouldInject = false;
            ChannelPipeline pipeline = event.getManager().channel().pipeline();
            System.out.println(pipeline);
            pipeline.addBefore("packet_handler", "listener", new ChannelHandler());
        }
    }

    @SubscribeEvent
    public void onLogout(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        shouldInject = true;
        ChannelPipeline pipeline = event.getManager().channel().pipeline();
        System.out.println("Removing hook listener from pipeline " + pipeline);
        pipeline.remove("listener");
    }
}