package studio.abendreden.abendbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import studio.abendreden.abendbasic.utils.ConfigMessages;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player player) {
                if (player.hasPermission("abendbasic.feed.self")) {
                    player.setFoodLevel(20);
                    player.sendMessage(ConfigMessages.playerFeed);
                } else {
                    player.sendMessage(ConfigMessages.noPermission);
                }
            } else {
                sender.sendMessage(ConfigMessages.onlyPlayer);
            }
        } else if (args.length == 1) {
            if (sender.hasPermission("abendbasic.feed.other")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null || !target.isOnline()) {
                    sender.sendMessage(ConfigMessages.playerNotExists);
                    return false;
                }
                target.setFoodLevel(20);
                sender.sendMessage(ConfigMessages.playerFeedTarget.replace("%PLAYER", target.getName()));
                target.sendMessage(ConfigMessages.playerFeed);
            } else {
                sender.sendMessage(ConfigMessages.noPermission);
            }
        }
        return false;
    }
}
