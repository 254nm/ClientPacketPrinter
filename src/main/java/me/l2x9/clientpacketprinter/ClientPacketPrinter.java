package me.l2x9.clientpacketprinter;

import me.l2x9.clientpacketprinter.command.CommandHandler;
import me.l2x9.clientpacketprinter.listener.PacketPrinter;
import me.l2x9.clientpacketprinter.packet.Injector;
import me.l2x9.clientpacketprinter.packet.PacketListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

@Mod(
        modid = ClientPacketPrinter.MOD_ID,
        name = ClientPacketPrinter.MOD_NAME,
        version = ClientPacketPrinter.VERSION
)

/**
 * @author 254n_m
 * @since 2021-12-01 / 3:30 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public class ClientPacketPrinter {

    public static final String MOD_ID = "clientpacketprinter";
    public static final String MOD_NAME = "ClientPacketPrinter";
    public static final String VERSION = "1.0-SNAPSHOT";
    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static ClientPacketPrinter INSTANCE;
    private final List<PacketListener> listeners = new ArrayList<>();
    private boolean toggled = false;

    public boolean toggledEh() {
        return toggled;
    }

    public void setToggled(boolean toggle) {
        toggled = toggle;
    }

    public List<PacketListener> getListeners() {
        return listeners;
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("ClientPacketPrinter Loaded!!!!");
        listeners.add(new PacketPrinter());
        MinecraftForge.EVENT_BUS.register(new Injector());
        MinecraftForge.EVENT_BUS.register(new CommandHandler());
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
