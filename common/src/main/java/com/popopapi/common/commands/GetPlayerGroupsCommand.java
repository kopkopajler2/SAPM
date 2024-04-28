package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.PlayerGroupService;
import com.popopapi.common.services.database.mybatis.databaseservices.PlayerService;

import java.util.List;

public class GetPlayerGroupsCommand {
    PlayerGroupService playerGroupService = new PlayerGroupService();
    PlayerService playerService = new PlayerService();
    public List<String> getPlayerGroups(String playerName) {
        //get player id
        Integer playerId = playerService.getPlayerIdByName(playerName);

        return playerGroupService.getGroupNamesByPlayerId(playerId);
    }

}
