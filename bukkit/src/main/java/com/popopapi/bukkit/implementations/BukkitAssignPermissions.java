package com.popopapi.bukkit.implementations;

import com.popopapi.common.services.database.mybatis.databaseservices.PlayerService;
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
    private final   PlayerService playerService;
    private final Plugin plugin;

    public BukkitAssignPermissions(PermissionRetrieverService permissionAssignmentService,  Plugin plugin) {
        this.permissionAssignmentService = permissionAssignmentService;
        this.playerService = new PlayerService();


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
                if (attachment != null && player.hasPermission(attachment.getPermissions().keySet().iterator().next())) {
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

    public void AssignPermissionsToAllPlayers(){
        List<String> allPlayerUUIDs = playerService.getAllPlayerUUIDs();
        allPlayerUUIDs.forEach(this::AssignPermissions);
    }


}