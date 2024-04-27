package commandhandler;

import com.popopapi.bukkit.implementations.BukkitGetAllPermissions;
import com.popopapi.common.commands.*;
import com.popopapi.common.services.database.mybatis.services.PlayerService;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
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
    private final ClearPermissionsFromGroupCommand clearPermissionsFromGroupCommand = new ClearPermissionsFromGroupCommand();
    private final GetGroupPlayersCommand getGroupPlayersCommand = new GetGroupPlayersCommand();
    private final UpdateGroupCommand updateGroupCommand = new UpdateGroupCommand();
    private final AddPlayerPermissionCommand addPlayerPermissionCommand = new AddPlayerPermissionCommand();
    private  final RemovePlayerPermissionCommand removePlayerPermissionCommand = new RemovePlayerPermissionCommand();
    private  final GetPlayerPermissionsCommand getPlayerPermissionsCommand = new GetPlayerPermissionsCommand();
    private final GetPlayerGroupsCommand getPlayerGroupsCommand = new GetPlayerGroupsCommand();
    public BukkitCommands(JavaPlugin plugin) {
    }

    public boolean handleCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {
            return true;
        } else if (args.length >= 2 && args[0].equalsIgnoreCase("creategroup")) {
            CreateGroupCommand createGroupCommand = new CreateGroupCommand();


            if (createGroupCommand.createGroup(args[1])) {
                sender.sendMessage("Group created!");
            } else {
                sender.sendMessage("Failed to create group!");

            }
            return true;
        } else if (args.length >= 2 && args[0].equalsIgnoreCase("deletegroup")) {
            DeleteGroupCommand deleteGroupCommand = new DeleteGroupCommand();

            if (deleteGroupCommand.deleteGroup(args[1])) {
                sender.sendMessage("Group deleted!");
            } else {
                sender.sendMessage("Failed to delete group!");
            }


            return true;
        } else if (args[0].equalsIgnoreCase("webeditor")) {
            //TODO: Implement web editor
            String playerName="popopapi";
            List<String> faszosgeci= getPlayerPermissionsCommand.getPlayerPermissions(playerName);
            Bukkit.getLogger().info("faszosgeci: "+faszosgeci);
            PlayerService playerService = new PlayerService();
            Integer ok=playerService.getPlayerIdByName("user");
            Bukkit.getLogger().info("id: "+ok);
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
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("clear") && args[3].equalsIgnoreCase("players")) {
                // group [name] clear players command
                String groupName = args[1];
                if (clearPlayersFromGroupCommand.clearPlayersFromGroupCommand(groupName)) {
                    sender.sendMessage("Cleared players from group " + groupName);
                } else {
                    sender.sendMessage("Failed to clear players from group " + groupName);
                }
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("clear") && args[3].equalsIgnoreCase("permissions")) {
                // group [name] clear permissions command
                String groupName = args[1];
                if (clearPermissionsFromGroupCommand.clearPermissionsFromGroupCommand(groupName)) {
                    sender.sendMessage("Cleared permissions from group " + groupName);
                } else {
                    sender.sendMessage("Failed to clear permissions from group " + groupName);
                }
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("info") && args[3].equalsIgnoreCase("players")) {
                // group [name] info players command
                String groupName = args[1];
                List<String> groupnames = getGroupPlayersCommand.getGroupPlayers(groupName);
                sender.sendMessage("Players in group " + groupName + ": " + String.join(", ", groupnames));
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("info") && args[3].equalsIgnoreCase("permissions")) {
                // group [name] info permissions command
                String groupName = args[1];
                sender.sendMessage("Permissions for group " + groupName + ": " + String.join(", ", getGroupPermissionsCommand.getGroupPermissions(groupName)));
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("rename")) {
                // group [name] rename command
                String groupName = args[1];
                String newGroupName = args[3];
                // Implement renaming the group
                if (updateGroupCommand.updateGroup(groupName, newGroupName)) {
                    sender.sendMessage("Group renamed to " + newGroupName);
                } else {
                    sender.sendMessage("Failed to rename group to " + newGroupName);
                }
                return true;
            }
            return handleGroupCommand(sender, args);
        } else if (args[0].equalsIgnoreCase("player")) {
            if (args.length >= 5 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("add")) {
                // player [name] permission add command
                String playerName = args[1];
                String permission = args[4];
                if(addPlayerPermissionCommand.addPlayerPermission(playerName, permission)) {
                    sender.sendMessage("Added permission " + permission + " to player " + playerName);
                } else {
                    sender.sendMessage("Failed to add permission " + permission + " to player " + playerName);
                }

                return true;
            } else if (args.length >= 5 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("remove")) {
                // player [name] permission remove command
                String playerName = args[1];
                String permission = args[4];
                if(removePlayerPermissionCommand.deletePlayerPermissions(playerName, permission)) {
                    sender.sendMessage("Removed permission " + permission + " from player " + playerName);
                } else {
                    sender.sendMessage("Failed to remove permission " + permission + " from player " + playerName);
                }
                return true;
            } else if (args.length >= 4 && args[2].equalsIgnoreCase("permission") && args[3].equalsIgnoreCase("show")) {
                // player [name] permission show command
                String playerName = args[1];

                sender.sendMessage("Permissions for player " + playerName + ": " + String.join(", ", getPlayerPermissionsCommand.getPlayerPermissions(playerName)));
                return true;
            } else if (args.length >= 3 && args[2].equalsIgnoreCase("info")) {
                // player [name] info command
                String playerName = args[1];
                sender.sendMessage(playerName+ " belongs to the following groups: ");
                sender.sendMessage(String.join(", ", getPlayerGroupsCommand.getPlayerGroups(playerName)));
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
        } else if (args.length >= 3) {
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
        if (args.length >= 4) {
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
        }  else if (args.length == 5 && args[0].equalsIgnoreCase("player") && args[2].equalsIgnoreCase("permission")) {
            if (args[3].equalsIgnoreCase("add")) {
                list.addAll(getAllPermissionNamesCommand.getAllPermissionNames());
            } else if (args[3].equalsIgnoreCase("remove")) {

                String playerName = args[1];

                list.addAll(getPlayerPermissionsCommand.getPlayerPermissions(playerName));

            }
        }
        return list;
    }
}