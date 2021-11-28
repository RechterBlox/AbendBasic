package studio.abendreden.abendbasic.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigMessages {

    public static String prefix;
    public static String joinMessage;
    public static String quitMessage;

    public static String noPermission;
    public static String onlyPlayer;
    public static String playerNotExists;
    public static String reloadMessagesCommand;

    public static String playerHeal;
    public static String playerHealTarget;

    public static String playerFeed;
    public static String playerFeedTarget;

    public static String playerSetSurvivalGameMode;
    public static String playerSetCreativeGameMode;
    public static String playerSetAdventureGameMode;
    public static String playerSetSpectatorGameMode;
    public static String playerSetTargetSurvivalGameMode;
    public static String playerSetTargetCreativeGameMode;
    public static String playerSetTargetAdventureGameMode;
    public static String playerSetTargetSpectatorGameMode;

    public static String playerCanFly;
    public static String playerCanNotFly;
    public static String playerTargetCanFly;
    public static String playerTargetCanNotFly;

    File file1 = new File("./plugins/AbendBasic/messages.yml");
    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file1);

    public ConfigMessages() {
        try {
            basic();
        }catch (Exception exception) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "[AbendBasic] " + ChatColor.RED + "Error delete the message.yml and then reload the server");
        }
    }

    public void basic() {
        prefix = ChatColor.translateAlternateColorCodes('&', yamlConfiguration.getString("basic.prefix"));
        joinMessage = writeInColor("basic.joinMessage");
        quitMessage = writeInColor("basic.quitMessage");
        commandMessages();
    }

    public void commandMessages() {
        noPermission = writeInColor("commandMessages.noPermission");
        onlyPlayer = writeInColor("commandMessages.onlyPlayer");
        playerNotExists = writeInColor("commandMessages.playerNotExists");
        reloadMessagesCommand = writeInColor("commandMessages.reloadMessagesCommand");
        playerHeal = writeInColor("commandMessages.playerHeal");
        playerHealTarget = writeInColor("commandMessages.playerHealTarget");
        playerFeed = writeInColor("commandMessages.playerFeed");
        playerFeedTarget = writeInColor("commandMessages.playerFeedTarget");
        playerCanFly = writeInColor("commandMessages.playerCanFly");
        playerCanNotFly = writeInColor("commandMessages.playerCanNotFly");
        playerTargetCanFly = writeInColor("commandMessages.playerTargetCanFly");
        playerTargetCanNotFly = writeInColor("commandMessages.playerTargetCanNotFly");
        GameModeMessages();
    }

    public void GameModeMessages() {
        playerSetSurvivalGameMode = writeInColor("commandMessages.GameModeMessages.playerSetSurvivalGameMode");
        playerSetCreativeGameMode = writeInColor("commandMessages.GameModeMessages.playerSetCreativeGameMode");
        playerSetAdventureGameMode = writeInColor("commandMessages.GameModeMessages.playerSetAdventureGameMode");
        playerSetSpectatorGameMode = writeInColor("commandMessages.GameModeMessages.playerSetSpectatorGameMode");

        playerSetTargetSurvivalGameMode = writeInColor("commandMessages.GameModeMessages.playerSetTargetSurvivalGameMode");
        playerSetTargetCreativeGameMode = writeInColor("commandMessages.GameModeMessages.playerSetTargetCreativeGameMode");
        playerSetTargetAdventureGameMode = writeInColor("commandMessages.GameModeMessages.playerSetTargetAdventureGameMode");
        playerSetTargetSpectatorGameMode = writeInColor("commandMessages.GameModeMessages.playerSetTargetSpectatorGameMode");
    }

    public String writeInColor(String configPath) {
        return ChatColor.translateAlternateColorCodes('&',prefix + yamlConfiguration.getString(configPath));
    }
}
