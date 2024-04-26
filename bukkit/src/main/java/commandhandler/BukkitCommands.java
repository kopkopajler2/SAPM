package commandhandler;

import com.popopapi.bukkit.implementations.BukkitGetAllPermissions;
import com.popopapi.bukkit.implementations.events.BukkitAssignPermissions;
import com.popopapi.common.commands.*;
import com.popopapi.common.services.permissions.PermissionRetrieverService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public class BukkitCommands {
    private final GetAllGroupNamesCommand getAllGroupNamesCommand = new GetAllGroupNamesCommand();
    private final GetAllPlayerNamesCommand getAllPlayerNamesCommand = new GetAllPlayerNamesCommand();
    private final GetAllPermissionNamesCommand getAllPermissionNamesCommand = new GetAllPermissionNamesCommand();
    private final GetGroupPermissionsCommand getGroupPermissionsCommand = new GetGroupPermissionsCommand();
    private final RemovePermissionFromGroupCommand removePermissionFromGroupCommand = new RemovePermissionFromGroupCommand();
    private final ClearPlayersFromGroupCommand clearPlayersFromGroupCommand = new ClearPlayersFromGroupCommand();
    private final BukkitAssignPermissions bukkitAssignPermissions;
    private final GetGroupPlayersCommand getGroupPlayersCommand = new GetGroupPlayersCommand();

    public BukkitCommands(JavaPlugin plugin) {
        this.bukkitAssignPermissions = new BukkitAssignPermissions(new PermissionRetrieverService(), plugin);
    }

    public boolean handleCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {
            return true;
        } else if (args[0].equalsIgnoreCase("creategroup")) {
            CreateGroupCommand createGroupCommand = new CreateGroupCommand();

            if (sender instanceof Player player) {
                if (createGroupCommand.createGroup(args[1])) {
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
                if (deleteGroupCommand.deleteGroup(args[1])) {
                    player.sendMessage("Group deleted!");
                } else {
                    player.sendMessage("Failed to delete group!");
                }
            }

            return true;
        } else if (args[0].equalsIgnoreCase("webeditor")) {
            //TODO: Implement web editor
            return true;
        } else if (args[0].equalsIgnoreCase("listgroups")) {
            // listgroups command
            sender.sendMessage("List of groups: " + String.join(", ", getAllGroupNamesCommand.getAllGroupNames()));
            return true;
        } else if (args[0].equalsIgnoreCase("group")) {
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
            } else if (args.length >= 5 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("remove")) {
                String groupName = args[1];
                String permission = args[4];
                // Remove permission from the group
                if (removePermissionFromGroupCommand.removePermissionFromGroup(groupName, permission)) {
                    sender.sendMessage("Permission " + permission + " removed from group " + groupName);
                } else {
                    sender.sendMessage("Failed to remove permission " + permission + " from group " + groupName);
                }
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("show")) {
                // group [name] permission show command
                String groupName = args[1];
                sender.sendMessage("Permissions for group " + groupName + ": " + String.join(", ", getGroupPermissionsCommand.getGroupPermissions(groupName)));
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("clear") && args[3].equalsIgnoreCase("players")) {
                // group [name] clear players command
                String groupName = args[1];
                // TODO: Implement clearing players from the group
                //TODO FIX group deleteplayer autocomplete minden playert listaz
                if(clearPlayersFromGroupCommand.clearPlayersFromGroupCommand(groupName)){
                    sender.sendMessage("Cleared players from group " + groupName);
                } else {
                    sender.sendMessage("Failed to clear players from group " + groupName);
                }
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("clear") && args[3].equalsIgnoreCase("permissions")) {
                // group [name] clear permissions command
                String groupName = args[1];
                // TODO: Implement clearing permissions from the group
                sender.sendMessage("Clearing permissions from group " + groupName);
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("info") && args[3].equalsIgnoreCase("players")) {
                // group [name] info players command
                String groupName = args[1];
                // TODO: Implement showing player info for the group
                sender.sendMessage("Player info for group " + groupName);
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("info") && args[3].equalsIgnoreCase("permissions")) {
                // group [name] info permissions command
                String groupName = args[1];
                sender.sendMessage("Permissions for group " + groupName + ": " + String.join(", ", getGroupPermissionsCommand.getGroupPermissions(groupName)));
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("rename")) {
                // group [name] rename command
                String groupName = args[1];
                String newGroupName = args[3];
                // TODO: Implement renaming the group
                sender.sendMessage("Renaming group " + groupName + " to " + newGroupName);
                return true;
            }
            return handleGroupCommand(sender, args);
        } else if (args[0].equalsIgnoreCase("player")) {
            if (args.length >= 4 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("add")) {
                // player [name] permission add command
                String playerName = args[1];
                String permission = args[4];
                // TODO: Implement adding permission to the player
                sender.sendMessage("Adding permission " + permission + " to player " + playerName);
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("remove")) {
                // player [name] permission remove command
                String playerName = args[1];
                String permission = args[4];
                // TODO: Implement removing permission from the player
                sender.sendMessage("Removing permission " + permission + " from player " + playerName);
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("show")) {
                // player [name] permission show command
                String playerName = args[1];
                // TODO: Implement showing player permissions
                sender.sendMessage("Permissions for player " + playerName);
                return true;
            } else if (args.length >= 2 && args[2].equalsIgnoreCase("info")) {
                // player [name] info command
                String playerName = args[1];
                // TODO: Implement showing player info
                sender.sendMessage("Info for player " + playerName);
                return true;
            }
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
            list.add("listgroups");
            list.add("group");
            list.add("player");
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("deletegroup") || args[0].equalsIgnoreCase("group")) {
                list.addAll(getAllGroupNamesCommand.getAllGroupNames());
            } else if (args[0].equalsIgnoreCase("player")) {
                list.addAll(getAllPlayerNamesCommand.getAllPlayerNames());
            }
        } else if (args.length == 3 && args[0].equalsIgnoreCase("group")) {
            list.add("clear");
            list.add("info");
            list.add("rename");
            list.add("permission");
            list.add("addplayer");
            list.add("deleteplayer");
        } else if (args.length == 3 && args[0].equalsIgnoreCase("player")) {
            list.add("permission");
            list.add("info");
        } else if (args.length == 4 && args[0].equalsIgnoreCase("group")) {
            if (args[2].equalsIgnoreCase("addplayer")) {
                list.addAll(getAllPlayerNamesCommand.getAllPlayerNames());
            } else if (args[2].equalsIgnoreCase("deleteplayer")) {
                String groupName = args[1];
                list.addAll(getGroupPlayersCommand.getGroupPlayers(groupName));
            } else if (args[2].equalsIgnoreCase("permission")) {
                list.add("add");
                list.add("remove");
                list.add("show");
            } else if (args[2].equalsIgnoreCase("clear")) {
                list.add("players");
                list.add("permissions");
            } else if (args[2].equalsIgnoreCase("info")) {
                list.add("players");
                list.add("permissions");
            }
        } else if (args.length == 4 && args[0].equalsIgnoreCase("player") && args[2].equalsIgnoreCase("permission")) {
            list.add("add");
            list.add("remove");
            list.add("show");
        } else if (args.length == 5 && args[0].equalsIgnoreCase("group") && args[2].equalsIgnoreCase("permission")) {
            new BukkitGetAllPermissions();
            if (args[3].equalsIgnoreCase("add")) {
                list.addAll(getAllPermissionNamesCommand.getAllPermissionNames());
            } else if (args[3].equalsIgnoreCase("remove")) {
                String groupName = args[1];
                list.addAll(getGroupPermissionsCommand.getGroupPermissions(groupName));
            }
        } else if (args.length == 5 && args[0].equalsIgnoreCase("player") && args[2].equalsIgnoreCase("permission") && (args[3].equalsIgnoreCase("add") || args[3].equalsIgnoreCase("remove"))) {
            new BukkitGetAllPermissions();
            list.addAll(getAllPermissionNamesCommand.getAllPermissionNames());
        }
        return list;
    }
}