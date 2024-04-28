package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.PermissionService;
import com.popopapi.common.services.database.mybatis.databaseservices.PlayerPermissionService;
import com.popopapi.common.services.database.mybatis.databaseservices.PlayerService;

public class RemovePlayerPermissionCommand {
    PlayerPermissionService playerPermissionService = new PlayerPermissionService();
    PlayerService playerService = new PlayerService();
    PermissionService permissionService = new PermissionService();
    public boolean deletePlayerPermissions(String playerName, String permissionName) {
        //get permission id  by name
        Integer permissionId = permissionService.getPermissionByName(permissionName);
        //if permissionId is null, return false
        if (permissionId == null)  {
            return false;
        }
        //get player id by name
        Integer playerId = playerService.getPlayerIdByName(playerName);
        //return if null
        if (playerId == null) {
            return false;
        }
        return  playerPermissionService.removePermissionFromPlayer(playerId, permissionId);
    }
}
