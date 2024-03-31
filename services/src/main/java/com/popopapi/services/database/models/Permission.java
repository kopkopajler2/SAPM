package com.popopapi.services.database.models;

public class Permission {
    private Integer id;
    private String permission;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
