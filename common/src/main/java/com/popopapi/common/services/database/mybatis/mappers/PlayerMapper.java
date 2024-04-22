package com.popopapi.common.services.database.mybatis.mappers;
import com.popopapi.common.services.database.models.Player;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface PlayerMapper {
    boolean createPlayer(Player player);
    Player getPlayerById(Integer id);
    Player getPlayerByName(String name);
    List<Player> getAllPlayers();
    void updatePlayer(Player player);
    void deletePlayer(Integer id);
    void AssignPermissionsToPlayer(Player player);
    //get player id by uuid
    Integer getPlayerIdByUUID(String uuid);


    List<String> getPlayerPermissions(String uuid);
}
