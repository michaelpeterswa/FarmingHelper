//Michael Peters
//farmingHelper-1.5-DEV

package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveToolCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String fh_prefix = String.format("%s[%sfh%s] ", ChatColor.GREEN, ChatColor.DARK_GREEN, ChatColor.GREEN);
        //prefix to append to each message to the player

        if (cmd.getName().equalsIgnoreCase("fh")) { //prerequisite command to access farming helper
            if (!(sender instanceof Player)) { //if the command is entered from the console
                if (args.length == 1) { //ensure that the command is not to be applied to a player
                    if (args[0].equals("hoe")) { //hoe command will provide NPE if run from console
                        sender.sendMessage("You must be a player to execute that command!");
                        return false;
                    }
                }
            }

            //Player player = (Player) sender;

            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                    sender.sendMessage("farmingHelper's command /fh cannot be used from the command line");
                } else {
                    sender.sendMessage(ChatColor.DARK_PURPLE + "------------------");
                    sender.sendMessage(ChatColor.DARK_PURPLE + "farmingHelper v1.2");
                    sender.sendMessage(ChatColor.DARK_PURPLE + "usage: /fh");
                    sender.sendMessage(ChatColor.DARK_PURPLE + "help: /fh help");
                    sender.sendMessage(ChatColor.DARK_PURPLE + "-------------------");
                }
            } else if (args.length == 1) { //One argument commands (e.g. /fh help)
                if (args[0].equals("help")) { //Help command
                    if (!(sender instanceof Player)) {
                        sender.sendMessage("farmingHelper's command /fh help cannot be used from the command line");
                    } else {
                        sender.sendMessage(ChatColor.DARK_PURPLE + "------------------");
                        sender.sendMessage(ChatColor.DARK_PURPLE + "farmingHelper HELP");
                        sender.sendMessage(ChatColor.DARK_PURPLE + "hoe: /fh hoe");
                        sender.sendMessage(ChatColor.DARK_PURPLE + "help: /fh help");
                        sender.sendMessage(ChatColor.DARK_PURPLE + "------------------");
                        return true;
                    }
                }
                if (args[0].equals("hoe")) { //Hoe command without a second argument
                    if (!(sender instanceof Player)) {
                        sender.sendMessage("farmingHelper's command /fh hoe cannot be used from the command line");
                    } else {
                        ItemStack item1 = new ItemStack(Material.WOODEN_HOE, 1);
                        ItemMeta meta = item1.getItemMeta();
                        meta.setDisplayName("§c§lr§6§la§e§li§a§ln§b§lb§d§lo§c§lw hoe");
                        meta.addEnchant(Enchantment.DURABILITY, 1, true);
                        item1.setItemMeta(meta);
                        Player player = (Player) sender;
                        player.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + "1 Rainbow Hoe given to " + player.getName());
                        player.getInventory().addItem(item1);
                        return true;
                    }
                } else {
                    if (!(sender instanceof Player)) {
                        sender.sendMessage("[fh] invalid command");
                    } else {
                        Player player = (Player) sender;
                        player.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + "Invalid command.");
                    }
                    // return true;
                }
            } else if (args.length == 2) { //Two argument commands (e.g. /fh hoe nwradio)
                if (args[0].equals("hoe")) {
                    Player target = Bukkit.getServer().getPlayer(args[1]);

                    if (sender.hasPermission("farmingHelper.hoe.others")) {
                        if (target != null) {
                            sender.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + "1 Hoe given to " + args[1]);
                            ItemStack item1 = new ItemStack(Material.WOODEN_HOE, 1);
                            ItemMeta meta = item1.getItemMeta();
                            meta.setDisplayName("§c§lr§6§la§e§li§a§ln§b§lb§d§lo§c§lw hoe");
                            meta.addEnchant(Enchantment.DURABILITY, 1, true);
                            item1.setItemMeta(meta);
                            target.getInventory().addItem(item1);
                            return true;
                        } else {
                            sender.sendMessage(fh_prefix + ChatColor.RED + "Error: Player is offline!");
                            return true;
                        }
                    } else if (!(sender.hasPermission("farmingHelper.hoe.others"))) {
                        sender.sendMessage(fh_prefix + ChatColor.RED + "Insufficient Permissions.");
                    }
                }
            }

        }
        return true;
    }
}

