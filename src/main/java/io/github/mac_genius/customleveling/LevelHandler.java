package io.github.mac_genius.customleveling;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

/**
 * This class implements the listener. It checks for when a player
 * gains xp.
 *
 * @author John Harrison
 */
public class LevelHandler implements Listener {
    private Plugin plugin;

    /**
     * Gets the main instance of the plugin.
     *
     * @param pluginIn is the main instance of the plugin.
     */
    public LevelHandler(Plugin pluginIn) {
        plugin = pluginIn;
    }

    /**
     * Checks to see if a player gets xp.
     *
     * @param event is the PlayerExpChange event
     */
    @EventHandler
    public void onXpGain(PlayerExpChangeEvent event) {

        // Takes in the levels defined in the plugin
        ArrayList<String> levelList = new ArrayList<>(plugin.getConfig().getStringList("levels"));

        // If there are levels defined in the config
        if (!levelList.get(0).equals("none")) {
            Player player = event.getPlayer();
            for (String s : levelList) {
                int levelCompare = Integer.parseInt(s.substring(0, 1)) - 1;
                int xpAmount = Integer.parseInt(s.substring(2));
                int playerLvl = player.getLevel();
                if (playerLvl == levelCompare) {
                    float xpBarCurrent = player.getExp() * xpAmount;
                    float xpBarNew = (xpBarCurrent + event.getAmount()) / xpAmount;
                    event.setAmount(0);
                    player.setExp(xpBarNew);
                    return;
                }
            }

            // If the player reaches the highest level.
            player.sendMessage(ChatColor.GREEN + "[Custom Leveling]" + ChatColor.WHITE + " You have reached the highest level!");
            event.setAmount(0);
        }
    }
}
