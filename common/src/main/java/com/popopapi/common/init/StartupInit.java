package com.popopapi.common.init;


import com.popopapi.common.services.database.models.Player;

//each minecraft server will have to implement this interface
public interface StartupInit {
    void initCommands();
    void initListeners();
    void createDatabase();
    void setPermissions(Player player);
    void savePermissions();
}
