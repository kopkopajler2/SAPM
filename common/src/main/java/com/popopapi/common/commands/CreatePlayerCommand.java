package com.popopapi.common.commands;
import com.popopapi.services.database.mybatis.PlayerService;
import com.popopapi.services.database.models.Player;

public class CreatePlayerCommand {
    // Create an instance of the PlayerService
    PlayerService playerService = new PlayerService();

    public void createPlayer() {
        // Create a Player object and set its properties
        Player player = new Player();
        player.setUuid("player-uuid");
        player.setUsername("player-username");
        // Call the createPlayer method
        playerService.createPlayer(player);
    }
}