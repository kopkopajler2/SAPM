package com.popopapi.common.services.database.mybatis.mappers;
import com.popopapi.common.services.database.models.PlayerGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface PlayerGroupMapper  {

    boolean createPlayerGroup(PlayerGroup playerGroup);
    PlayerGroup getPlayerGroupById(Integer id);
    List<PlayerGroup> getAllPlayerGroups();
    List<String> getAllPlayerGroupNames();
    void updatePlayerGroup(PlayerGroup playerGroup);
    boolean deletePlayerGroup(Integer id);
    boolean deletePlayerGroupByName(String playerGroup);
    Integer getPlayerGroupByName(String name);
    //getGroupIdsByPlayerId
    List<Integer> getGroupIdsByPlayerId(Integer playerId);
    //add player to group
    boolean addPlayerToGroup(@Param("playerId") Integer playerId, @Param("groupId") Integer groupId);
    boolean deletePlayerFromGroup(@Param("playerId") Integer playerId, @Param("groupId") Integer groupId);
    boolean deleteAllPlayersFromGroup(Integer groupId);
}
