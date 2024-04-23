package com.popopapi.bukkit.implementations.events;

import com.popopapi.common.services.permissions.PermissionRetrieverService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
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
        // Get the player using the UUID
        Player player = Bukkit.getPlayer(UUID.fromString(uuid));
        if (player != null) {
            // If the player is an operator, don't assign any permissions
            if (player.isOp()) {
                return;
            }

            // Clear all existing permissions
            for (PermissionAttachmentInfo attachmentInfo : player.getEffectivePermissions()) {
                PermissionAttachment attachment = attachmentInfo.getAttachment();
                if (attachment != null) {
                    player.removeAttachment(attachment);
                }
            }

            // Get the permissions to be assigned
            List<String> permissions = permissionAssignmentService.getPlayerPermissions(uuid);

            // Create a new permission attachment
            PermissionAttachment attachment = player.addAttachment(plugin);

            // Assign permissions to the player
            for (String permission : permissions) {
                // Ensure no permission is added twice
                if (!player.hasPermission(permission)) {
                    attachment.setPermission(permission, true);
                }
            }
        }
    }
}