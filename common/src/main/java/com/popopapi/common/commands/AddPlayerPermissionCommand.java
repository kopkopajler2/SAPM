package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PermissionService;
import com.popopapi.common.services.database.mybatis.services.PlayerPermissionService;
import com.popopapi.common.services.database.mybatis.services.PlayerService;

public class AddPlayerPermissionCommand {
    PlayerPermissionService playerPermissionService = new PlayerPermissionService();
    PlayerService playerService = new PlayerService();
    PermissionService permissionService = new PermissionService();
    public boolean addPlayerPermission(String playerName, String permissionName) {
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
       return  playerPermissionService.addPermissionToPlayer(playerId, permissionId);


    }
}
