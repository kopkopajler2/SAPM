package commandhandler;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import  com.popopapi.common.commands.*;
public class BukkitCommands {

    public BukkitCommands(JavaPlugin plugin) {
    }

    public boolean handleCommand(CommandSender sender, String label, String[] args) {
        if (args.length == 0) {
            return true;
        } else if (args[0].equalsIgnoreCase("creategroup")) {
            return true;
        } else if (args[0].equalsIgnoreCase("deletegroup")) {
            return true;
        } else if (args[0].equalsIgnoreCase("webeditor")) {
            //send message to player
            if (sender instanceof Player player) {
                player.sendMessage("Opening web editor...");
            }

            return true;
        } else if (args[0].equalsIgnoreCase("group")) {
            return handleGroupCommand(sender, args);
        }
        return false;
    }

    private boolean handleGroupCommand(CommandSender sender, String[] args) {
        if (args.length == 2) {
            return true;
        } else if (args.length == 3) {
            if (args[2].equalsIgnoreCase("clear")) {
                return true;
            } else if (args[2].equalsIgnoreCase("info")) {
                return true;
            } else if (args[2].equalsIgnoreCase("rename")) {
                return true;
            } else if (args[2].equalsIgnoreCase("permission")) {
                return handlePermissionCommand(sender, args);
            }
        }
        return false;
    }

    private boolean handlePermissionCommand(CommandSender sender, String[] args) {
        if (args.length == 4) {
            if (args[3].equalsIgnoreCase("add")) {
                return true;
            } else if (args[3].equalsIgnoreCase("remove")) {
                return true;
            } else if (args[3].equalsIgnoreCase("show")) {
                return true;
            }
        }
        return false;
    }

    public List<String> handleTabComplete(CommandSender sender, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            list.add("creategroup");
            list.add("deletegroup");
            list.add("webeditor");
            list.add("group");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("group")) {
            list.add("[groupname]");
        } else if (args.length == 3 && args[0].equalsIgnoreCase("group")) {
            list.add("clear");
            list.add("info");
            list.add("rename");
            list.add("permission");
        } else if (args.length == 4 && args[0].equalsIgnoreCase("group") && args[2].equalsIgnoreCase("permission")) {
            list.add("add");
            list.add("remove");
            list.add("show");
        }
        return list;
    }
}