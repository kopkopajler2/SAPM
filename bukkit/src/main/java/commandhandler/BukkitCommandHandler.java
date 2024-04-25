package commandhandler;

import com.popopapi.bukkit.implementations.events.BukkitAssignPermissions;
import com.popopapi.common.services.permissions.PermissionRetrieverService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

public class BukkitCommandHandler implements TabExecutor {
    private final BukkitAssignPermissions bukkitAssignPermissions;

    private final BukkitCommands commandHandler;
    public BukkitCommandHandler(JavaPlugin plugin) {
        this.bukkitAssignPermissions = new BukkitAssignPermissions(new PermissionRetrieverService(), plugin);
        this.commandHandler = new BukkitCommands(plugin);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sapm")||command.getName().equalsIgnoreCase("deop")) {
            boolean commandExecutedSuccessfully = commandHandler.handleCommand(sender, args);
            if (commandExecutedSuccessfully) {
                bukkitAssignPermissions.AssignPermissionsToAllPlayers();
            }
            return commandExecutedSuccessfully;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete( CommandSender sender,  Command command, String alias,  String[] args) {
        if (command.getName().equalsIgnoreCase("sapm")) {
            return commandHandler.handleTabComplete(sender, alias, args);
        }
        return null;
    }
}