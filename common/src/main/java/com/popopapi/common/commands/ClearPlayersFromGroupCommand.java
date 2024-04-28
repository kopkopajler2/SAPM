package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.PlayerGroupService;

public class ClearPlayersFromGroupCommand {
    PlayerGroupService playerGroupService = new PlayerGroupService();
    public boolean clearPlayersFromGroupCommand(String groupName){
        //get group id by name
        Integer groupId = playerGroupService.getPlayerGroupByName(groupName);
        return playerGroupService.deleteAllPlayersFromGroup(groupId);

    }
}
