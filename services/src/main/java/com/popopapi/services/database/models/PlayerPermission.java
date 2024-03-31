package com.popopapi.services.database.models;

public class PlayerPermission {
    private Integer playerId;
    private Integer permissionId;

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
    public int getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
