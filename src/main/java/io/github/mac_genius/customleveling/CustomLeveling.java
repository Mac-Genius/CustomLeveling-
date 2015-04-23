package io.github.mac_genius.customleveling;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * This is the main class for this plugin. It will allow a
 * server to define how much cp a player needs to level up.
 *
 * @author John Harrison
 */
public class CustomLeveling extends JavaPlugin {
    Plugin plugin = this;
    CustomLeveling customLvl = this;

    /**
     * This is called when the plugin is enabled
     */
    public void onEnable() {
        plugin.saveDefaultConfig();
        this.getCommand("cl").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new LevelHandler(plugin), this);
        getLogger().info("CustomLeveling now implemented.");
    }

    /**
     * This is called when the plugin is disabled
     */
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }
}