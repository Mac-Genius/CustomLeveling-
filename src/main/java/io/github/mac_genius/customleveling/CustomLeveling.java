package io.github.mac_genius.customleveling;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Mac on 4/17/2015.
 */
public class CustomLeveling extends JavaPlugin {
    Plugin plugin = this;
    CustomLeveling customLvl = this;

    public void onEnable() {
        plugin.saveDefaultConfig();
        this.getCommand("cl").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new LevelHandler(plugin), this);
        getLogger().info("CustomLeveling now implemented.");
    }

    public void onDisable() {
        getLogger().info("Plugin disabled");
    }
}