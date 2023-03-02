package me.gorenjec.bridgeeggs.commands;

import cloud.commandframework.Command;
import cloud.commandframework.paper.PaperCommandManager;
import me.gorenjec.bridgeeggs.models.CloudCommand;
import me.gorenjec.bridgeeggs.utils.HexUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BridgeEggCommand extends CloudCommand {
    @Override
    public Command<CommandSender> createCommand(PaperCommandManager<CommandSender> manager) {
        return manager.commandBuilder("bridgeeggs", "be", "bridgee", "beggs", "bridgeegg")
                .permission("bridgeeggs.use")
                .handler(commandContext -> {
                    Player player = (Player) commandContext.getSender();

                    player.sendMessage(HexUtils.colorify("&cUnknown subcommand, try /bridgeeggs help for a list of commands!"));
                }).build();
    }
}
