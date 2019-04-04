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
        // TODO Insert logic to be performed when the plugin is enabled

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
            Player player = this.getServer().getPlayer(args[0]);
            ItemStack item1 = new ItemStack(Material.STICK,1);
            ItemMeta meta = item1.getItemMeta();
            meta.setDisplayName("thicc peen");
            item1.addEnchantment(Enchantment.DURABILITY, 2);
            item1.setItemMeta(meta);
            player.getInventory().addItem(item1);
        }
    }
    //If this has happened the function will return true.
    // If this hasn't happened the value of false will be returned.


    return false;
    }
}
