package com.popopapi.common.events;

import com.popopapi.common.services.database.models.Player;

public interface PlayerJoinListener {
    void onPlayerJoin(Player player);
}
