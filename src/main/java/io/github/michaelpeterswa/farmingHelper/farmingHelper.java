package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class farmingHelper extends JavaPlugin {

//        sender.sendMessage(ChatColor.LIGHT_PURPLE + "====[ Multiverse Anchor List ]====");
//        Player p = null;
//        if (sender instanceof Player) {
//        p = (Player) sender;

    @Override
    public void onEnable() {
        getLogger().info(" ");
        getLogger().info("\u001b[31m ------------------------------\u001b[0m");
        getLogger().info("\u001b[31m FarmingHelper has been enabled\u001b[0m");
        getLogger().info("\u001b[31m ------------------------------\u001b[0m");
        getLogger().info(" ");

        getCommand("fh").setExecutor(new GiveToolCommand());
        getCommand("fhc").setExecutor(new ConfigCommand());
        ConfigHandler ch = new ConfigHandler();
        ch.test();
    }

    @Override
    public void onDisable() {
        getLogger().info("farmingHelper has been disabled");
    }
}