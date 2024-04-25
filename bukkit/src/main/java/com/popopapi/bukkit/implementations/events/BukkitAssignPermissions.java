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
        Player player = Bukkit.getPlayer(UUID.fromString(uuid));
        if (player != null) {
            if (player.isOp()) {
                return;
            }

            for (PermissionAttachmentInfo attachmentInfo : player.getEffectivePermissions()) {
                PermissionAttachment attachment = attachmentInfo.getAttachment();
                if (attachment != null) {
                    player.removeAttachment(attachment);
                }
            }

            List<String> permissions = permissionAssignmentService.getPlayerPermissions(uuid);
            PermissionAttachment attachment = player.addAttachment(plugin);

            for (String permission : permissions) {
                if (!player.hasPermission(permission)) {
                    attachment.setPermission(permission, true);
                }
            }

            player.recalculatePermissions();
            player.updateCommands();
        }
    }


}