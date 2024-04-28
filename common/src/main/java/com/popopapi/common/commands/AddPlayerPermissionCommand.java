package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.PermissionService;
import com.popopapi.common.services.database.mybatis.databaseservices.PlayerPermissionService;
import com.popopapi.common.services.database.mybatis.databaseservices.PlayerService;

public class AddPlayerPermissionCommand {
    PlayerPermissionService playerPermissionService = new PlayerPermissionService();
    PlayerService playerService = new PlayerService();
    PermissionService permissionService = new PermissionService();
    public boolean addPlayerPermission(String playerName, String permissionName) {
        Integer permissionId = permissionService.getPermissionByName(permissionName);
        Integer playerId = playerService.getPlayerIdByName(playerName);

        if (permissionId == null || playerId == null || playerPermissionService.playerHasPermission(playerId, permissionId)) {
            return false;
        }

        return playerPermissionService.addPermissionToPlayer(playerId, permissionId);
    }
}
