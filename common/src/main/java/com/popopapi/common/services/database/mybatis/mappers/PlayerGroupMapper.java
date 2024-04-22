package com.popopapi.common.services.database.mybatis.mappers;
import com.popopapi.common.services.database.models.PlayerGroup;
import java.util.List;
public interface PlayerGroupMapper {
    boolean createPlayerGroup(PlayerGroup playerGroup);
    PlayerGroup getPlayerGroupById(Integer id);
    List<PlayerGroup> getAllPlayerGroups();
    List<String> getAllPlayerGroupNames();
    void updatePlayerGroup(PlayerGroup playerGroup);
    boolean deletePlayerGroup(Integer id);
    boolean deletePlayerGroupByName(String playerGroup);
    int getPlayerGroupByName(String name);
    //getGroupIdsByPlayerId
    List<Integer> getGroupIdsByPlayerId(Integer playerId);
}
