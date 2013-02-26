
package me.zeus.GameCorner;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.vexsoftware.votifier.model.VotifierEvent;



public class VoteHandler implements Listener, CommandExecutor {

    String prefix = ChatColor.DARK_AQUA + "[" + ChatColor.RED + "Vote" + ChatColor.DARK_AQUA + "] ";
    ChatColor red = ChatColor.RED;
    ChatColor aqua = ChatColor.AQUA;
    ChatColor green = ChatColor.GREEN;
    ChatColor yellow = ChatColor.YELLOW;

    private final Main plugin;
    private final PlayersConfig creditsconfig;

    public VoteHandler(final Main plugin) {
        this.plugin = plugin;
        this.creditsconfig = new PlayersConfig(plugin);
    }

    /*
     *                        ***  VOTE LISTENER ***
     */

    @EventHandler
    public void onVoteGet(final VotifierEvent e) {
        final Player voter = plugin.getServer().getPlayer(e.getVote().getUsername());
        final String website = e.getVote().getServiceName();

        plugin.getServer().broadcastMessage(
                prefix + ChatColor.YELLOW + voter.getName() + ChatColor.LIGHT_PURPLE + " Voted on: " + ChatColor.DARK_AQUA + website
                        + ", and received $50 in their bank vault, and 1 " + ChatColor.ITALIC + "" + ChatColor.GREEN + "credit!");

        if (voter.isOnline()) {
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "eco give " + voter.getName() + " 50");
            addCredits(voter);
        }

    }

    // -------------------------------------------------------------------------------------------------------
    /*
     *              VOTE COMMANDS LISTENER, CREDITS LISTENER
     */
    // -------------------------------------------------------------------------------------------------------

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

        if (cmd.getName().equalsIgnoreCase("vote")) {
            if (sender instanceof Player) {
                sender.sendMessage(prefix + yellow + "" + ChatColor.BOLD + "**Vote for our server**");
                sender.sendMessage(prefix + ChatColor.LIGHT_PURPLE + "> > > http://bit.ly/XXtbzi < < <");
                sender.sendMessage(prefix + yellow + "Every time you vote, you gain a credit, which are used to buy exclusive items.");
                sender.sendMessage(prefix + yellow + "Total credits: " + ChatColor.RED + getCredits((Player) sender));
            }
        } else if (cmd.getName().equalsIgnoreCase("credits")) {
            if (sender instanceof Player) {
                sender.sendMessage(prefix + green + "You have: " + yellow + getCredits((Player) sender) + green + " credits");
            }
        }
        return false;
    }

    // -------------------------------------------------------------------------------------------------------

    public boolean accExists(final Player p) {
        return creditsconfig.getPlayers().getKeys(false).contains(p.getName());
    }

    public int getCredits(final Player p) {
        if (accExists(p)) {
            return creditsconfig.getPlayers().getInt(p.getName());
        } else {
            addCredits(p);
            return 0;
        }
    }

    public void addCredits(final Player p) {
        if (!accExists(p)) {
            creditsconfig.getPlayers().set(p.getName(), 0);
            creditsconfig.savePlayers();
        } else {
            creditsconfig.getPlayers().set(p.getName(), getCredits(p) + 1);
            creditsconfig.savePlayers();
        }
    }

    // -------------------------------------------------------------------------------------------------------

}
