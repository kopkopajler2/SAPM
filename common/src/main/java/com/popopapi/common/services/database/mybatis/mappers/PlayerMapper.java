package com.popopapi.common.services.database.mybatis.mappers;
import com.popopapi.common.services.database.models.Player;

import java.util.List;
public interface PlayerMapper {
    boolean createPlayer(Player player);
    Player getPlayerByName(String name);

    //get player id by uuid
    Integer getPlayerIdByUUID(String uuid);


    List<String> getPlayerPermissions(String uuid);
    //get all player names
    List<String> getAllPlayerNames();
    //get player id by name
    Integer getPlayerIdByName(String playerName);
    List<String> getAllPlayerUUIDs();
}
