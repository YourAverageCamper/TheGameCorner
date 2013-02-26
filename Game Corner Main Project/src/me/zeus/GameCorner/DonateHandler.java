
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
                    sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");
                    sender.sendMessage(ChatColor.GRAY + "\n    [Iron]                " + ChatColor.GREEN + "    $5.00 USD");
                    sender.sendMessage(ChatColor.YELLOW + "    [Gold]                " + ChatColor.GREEN + "    $10.00 USD");
                    sender.sendMessage(ChatColor.AQUA + "    [Diamond]                " + ChatColor.GREEN + "$25.00 USD");
                    sender.sendMessage(ChatColor.GREEN + "    [Emerald]                " + ChatColor.GREEN + "$50.00 USD");
                    sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/Vbvm0D \n");
                    sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");
                }

                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase("iron")) {

                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");
                        sender.sendMessage(ChatColor.WHITE + "                 [Iron] " + ChatColor.GREEN + "$5.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "- Ability to join the server when it's full");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /fly command");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /kit Iron command");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /nick command, to set nickname");
                        sender.sendMessage(ChatColor.GRAY + "- Ability to craft enderbow!");
                        sender.sendMessage(ChatColor.GRAY + "- Access to craft spiderbow!");
                        sender.sendMessage(ChatColor.GRAY + "- Access to craft mineshine!");
                        sender.sendMessage(ChatColor.GRAY + "- Access to craft chocolate milk!");
                        sender.sendMessage(ChatColor.GRAY + "- 5 credits");
                        sender.sendMessage(ChatColor.GRAY + "- $1000 in-game-cash");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/YUagGv");
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");

                    } else

                    if (args[0].equalsIgnoreCase("gold")) {

                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");
                        sender.sendMessage(ChatColor.GOLD + "                 [Gold] " + ChatColor.GREEN + "$10.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "- Ability to join the server when it's full");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /kit Gold command");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /nick command, to set nickname with color!");
                        sender.sendMessage(ChatColor.GRAY + "- All pervious perks");
                        sender.sendMessage(ChatColor.GRAY + "- Access to craft flash grenades!");
                        sender.sendMessage(ChatColor.GRAY + "- Access to craft lightning grenades!");
                        sender.sendMessage(ChatColor.GRAY + "- Access to craft coffee");
                        sender.sendMessage(ChatColor.GRAY + "- 10 credits");
                        sender.sendMessage(ChatColor.GRAY + "- $2000 in-game-cash");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/YUagGv");
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");

                    } else

                    if (args[0].equalsIgnoreCase("diamond")) {

                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");
                        sender.sendMessage(ChatColor.WHITE + "                 [Diamond] " + ChatColor.GREEN + "$25.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "- All previous perks");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /kit Diamond command");
                        sender.sendMessage(ChatColor.GRAY + "- Ability to craft Explosive Bow!");
                        sender.sendMessage(ChatColor.GRAY + "- 25 credits");
                        sender.sendMessage(ChatColor.GRAY + "- $5,000 in-game-cash");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/YUagGv");
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");

                    } else

                    if (args[0].equalsIgnoreCase("emerald")) {

                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");
                        sender.sendMessage(ChatColor.WHITE + "                 [Emerald] " + ChatColor.GREEN + "$50.00 USD");
                        sender.sendMessage(ChatColor.GRAY + "- All previous perks");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /kit Emerald command");
                        sender.sendMessage(ChatColor.GRAY + "- Ability to craft everything!");
                        sender.sendMessage(ChatColor.GRAY + "- Access to /gamemode command");
                        sender.sendMessage(ChatColor.GRAY + "- Ability to place/destroy bedrock");
                        sender.sendMessage(ChatColor.GRAY + "- 50 credits");
                        sender.sendMessage(ChatColor.GRAY + "- $10,000 in-game-cash");
                        sender.sendMessage(ChatColor.DARK_AQUA + "\n http://bit.ly/YUagGv");
                        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "---------------------------------------------");

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
