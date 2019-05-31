package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHandler {

    JavaPlugin plugin; // Your plugin instance

    void test() {
        plugin.saveDefaultConfig();
    }
    public FileConfiguration readFromConfig () {
        return plugin.getConfig(); //Accessing the config file
    }

}
