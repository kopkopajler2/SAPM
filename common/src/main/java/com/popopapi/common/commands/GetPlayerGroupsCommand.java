package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PlayerGroupService;
import com.popopapi.common.services.database.mybatis.services.PlayerService;

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
