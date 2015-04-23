package io.github.mac_genius.customleveling;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * This class handles all of the commands for the plugin.
 *
 * @author John Harrison
 */
public class Commands implements CommandExecutor {
    private CustomLeveling plugin;

    /**
     * Gets the main instance of the plugin.
     *
     * @param instance is the main instance of the plugin
     */
    public Commands(CustomLeveling instance) {
        plugin = instance;
    }

    /**
     * This is activated when a player uses a command
     *
     * @param sender is the player sending the command
     * @param cmd is the command
     * @param label is not used
     * @param args are the additional words to define commands
     * @return whether the command was executed or not
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cl")) {

            // If the player only typed in /cl
            if (args.length == 0) {
                if (sender.hasPermission("cl.*")) {
                    sender.sendMessage(ChatColor.GREEN + "-- Custom Leveling Help --");
                    sender.sendMessage(ChatColor.GOLD + "/cl reload" + ChatColor.WHITE + " reloads the config");
                    sender.sendMessage(ChatColor.GOLD + "/cl help" + ChatColor.WHITE + " commands");
                    return true;
                }
            }
            // If the player does /cl reload
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("cl.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "[Custom Leveling]" + ChatColor.WHITE + " Config reloaded.");
                    return true;
                }
            }

            // If the player does /cl help
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
