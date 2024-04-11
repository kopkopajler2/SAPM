package com.popopapi.bukkit;

import com.popopapi.bukkit.init.BukkitInit;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitEntryPoint extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        BukkitInit bukkitInit = new BukkitInit(this);
        bukkitInit.initCommands();
        bukkitInit.CreateDatabase();
        //send message to console
        getLogger().info("SAPM has been enabled!");
    }
}