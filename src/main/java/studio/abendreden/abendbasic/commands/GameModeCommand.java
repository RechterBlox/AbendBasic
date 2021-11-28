package studio.abendreden.abendbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import studio.abendreden.abendbasic.utils.ConfigMessages;

public class GameModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            if (sender instanceof Player player) {
                if (player.hasPermission("abendbasic.gamemode.self")) {
                    ownSetGameMode(Integer.parseInt(args[0]), player, null, false);
                } else {
                    player.sendMessage(ConfigMessages.noPermission);
                }
            } else {
                sender.sendMessage(ConfigMessages.onlyPlayer);
            }
        } else if (args.length == 2) {
            if (sender.hasPermission("abendbasic.gamemode.other")) {
                Player target = Bukkit.getPlayer(args[1]);
                if (target == null || !target.isOnline()) {
                    sender.sendMessage(ConfigMessages.playerNotExists);
                    return false;
                }
                ownSetGameMode(Integer.parseInt(args[0]), target, sender, true);
            } else {
                sender.sendMessage(ConfigMessages.noPermission);
            }
        }
        return false;
    }

    private void ownSetGameMode(int gameModeMode, Player player, CommandSender sender, Boolean withSender) {
        switch (gameModeMode) {
            case 0 -> {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ConfigMessages.playerSetSurvivalGameMode);
                if (withSender) {
                    sender.sendMessage(ConfigMessages.playerSetTargetSurvivalGameMode.replace("%PLAYER", player.getName()));
                }
            }
            case 1 -> {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(ConfigMessages.playerSetCreativeGameMode);
                if (withSender) {
                    sender.sendMessage(ConfigMessages.playerSetTargetCreativeGameMode.replace("%PLAYER", player.getName()));
                }
            }
            case 2 -> {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ConfigMessages.playerSetAdventureGameMode);
                if (withSender) {
                    sender.sendMessage(ConfigMessages.playerSetTargetAdventureGameMode.replace("%PLAYER", player.getName()));
                }
            }
            case 3 -> {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ConfigMessages.playerSetSpectatorGameMode);
                if (withSender) {
                    sender.sendMessage(ConfigMessages.playerSetTargetSpectatorGameMode.replace("%PLAYER", player.getName()));
                }
            }
        }
    }
}
