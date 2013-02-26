
package me.zeus.GameCorner;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;



public class PingEvent implements Listener {

    private final Main plugin;

    public PingEvent(final Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPing(final ServerListPingEvent e) {

        if (plugin.getConfig().getBoolean("Booleans.PingEvent") == true && plugin.getConfig() != null) {
            final String motd = "§l§k§o§nZ§r§e§l[§r§f§lTGC§e§l]§r§l§k§n§oZ§r §2§l|§r §a§l§nRoleplay§r §2§l|§r §d§lServer§r";
            e.setMotd(motd);
        }
    }
}