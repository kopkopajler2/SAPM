package com.popopapi.common.commands;
import com.popopapi.services.database.mybatis.services.PlayerService;
import com.popopapi.services.database.models.Player;

public class CreatePlayerCommand {
    // Create an instance of the PlayerService
    PlayerService playerService = new PlayerService();

    //don't actually need this method, just for demonstration purposes
    public void createPlayer() {
        // Create a Player object and set its properties
        Player player = new Player();
        player.setUuid("player-uuid");
        player.setUsername("player-username");
        // Call the createPlayer method
        playerService.createPlayer(player);
    }
}