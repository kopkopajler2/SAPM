package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PlayerService;
import com.popopapi.common.services.database.models.Player;
import com.popopapi.common.events.PlayerJoinListener;

public class CreatePlayerCommand implements PlayerJoinListener {
    // Create an instance of the PlayerService
    PlayerService playerService = new PlayerService();

    @Override
    public void onPlayerJoin(Player player) {
        createPlayer(player.getUuid(), player.getUsername());
    }
    public boolean createPlayer(String uuid, String name){
        // Create a Player object and set its properties
        Player player = new Player(uuid, name);

        return playerService.createPlayer(player);

    }
}