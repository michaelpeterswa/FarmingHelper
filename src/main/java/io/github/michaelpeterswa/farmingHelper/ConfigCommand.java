//Michael Peters
//farmingHelper-1.5-DEV

package io.github.michaelpeterswa.farmingHelper;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        ConfigHandler ch = new ConfigHandler();
        ch.saveDefaults();

        String fh_prefix = String.format("%s[%sfhc%s] ", ChatColor.GREEN, ChatColor.DARK_GREEN, ChatColor.GREEN);
        //prefix to append to each message to the player

        if (args.length == 0) {
                sender.sendMessage(ChatColor.DARK_PURPLE + "-------------------------");
                sender.sendMessage(ChatColor.DARK_PURPLE + "farmingHelper Config v1.5");
                sender.sendMessage(ChatColor.DARK_PURPLE + "usage: /fhc");
                sender.sendMessage(ChatColor.DARK_PURPLE + "reload: /fhc reload");
                sender.sendMessage(ChatColor.DARK_PURPLE + "list: /fhc list");
                sender.sendMessage(ChatColor.DARK_PURPLE + "-------------------------");
            }


        if (args.length == 1){
            if(args[0].equals("reload")){
                sender.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + "reloading...");
                return true;
            }
            if(args[0].equals("list")){
                sender.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + "listing...");
                sender.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + ch.returnAdminName(ch.readFromConfig()));
                sender.sendMessage(fh_prefix + ChatColor.DARK_PURPLE + ch.returnNumberOfHoes(ch.readFromConfig()));
                return true;
            }
            else{
                sender.sendMessage(fh_prefix + ChatColor.RED + "unsupported command");
            }
        }

        if (args.length > 1){
            sender.sendMessage(fh_prefix + ChatColor.RED + "unsupported command (too many args)");
        }
    return true;
    }
}


