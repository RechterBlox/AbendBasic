package studio.abendreden.abendbasic.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import studio.abendreden.abendbasic.utils.ConfigMessages;

public class PlayerJoinAndQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ConfigMessages.joinMessage.replace("%PLAYER%", event.getPlayer().getName()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ConfigMessages.quitMessage.replace("%PLAYER%", event.getPlayer().getName()));
    }
}
