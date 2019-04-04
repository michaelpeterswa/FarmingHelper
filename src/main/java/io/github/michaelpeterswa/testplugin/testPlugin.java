package io.github.michaelpeterswa.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class testPlugin extends JavaPlugin {
@Override
public void onEnable() {
        getLogger().info("peenPlugin has been enabled");
    }

@Override
public void onDisable() {
    getLogger().info("peenPlugin has been disabled");
}

@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("peen")) { // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
        if(!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute that command!");
            return true;
        }
    }
    //If this has happened the function will return true.
    // If this hasn't happened the value of false will be returned.
    Player player = (Player) sender;
    ItemStack item1 = new ItemStack(Material.WOODEN_HOE,1);
    ItemMeta meta = item1.getItemMeta();
    meta.setDisplayName("§c§lr§6§la§e§li§a§ln§b§lb§d§lo§c§lw peen");
    meta.addEnchant(Enchantment.DURABILITY, 1, true);
    item1.setItemMeta(meta);
    player.getInventory().addItem(item1);

    return true;
    }
}
