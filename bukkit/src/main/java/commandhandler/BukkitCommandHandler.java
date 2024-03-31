package commandhandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

public class BukkitCommandHandler implements TabExecutor {
    private final BukkitCommands commandHandler;
    public BukkitCommandHandler(JavaPlugin plugin) {
        this.commandHandler = new BukkitCommands(plugin);
    }


    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sapm")) {
            return commandHandler.handleCommand(sender, label, args);
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