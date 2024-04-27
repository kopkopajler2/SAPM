package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PlayerPermissionService;
import com.popopapi.common.services.database.mybatis.services.PlayerService;

import java.util.List;

public class GetPlayerPermissionsCommand {
    PlayerPermissionService playerPermissionService = new PlayerPermissionService();
    PlayerService playerService = new PlayerService();
    public List<String> getPlayerPermissions(String playerName) {
       //get player id
        Integer playerId = playerService.getPlayerIdByName(playerName);

        return playerPermissionService.getPlayerPermissionByName(playerId);
    }
}
