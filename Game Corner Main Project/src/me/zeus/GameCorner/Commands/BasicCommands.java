
package me.zeus.GameCorner.Commands;


import me.zeus.GameCorner.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class BasicCommands implements CommandExecutor {

    private final Main plugin;

    public BasicCommands(final Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

        if (sender instanceof Player) {

            if (cmd.getName().equalsIgnoreCase("clear")) {
                if (sender.hasPermission("TheGameCorner.Clear.All")) {
                    
                    for(int i=0;i<100;i++){
                        plugin.getServer().broadcastMessage("\n");
                    }
                    
                    plugin.getServer().broadcastMessage("Chat has been cleared by an " + ChatColor.RED + "Administrator");

                } else {
                    sender.sendMessage(ChatColor.RED + " Don't have permission to do this... ");
                }
            }

        }
        return false;
    }

}
