package me.zeus.GameCorner;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayersConfig {
    
    public Main plugin;
    public File creditsFile;
    public FileConfiguration creditsConfig;

    public PlayersConfig(Main plugin) {
        this.plugin = plugin;
    }


    public void reloadPlayers() {
        if (creditsFile == null) {
            creditsFile = new File(plugin.getDataFolder(), "credits.yml");
        }
        creditsConfig = YamlConfiguration.loadConfiguration(creditsFile);
    }


    public  FileConfiguration getPlayers() {
        if (creditsFile == null) {
            this.reloadPlayers();
        }
        return creditsConfig;
    }

    public  void savePlayers() {
        if (creditsFile == null || creditsConfig == null) {
        return;
        }
        try {
            getPlayers().save(creditsFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + creditsConfig, ex);
        }
    }

}
