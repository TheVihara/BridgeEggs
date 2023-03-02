package me.gorenjec.bridgeeggs.commands;

import cloud.commandframework.Command;
import cloud.commandframework.arguments.standard.IntegerArgument;
import cloud.commandframework.bukkit.parsers.MaterialArgument;
import cloud.commandframework.bukkit.parsers.selector.MultiplePlayerSelectorArgument;
import cloud.commandframework.paper.PaperCommandManager;
import me.gorenjec.bridgeeggs.models.BridgeEggStack;
import me.gorenjec.bridgeeggs.models.CloudCommand;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveSubCommand extends CloudCommand {
    @Override
    public Command<CommandSender> createCommand(PaperCommandManager<CommandSender> manager) {
        return manager.commandBuilder("bridgeeggs", "be", "bridgee", "beggs", "bridgeegg")
                .literal("give")
                .argument(MultiplePlayerSelectorArgument.of("target"))
                .argument(IntegerArgument.of("amount"))
                .argument(IntegerArgument.of("distance"))
                .argument(MaterialArgument.of("block"))
                .permission("bridgeeggs.use.give")
                .handler(commandContext -> {
                    Player player = (Player) commandContext.getSender();
                    int amount = commandContext.get("amount");
                    int distance = commandContext.get("distance");
                    BlockData blockData = ((Material) commandContext.get("block")).createBlockData();
                    BridgeEggStack eggStack = BridgeEggStack.newInstance(amount, distance, blockData);

                    player.getInventory().addItem(eggStack);
                }).build();
    }
}
