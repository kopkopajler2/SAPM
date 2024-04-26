package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PlayerGroupService;

import java.util.List;

public class GetGroupPlayersCommand {
    PlayerGroupService playerGroupService = new PlayerGroupService();
    public List<String> getGroupPlayers(String groupName)
    {
        //get group id by name
        Integer groupId = playerGroupService.getPlayerGroupByName(groupName);

        return playerGroupService.getAllPlayerNamesFromGroup(groupId);
    }
}
