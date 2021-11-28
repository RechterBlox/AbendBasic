package studio.abendreden.abendbasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import studio.abendreden.abendbasic.utils.ConfigMessages;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player player) {
                if (player.hasPermission("abendbasic.fly.self")) {
                    ownSetFly(player, null, false);
                } else {
                    player.sendMessage(ConfigMessages.noPermission);
                }
            } else {
                sender.sendMessage(ConfigMessages.onlyPlayer);
            }
        } else if (args.length == 1) {
            if (sender.hasPermission("abendbasic.fly.other")) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null || !target.isOnline()) {
                    sender.sendMessage(ConfigMessages.playerNotExists);
                    return false;
                }
                ownSetFly(target, sender, true);

            } else {
                sender.sendMessage(ConfigMessages.noPermission);
            }
        }
        return false;
    }

    private void ownSetFly(Player player, CommandSender sender, boolean withSender) {
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage(ConfigMessages.playerCanFly);
            if (withSender) {
                sender.sendMessage(ConfigMessages.playerTargetCanFly.replace("%PLAYER", player.getName()));
            }
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(ConfigMessages.playerCanNotFly);
            if (withSender) {
                sender.sendMessage(ConfigMessages.playerTargetCanNotFly.replace("%PLAYER", player.getName()));
            }
        }
    }
}
