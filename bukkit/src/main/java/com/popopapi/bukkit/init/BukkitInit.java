package com.popopapi.bukkit.init;
import  com.popopapi.common.init.InitDatabase;
import com.popopapi.common.init.StartupInit;
import commandhandler.BukkitCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;
public class BukkitInit implements StartupInit {
    private final JavaPlugin plugin;

    public BukkitInit(JavaPlugin plugin) {
        this.plugin = plugin;
        initCommands();
        CreateDatabase();
    }

    public void initCommands() {
        BukkitCommandHandler commandHandler = new BukkitCommandHandler(plugin);
        plugin.getCommand("sapm").setExecutor(commandHandler);
        plugin.getCommand("sapm").setTabCompleter(commandHandler);
    }
    public void CreateDatabase() {
        InitDatabase database = new InitDatabase();
        database.init();

    }




}