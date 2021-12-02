package me.l2x9.clientpacketprinter.command;

import net.minecraft.client.Minecraft;

/**
 * @author 254n_m
 * @since 2021-12-01 / 3:51 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public abstract class Command {
    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void execute(String[] args, Minecraft mc);

    public String getName() {
        return name;
    }
}