package com.popopapi.bukkit.implementations.events;

import com.popopapi.common.events.PlayerJoinListener;
import com.popopapi.common.commands.CreatePlayerCommand;
import com.popopapi.common.services.permissions.PermissionRetrieverService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;


public class BukkitPlayerJoinListener implements Listener {
    private final PlayerJoinListener playerJoinListener;
    private final BukkitAssignPermissions bukkitAssignPermissions;

    public BukkitPlayerJoinListener(PermissionRetrieverService permissionAssignmentService, Plugin plugin) {
        this.playerJoinListener = new CreatePlayerCommand();
        this.bukkitAssignPermissions = new BukkitAssignPermissions(permissionAssignmentService, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String uuid = event.getPlayer().getUniqueId().toString();
        String name = event.getPlayer().getName();

        // Call the existing player join listener
        playerJoinListener.onPlayerJoin(new com.popopapi.common.services.database.models.Player(uuid, name));

        // If the player is an operator, don't assign any permissions
        if (!event.getPlayer().isOp()) {
            // Assign permissions to the player
            bukkitAssignPermissions.AssignPermissions(uuid);
        }
    }
}