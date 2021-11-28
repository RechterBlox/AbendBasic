package studio.abendreden.abendbasic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import studio.abendreden.abendbasic.utils.ConfigMessages;

public class ReloadMessagesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("essentials.reload.messages")) {
            if (args.length == 0) {
                new ConfigMessages();
                sender.sendMessage(ConfigMessages.reloadMessagesCommand);
            }
        } else {
            sender.sendMessage(ConfigMessages.noPermission);
        }
        return false;
    }
}
