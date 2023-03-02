package me.gorenjec.bridgeeggs.commands;

import cloud.commandframework.Command;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.meta.CommandMeta;
import cloud.commandframework.minecraft.extras.AudienceProvider;
import cloud.commandframework.minecraft.extras.MinecraftHelp;
import cloud.commandframework.paper.PaperCommandManager;
import me.gorenjec.bridgeeggs.models.CloudCommand;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;

public class HelpSubCommand extends CloudCommand {
    @Override
    public Command<CommandSender> createCommand(PaperCommandManager<CommandSender> manager) {
        return manager.commandBuilder("bridgeeggs", "be", "bridgee", "beggs", "bridgeegg")
                .permission("bridgeeggs.use.help")
                .meta(CommandMeta.DESCRIPTION, "Shows you the help page for the BridgeEggs plugin.")
                .literal("help")
                .argument(StringArgument.<CommandSender>newBuilder("query").greedy().asOptional().build())
                .handler(commandContext -> {
                    MinecraftHelp minecraftHelp = new MinecraftHelp("/bridgeeggs help", AudienceProvider.nativeAudience(), manager);
                    minecraftHelp.setMessage(MinecraftHelp.MESSAGE_HELP_TITLE, "Bridge Eggs Help");
                    minecraftHelp.setHelpColors(MinecraftHelp.HelpColors.of(
                            TextColor.color(0x5467FF),
                            NamedTextColor.WHITE,
                            TextColor.color(0x19D3FF),
                            NamedTextColor.GRAY,
                            NamedTextColor.DARK_GRAY));
                    minecraftHelp.queryCommands(commandContext.<String>getOptional("query").orElse(""), commandContext.getSender());
                }).build();
    }
}
