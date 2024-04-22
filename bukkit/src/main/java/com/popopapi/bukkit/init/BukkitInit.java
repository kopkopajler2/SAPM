package com.popopapi.bukkit.init;
import com.popopapi.bukkit.implementations.BukkitConsoleLogger;
import com.popopapi.bukkit.implementations.BukkitGetAllPermissions;
import com.popopapi.bukkit.implementations.events.BukkitPlayerJoinListener;
import com.popopapi.common.init.StartupInit;
import com.popopapi.common.services.database.DatabaseSetup;
import com.popopapi.common.services.database.models.Player;
import com.popopapi.common.services.logger.MinecraftLogger;
import com.popopapi.common.services.permissions.PermissionRetrieverService;
import commandhandler.BukkitCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;
public class BukkitInit implements StartupInit {
    private final JavaPlugin plugin;


     public BukkitInit(JavaPlugin plugin) {
        this.plugin = plugin;
        initLogger();
        initCommands();
        createDatabase();
        savePermissions();
        initListeners();
    }

    public void initCommands() {
        BukkitCommandHandler commandHandler = new BukkitCommandHandler(plugin);
        plugin.getCommand("sapm").setExecutor(commandHandler);
        plugin.getCommand("sapm").setTabCompleter(commandHandler);
    }

    public void initListeners() {
        PermissionRetrieverService permissionAssignmentService = new PermissionRetrieverService();
        BukkitPlayerJoinListener playerJoinListener = new BukkitPlayerJoinListener(permissionAssignmentService, plugin);
        plugin.getServer().getPluginManager().registerEvents(playerJoinListener, plugin);
    }




    public void createDatabase() {
        new DatabaseSetup();

    }

    public void initLogger(){
        MinecraftLogger.setLogger(new BukkitConsoleLogger());
    }

    public void setPermissions(Player player) {

    }

    public void savePermissions(){
         new BukkitGetAllPermissions();


    }




}