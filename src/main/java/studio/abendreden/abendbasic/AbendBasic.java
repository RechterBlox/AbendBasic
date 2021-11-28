package studio.abendreden.abendbasic;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import studio.abendreden.abendbasic.commands.*;
import studio.abendreden.abendbasic.listeners.PlayerJoinAndQuitListener;
import studio.abendreden.abendbasic.utils.ConfigMessages;

import java.io.File;
import java.util.Objects;

public class AbendBasic extends JavaPlugin {

    @Override
    public void onEnable() {
        initCommands();
        initListeners();
        if (!new File("./plugins/AbendBasic/messages.yml").exists()) {
            saveResource("messages.yml", false);
        }
        new ConfigMessages();
    }

    public void initCommands() {
        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new GameModeCommand());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvseeCommand());
        Objects.requireNonNull(getCommand("reloadmessages")).setExecutor(new InvseeCommand());
    }

    public void initListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinAndQuitListener(), this);
    }
}
