
package me.zeus.GameCorner;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;



public class PreProcessing implements Listener {

    private final Main plugin;

    public PreProcessing(final Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onCommand(final PlayerCommandPreprocessEvent e) {

        final Player player = e.getPlayer();
        final String cmd = e.getMessage();

        if (cmd.equalsIgnoreCase("/plugins") || cmd.equalsIgnoreCase("/pl")) {
            if (!player.hasPermission("TheGameCorner.Plugins")) {
                player.sendMessage(ChatColor.RED + " If you were hoping to see our plugins for your own server, or to hack, go fuck yourself. "
                        + "\n");
                e.setCancelled(true);
            }

        } else if (cmd.equalsIgnoreCase("/stop")) {
            if (!player.getName().equalsIgnoreCase("ZeusAllMighty11")) {
                e.setCancelled(true);
            }

        } else if (cmd.equalsIgnoreCase("/rl") || cmd.equalsIgnoreCase("/reload")) {
            if (player.isOp()) {
                plugin.getServer()
                        .broadcastMessage("§d§l§oThe server is §e§l§nreloading§d§l§o. Expect lag for a few seconds.");
            }
        }

    }

}
