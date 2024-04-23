package commandhandler;

import com.popopapi.bukkit.implementations.BukkitGetAllPermissions;
import com.popopapi.common.commands.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public class BukkitCommands {
    private final GetAllGroupNamesCommand getAllGroupNamesCommand = new GetAllGroupNamesCommand();
    private final GetAllPlayerNamesCommand getAllPlayerNamesCommand = new GetAllPlayerNamesCommand();
    private final GetAllPermissionNamesCommand getAllPermissionNamesCommand = new GetAllPermissionNamesCommand();
    public BukkitCommands(JavaPlugin plugin) {
    }

    public boolean handleCommand(CommandSender sender, String label, String[] args) {
        if (args.length == 0) {
            return true;
        } else if (args[0].equalsIgnoreCase("creategroup")) {
            CreateGroupCommand createGroupCommand = new CreateGroupCommand();
            //get group name from args



            if (sender instanceof Player player) {
                if (createGroupCommand.createGroup(args[1])
                ) {
                    player.sendMessage("Group created!");
                } else {
                    player.sendMessage("Failed to create group!");
                }

            }
            return true;
        } else if (args[0].equalsIgnoreCase("deletegroup")) {
            DeleteGroupCommand deleteGroupCommand = new DeleteGroupCommand();
            //get group name from args
            if (sender instanceof Player player) {
                if (deleteGroupCommand.deleteGroup( args[1])) {
                    player.sendMessage("Group deleted!");
                } else {
                    player.sendMessage("Failed to delete group!");
                }
            }

            return true;
        } else if (args[0].equalsIgnoreCase("webeditor")) {
            //test
            new BukkitGetAllPermissions();


            return true;
        }


        else if (args[0].equalsIgnoreCase("group")) {
            if (args.length >= 4 && args[2].equalsIgnoreCase("addplayer")) {
                String groupName = args[1];
                String playerName = args[3];
                // Add player to the group
                if (addPlayerToGroup(groupName, playerName)) {
                    sender.sendMessage("Player " + playerName + " added to group " + groupName);
                } else {
                    sender.sendMessage("Failed to add player " + playerName + " to group " + groupName);
                }
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("deleteplayer")) {
                String groupName = args[1];
                String playerName = args[3];
                // Delete player from the group
                if (deletePlayerFromGroup(groupName, playerName)) {
                    sender.sendMessage("Player " + playerName + " deleted from group " + groupName);
                } else {
                    sender.sendMessage("Failed to delete player " + playerName + " from group " + groupName);
                }
                return true;
            } else if (args.length >= 5 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("add")) {
                String groupName = args[1];
                String permission = args[4];
                // Add permission to the group
                if (addPermissionToGroup(groupName, permission)) {
                    sender.sendMessage("Permission " + permission + " added to group " + groupName);
                } else {
                    sender.sendMessage("Failed to add permission " + permission + " to group " + groupName);
                }
                return true;
            }
            return handleGroupCommand(sender, args);
        }
        return false;
    }

    private boolean addPermissionToGroup(String groupName, String permission) {
        AddPermissionToGroupCommand addPermissionToGroupCommand = new AddPermissionToGroupCommand();
        return addPermissionToGroupCommand.bukkitAddPermissionToGroup(groupName, permission);
    }
    private boolean addPlayerToGroup(String groupName, String playerName) {
        AddPlayerToGroupCommand addPlayerToGroupCommand = new AddPlayerToGroupCommand();
        return addPlayerToGroupCommand.bukkitAddPlayerToGroup(playerName, groupName);



    }

    private boolean deletePlayerFromGroup(String groupName, String playerName) {
        DeletePlayerFromGroupCommand deletePlayerFromGroupCommand = new DeletePlayerFromGroupCommand();
        return deletePlayerFromGroupCommand.bukkitDeletePlayerFromGroup(playerName, groupName);
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
            } else return args[3].equalsIgnoreCase("show");
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
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("deletegroup") || args[0].equalsIgnoreCase("group")) {
                list.addAll(getAllGroupNamesCommand.getAllGroupNames());
            }
        } else if (args.length == 3 && args[0].equalsIgnoreCase("group")) {
            list.add("clear");
            list.add("info");
            list.add("rename");
            list.add("permission");
            list.add("addplayer");
            list.add("deleteplayer");
        } else if (args.length == 4 && args[0].equalsIgnoreCase("group")) {
            if (args[2].equalsIgnoreCase("addplayer") || args[2].equalsIgnoreCase("deleteplayer")) {
                list.addAll(getAllPlayerNamesCommand.getAllPlayerNames());
            } else if (args[2].equalsIgnoreCase("permission")) {
                list.add("add");
                list.add("remove");
                list.add("show");
            }
        } else if (args.length == 5 && args[0].equalsIgnoreCase("group") && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("add")) {
            list.addAll(getAllPermissionNamesCommand.getAllPermissionNames());
        }
        return list;
    }
}