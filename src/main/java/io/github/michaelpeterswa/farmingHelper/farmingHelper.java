//Michael Peters
//farmingHelper-1.5-DEV

package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.plugin.java.JavaPlugin;

public final class farmingHelper extends JavaPlugin {

    private static farmingHelper instance;

    @Override
    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("\u001b[31m ------------------------------\u001b[0m");
        getLogger().info("\u001b[31m FarmingHelper has been enabled\u001b[0m");
        getLogger().info("\u001b[31m ------------------------------\u001b[0m");
        getLogger().info(" ");

        getCommand("fh").setExecutor(new GiveToolCommand());
        getCommand("fhc").setExecutor(new ConfigCommand());
        instance = this;
    }

    @Override
    public void onDisable() {
        getLogger().info("farmingHelper has been disabled");
    }

    public static farmingHelper getInst() {
        return instance;
    }
}