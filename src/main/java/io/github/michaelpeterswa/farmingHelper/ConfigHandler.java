//Michael Peters
//farmingHelper-1.5-DEV

package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHandler {

    private JavaPlugin plugin; // Your plugin instance

    void test() {
        plugin.saveDefaultConfig();
    }
    public FileConfiguration readFromConfig () {
        return plugin.getConfig(); //Accessing the config file
    }

    public String returnFirstLine(FileConfiguration a) {
        return a.getString("adminName");
    }

}
