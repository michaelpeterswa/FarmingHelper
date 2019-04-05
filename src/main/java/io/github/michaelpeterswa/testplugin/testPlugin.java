package io.github.michaelpeterswa.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    getLogger().info("\u001b[31m ---------------------------\u001b[0m");
    getLogger().info("\u001b[31m peenPlugin has been enabled\u001b[0m");
    getLogger().info("\u001b[31m ---------------------------\u001b[0m");
    }

@Override
public void onDisable() {
    getLogger().info("peenPlugin has been disabled");
}

@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("peen")) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute that command!");
            return true;
        }
    }
    Player player = (Player) sender;
    if(args.length == 0){
        ItemStack item1 = new ItemStack(Material.WOODEN_HOE,1);
        ItemMeta meta = item1.getItemMeta();
        meta.setDisplayName("§c§lr§6§la§e§li§a§ln§b§lb§d§lo§c§lw peen");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item1.setItemMeta(meta);
        player.getInventory().addItem(item1);
        return true;
    }
    else if (args.length != 0) {
        if(args[0].equals("help")){
            sender.sendMessage(ChatColor.DARK_PURPLE + "----------------");
            sender.sendMessage(ChatColor.DARK_PURPLE + "peenPlugin v1.2");
            sender.sendMessage(ChatColor.DARK_PURPLE + "usage: /peen");
            sender.sendMessage(ChatColor.DARK_PURPLE + "help: /peen help");
            sender.sendMessage(ChatColor.DARK_PURPLE + "----------------");
        }
        else {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (player.hasPermission("peenPlugin.peen.others")) {
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Error: Player is offline!");
                    return true;
                } else {
                    player.sendMessage(ChatColor.DARK_PURPLE + args[0]);
                    ItemStack item1 = new ItemStack(Material.WOODEN_HOE, 1);
                    ItemMeta meta = item1.getItemMeta();
                    meta.setDisplayName("§c§lr§6§la§e§li§a§ln§b§lb§d§lo§c§lw peen");
                    meta.addEnchant(Enchantment.DURABILITY, 1, true);
                    item1.setItemMeta(meta);
                    target.getInventory().addItem(item1);
                    return true;
                }
            } else if (!(player.hasPermission("peenPlugin.peen.others"))) {
                player.sendMessage(ChatColor.RED + "Insufficient Permissions.");
                return true;
            }
        }
    }
    return true;
    }
}
