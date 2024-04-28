package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.PlayerGroupService;
import com.popopapi.common.services.database.mybatis.databaseservices.PlayerService;

public class DeletePlayerFromGroupCommand {
    PlayerGroupService playerGroupService = new PlayerGroupService();
    PlayerService playerService = new PlayerService();

    public boolean bukkitDeletePlayerFromGroup(String playerName, String groupName) {
        //get player id by name
        Integer playerId = playerService.getPlayerIdByName(playerName);
        //get group id by name
        Integer groupId = playerGroupService.getPlayerGroupByName(groupName);

        return playerGroupService.deletePlayerFromGroup(playerId, groupId);
    }
}
