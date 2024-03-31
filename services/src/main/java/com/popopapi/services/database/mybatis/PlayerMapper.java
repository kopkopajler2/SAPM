package com.popopapi.services.database.mybatis;
import com.popopapi.services.database.models.Player;
import java.util.List;
public interface PlayerMapper {
    void createPlayer(Player player);
    Player getPlayerById(Integer id);
    List<Player> getAllPlayers();
    void updatePlayer(Player player);
    void deletePlayer(Integer id);
}
