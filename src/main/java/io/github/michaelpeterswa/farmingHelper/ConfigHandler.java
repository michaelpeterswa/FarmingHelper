//Michael Peters
//farmingHelper-1.5-DEV

package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHandler {

    JavaPlugin plugin = farmingHelper.getInst();

    // Your plugin instance

    void saveDefaults() {
        plugin.saveDefaultConfig();
    }
    public FileConfiguration readFromConfig () {
        return plugin.getConfig(); //Accessing the config file
    }

    public String returnFirstLine(FileConfiguration a) {
        return a.getString("adminName");
    }

}
