
package me.zeus.GameCorner;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class DonateHandler implements CommandExecutor {

    String incorrectArgs = ChatColor.RED + " Invalid amount of arguments!";
    
    private Main plugin;
    
    public DonateHandler(Main plugin){
        this.plugin = plugin;
    }

    public List<String> ironDonators = new ArrayList<String>();
    public List<String> goldDonators = new ArrayList<String>();
    public List<String> diamondDonators = new ArrayList<String>();
    public List<String> emeraldDonators = new ArrayList<String>();

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {

        if (sender instanceof Player) {

            /////////////////////////////

            if (cmd.getName().equalsIgnoreCase("donate")) {

                if (args.length == 0) {
                    sender.sendMessage(ChatColor.GRAY + "================================================ ");
                    sender.sendMessage(ChatColor.GRAY + "\n    [Iron]                " + ChatColor.GREEN + "    $5.00 USD");
                    sender.sendMessage(ChatColor.YELLOW + "    [Gold]                " + ChatColor.GREEN + "    $10.00 USD");
                    sender.sendMessage(ChatColor.AQUA + "    [Diamond]                " + ChatColor.GREEN + "$25.00 USD");
                    sender.sendMessage(ChatColor.GREEN + "    [Emerald]                " + ChatColor.GREEN + "$50.00 USD");
                    sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/Vbvm0D \n");
                    sender.sendMessage(ChatColor.GRAY + "================================================ ");
                }

                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("iron")) {

                        sender.sendMessage(ChatColor.GRAY + "=============================================");
                        sender.sendMessage(ChatColor.WHITE + "                 [Iron] " + ChatColor.GREEN + "$5.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "         - /nick (Choose a new nickname, can be colored!)");
                        sender.sendMessage(ChatColor.GRAY + "         - Iron rank on forums");
                        sender.sendMessage(ChatColor.GRAY + "         - Ability to fly");
                        sender.sendMessage(ChatColor.GRAY + "         - Iron Kit Choice");
                        sender.sendMessage(ChatColor.GRAY + "         - Iron Kit exclusive NEW items");
                        sender.sendMessage(ChatColor.GRAY + "         - $100 in-game");
                        sender.sendMessage(ChatColor.GRAY + "         - Join when server is full");
                        sender.sendMessage(ChatColor.GRAY + "         - 5 credits");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/Vbvm0D \n");
                        sender.sendMessage(ChatColor.GRAY + "=============================================");

                    } else

                    if (args[0].equalsIgnoreCase("gold")) {

                        sender.sendMessage(ChatColor.GRAY + "=============================================");
                        sender.sendMessage(ChatColor.WHITE + "                 [Gold] " + ChatColor.GREEN + "$10.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "         - All of the iron perks)");
                        sender.sendMessage(ChatColor.GRAY + "         - Gold rank on forums");
                        sender.sendMessage(ChatColor.GRAY + "         - Gold Kit Choice");
                        sender.sendMessage(ChatColor.GRAY + "         - Access to /rename, so you can rename your tools + armor!");
                        sender.sendMessage(ChatColor.GRAY + "         - $200 in-game");
                        sender.sendMessage(ChatColor.GRAY + "         - 10 credits");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/Vbvm0D \n");
                        sender.sendMessage(ChatColor.GRAY + "=============================================");

                    } else

                    if (args[0].equalsIgnoreCase("diamond")) {

                        sender.sendMessage(ChatColor.GRAY + "=============================================");
                        sender.sendMessage(ChatColor.WHITE + "                 [Diamond] " + ChatColor.GREEN + "$25.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "         - All of the gold perks)");
                        sender.sendMessage(ChatColor.GRAY + "         - Diamond rank on forums");
                        sender.sendMessage(ChatColor.GRAY + "         - Signature on forums");
                        sender.sendMessage(ChatColor.GRAY + "         - Diamond Kit Choice (enchanted) ");
                        sender.sendMessage(ChatColor.GRAY + "         - $1,000 in-game");
                        sender.sendMessage(ChatColor.GRAY + "         - 25 credits");
                        sender.sendMessage(ChatColor.GRAY + "         - Access to /rename , so you can rename your tools + armor! (WITH COLOR)");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/Vbvm0D \n");
                        sender.sendMessage(ChatColor.GRAY + "=============================================");

                    } else

                    if (args[0].equalsIgnoreCase("emerald")) {

                        sender.sendMessage(ChatColor.GRAY + "=============================================");
                        sender.sendMessage(ChatColor.WHITE + "                 [Emerald] " + ChatColor.GREEN + "$50.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "         - All of the diamond perks)");
                        sender.sendMessage(ChatColor.GRAY + "         - Emerald rank on forums");
                        sender.sendMessage(ChatColor.GRAY + "         - Emerald Kit Choice ");
                        sender.sendMessage(ChatColor.GRAY + "         - Ability to join when server is full ");
                        sender.sendMessage(ChatColor.GRAY + "         - Access to /gamemode creative in the survival world.");
                        sender.sendMessage(ChatColor.GRAY + "         - 50 credits");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/Vbvm0D \n");
                        sender.sendMessage(ChatColor.GRAY + "=============================================");

                    }

                } else if (args.length > 1) {
                    sender.sendMessage(ChatColor.RED + "[Donate] Incorrect arguments!");
                }
                 
            // DISPLAY DONATORS LIST
            
            } else if (cmd.getName().equalsIgnoreCase("donators")) {

                if (args.length == 0) {

                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "[======{" + ChatColor.GREEN + "$$" + "Donators" + ChatColor.GREEN + "$$"
                            + ChatColor.LIGHT_PURPLE + "}======] \n");

                    for (final String emerald : emeraldDonators) {
                        sender.sendMessage(ChatColor.GREEN + "    [Emerald] " + emerald.toString().replace(",", "\n"));
                    }

                    for (final String diamond : diamondDonators) {
                        sender.sendMessage(ChatColor.AQUA + "        [Diamond] " + diamond.toString().replace(",", "\n"));
                    }

                    for (final String gold : goldDonators) {
                        sender.sendMessage(ChatColor.YELLOW + "        [Gold] " + gold.toString().replace(",", "\n"));
                    }

                    for (final String iron : ironDonators) {
                        sender.sendMessage("        [Iron] " + iron.toString().replace(",", "\n"));
                    }

                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "\n[=========================]");

                } else if (args.length == 3) {

                    if (args[0].equalsIgnoreCase("add")) {

                        final String someGuy = args[1];

                        if (args[1].equals(someGuy)) {

                            if (args[2] != null) {
                                if (args[2].equalsIgnoreCase("iron")) {
                                    ironDonators.add(someGuy);
                                    plugin.getConfig().set("Donators.Iron", ironDonators);
                                    plugin.saveConfig();

                                    sender.sendMessage(ChatColor.GREEN + "[$$$$$$] " + ChatColor.DARK_GREEN + " Added " + someGuy
                                            + " to the iron list!");

                                } else if (args[2].equalsIgnoreCase("gold")) {
                                    goldDonators.add(someGuy);
                                    plugin.getConfig().set("Donators.Gold", goldDonators);
                                    plugin.saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "[$$$$$$] " + ChatColor.DARK_GREEN + " Added " + someGuy
                                            + " to the gold list!");

                                } else if (args[2].equalsIgnoreCase("diamond")) {
                                    diamondDonators.add(someGuy);
                                    plugin.getConfig().set("Donators.Diamond", diamondDonators);
                                    plugin.saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "[$$$$$$] " + ChatColor.DARK_GREEN + " Added " + someGuy
                                            + " to the diamond list!");
                                } else if (args[2].equalsIgnoreCase("emerald")) {
                                    emeraldDonators.add(someGuy);
                                    plugin.getConfig().set("Donators.Emerald", emeraldDonators);
                                    plugin.saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "[$$$$$$] " + ChatColor.DARK_GREEN + " Added " + someGuy
                                            + " to the emerald list!");
                                }
                            } else {
                                sender.sendMessage(incorrectArgs);
                            }

                        } else {
                            sender.sendMessage(incorrectArgs);
                        }

                    } else {
                        sender.sendMessage(incorrectArgs);
                    }
                }

            }

        }
        return false;
    }
}
