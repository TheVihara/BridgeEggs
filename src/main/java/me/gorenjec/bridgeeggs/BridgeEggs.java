package me.gorenjec.bridgeeggs;

import me.gorenjec.bridgeeggs.commands.BridgeEggCommand;
import me.gorenjec.bridgeeggs.commands.GiveSubCommand;
import me.gorenjec.bridgeeggs.commands.HelpSubCommand;
import me.gorenjec.bridgeeggs.handlers.CommandHandler;
import me.gorenjec.bridgeeggs.handlers.ThrowHandler;
import me.gorenjec.bridgeeggs.models.BridgeEggStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BridgeEggs extends JavaPlugin {
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        this.commandHandler = new CommandHandler(this);
        BridgeEggStack.onEnable(this);

        this.registerListeners();
        this.registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerListeners() {
        PluginManager pM = getServer().getPluginManager();
        pM.registerEvents(new ThrowHandler(this), this);
    }

    private void registerCommands() {
        CommandHandler.register(
                new BridgeEggCommand(),
                new GiveSubCommand(),
                new HelpSubCommand()
        );
    }
}
