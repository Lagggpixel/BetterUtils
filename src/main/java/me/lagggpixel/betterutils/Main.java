package me.lagggpixel.betterutils;

import me.lagggpixel.betterutils.commands.PingCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        setupCommands();
    }

    @Override
    public void onDisable() {
    }

    @SuppressWarnings("ConstantConditions")
    private void setupCommands() {
        this.getCommand("ping").setExecutor(new PingCommand());
    }
}
