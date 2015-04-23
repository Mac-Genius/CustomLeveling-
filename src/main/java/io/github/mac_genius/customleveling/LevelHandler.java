package io.github.mac_genius.customleveling;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

/**
 * Created by Mac on 4/17/2015.
 */
public class LevelHandler implements Listener {
    private Plugin plugin;

    public LevelHandler(Plugin pluginIn) {
        plugin = pluginIn;
    }

    @EventHandler
    public void onKill(PlayerExpChangeEvent event) {
        ArrayList<String> levelList = new ArrayList<>(plugin.getConfig().getStringList("levels"));
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
            player.sendMessage(ChatColor.GREEN + "[Custom Leveling]" + ChatColor.WHITE + " You have reached the highest level!");
            event.setAmount(0);
        }
    }
}
