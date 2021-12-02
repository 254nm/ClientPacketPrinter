package me.l2x9.clientpacketprinter.command.commands;

import me.l2x9.clientpacketprinter.ClientPacketPrinter;
import me.l2x9.clientpacketprinter.command.Command;
import net.minecraft.client.Minecraft;

/**
 * @author 254n_m
 * @since 2021-12-01 / 4:11 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public class ToggleCommand extends Command {
    public ToggleCommand() {
        super("toggleprinter");
    }

    @Override
    public void execute(String[] args, Minecraft mc) {
        ClientPacketPrinter.INSTANCE.setToggled(!ClientPacketPrinter.INSTANCE.toggledEh());
    }
}
