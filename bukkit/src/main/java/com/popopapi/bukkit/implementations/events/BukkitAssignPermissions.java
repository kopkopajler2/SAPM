package com.popopapi.bukkit.implementations.events;
import com.popopapi.common.services.permissions.PermissionRetrieverService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.UUID;

public class BukkitAssignPermissions {
    private final PermissionRetrieverService permissionAssignmentService;
    private final Plugin plugin;
    public BukkitAssignPermissions(PermissionRetrieverService permissionAssignmentService, Plugin plugin) {
        this.permissionAssignmentService = permissionAssignmentService;
        this.plugin = plugin;
    }

    public void AssignPermissions(String uuid) {
        List<String> permissions = permissionAssignmentService.getPlayerPermissions(uuid);

        // Get the player using the UUID
        Player player = Bukkit.getPlayer(UUID.fromString(uuid));
        if (player != null) {
            // Create a new permission attachment
            PermissionAttachment attachment = player.addAttachment(plugin);

            // Assign permissions to the player
            for (String permission : permissions) {
                attachment.setPermission(permission, true);
            }
        }
    }
}
