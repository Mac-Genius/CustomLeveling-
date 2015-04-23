package io.github.mac_genius.customleveling;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Mac on 4/17/2015.
 */
public class Commands implements CommandExecutor {
    private CustomLeveling plugin;
    public Commands(CustomLeveling instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cl")) {
            if (args.length == 0) {
                if (sender.hasPermission("cl.*")) {
                    sender.sendMessage(ChatColor.GREEN + "-- Custom Leveling Help --");
                    sender.sendMessage(ChatColor.GOLD + "/cl reload" + ChatColor.WHITE + " reloads the config");
                    sender.sendMessage(ChatColor.GOLD + "/cl help" + ChatColor.WHITE + " commands");
                    return true;
                }
            }
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("cl.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "[Custom Leveling]" + ChatColor.WHITE + " Config reloaded.");
                    return true;
                }
            }
            if (args[0].equalsIgnoreCase("help")) {
                if (sender.hasPermission("cl.help")) {
                    sender.sendMessage(ChatColor.GREEN + "-- Custom Leveling Help --");
                    sender.sendMessage(ChatColor.GOLD + "/cl reload" + ChatColor.WHITE + " reloads the config");
                    sender.sendMessage(ChatColor.GOLD + "/cl help" + ChatColor.WHITE + " commands");
                    return true;
                }
            }
        }
        return false;
    }
}
