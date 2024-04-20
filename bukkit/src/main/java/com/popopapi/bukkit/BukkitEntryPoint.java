package com.popopapi.bukkit;

import com.popopapi.bukkit.init.BukkitInit;
import org.bukkit.plugin.java.JavaPlugin;
import com.popopapi.bukkit.init.testcreate;
public class BukkitEntryPoint extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        BukkitInit bukkitInit = new BukkitInit(this);

       // doesnt work: bukkitInit.CreateDatabase();

        testcreate test = new testcreate(this);


        //send message to console
        getLogger().info("SAPM has been enabled!");
    }
}