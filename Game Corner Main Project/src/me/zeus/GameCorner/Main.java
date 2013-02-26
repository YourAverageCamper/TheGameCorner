
package me.zeus.GameCorner;


import java.io.File;

import me.zeus.GameCorner.Commands.BasicCommands;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {

    private final DonateHandler donatehandler = new DonateHandler(this);
    private final BasicCommands basicCommands = new BasicCommands(this);
    private final VoteHandler voteHandler = new VoteHandler(this);
    private final PreProcessing preProcessing = new PreProcessing(this);
    private final PingEvent pingEvent = new PingEvent(this);
    private final PlayersConfig playersconfig = new PlayersConfig(this);

    @Override
    public void onEnable() {

        // config time
        
        final File config = new File(getDataFolder() + File.separator + "config.yml");
        
        if (!config.exists()) {
            getConfig().addDefault("Booleans.PingEvent", true);
            
            getConfig().addDefault("Donators.Iron", donatehandler.ironDonators);
            getConfig().addDefault("Donators.Gold", donatehandler.goldDonators);
            getConfig().addDefault("Donators.Diamond", donatehandler.diamondDonators);
            getConfig().addDefault("Donators.Emerald", donatehandler.emeraldDonators);

            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        final PluginManager pm = this.getServer().getPluginManager();

        // Register Events
        pm.registerEvents(pingEvent, this);
        pm.registerEvents(preProcessing, this);
        pm.registerEvents(voteHandler, this);

        // get commands

        getCommand("vote").setExecutor(voteHandler);
        getCommand("credits").setExecutor(voteHandler);

        getCommand("donate").setExecutor(donatehandler);
        getCommand("donators").setExecutor(donatehandler);

        getCommand("clear").setExecutor(basicCommands);
               
        playersconfig.reloadPlayers();
        playersconfig.savePlayers();

    }
}
