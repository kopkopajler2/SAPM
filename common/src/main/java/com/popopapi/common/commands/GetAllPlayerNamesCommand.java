package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PlayerService;

import java.util.List;

public class GetAllPlayerNamesCommand {
    // Create an instance of the PlayerService
    PlayerService playerService = new PlayerService();
    public List<String> getAllPlayerNames() {
        // Call the getAllPlayerNames method
        return playerService.getAllPlayerNames();
    }
}
