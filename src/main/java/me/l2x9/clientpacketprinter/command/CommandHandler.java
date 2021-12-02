package me.l2x9.clientpacketprinter.command;

import me.l2x9.clientpacketprinter.command.commands.ToggleCommand;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 254n_m
 * @since 2021-12-01 / 3:45 a.m.
 * This file was created as a part of ClientPacketPrinter
 */
public class CommandHandler {
    private final ArrayList<Command> commands = new ArrayList<>();
    private final String prefix = "!";
    Minecraft minecraft = Minecraft.getMinecraft();

    public CommandHandler() {
        registerCommands();
    }

    public void registerCommands() {
        addCommand(new ToggleCommand());
    }

    private void addCommand(Command command) {
        commands.add(command);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        String message = event.getMessage();
        for (Command command : commands) {
            if (message.startsWith(prefix)) {
                minecraft.ingameGUI.getChatGUI().addToSentMessages(message);
                event.setCanceled(true);
                String[] split = message.split(" ");
                String name = split[0].replaceFirst(prefix, "");
                if (command.getName().equalsIgnoreCase(name)) {
                    String[] args = Arrays.copyOfRange(split, 1, split.length);
                    command.execute(args, minecraft);
                    break;
                }
            }
        }
    }
}