package com.popopapi.common.services.database.models;

 public class Player {
    private Integer id;
    private String uuid;
    private String username;
     public Player(String uuid, String username) {
         this.uuid = uuid;
         this.username = username;
     }
    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getUsername() {
        return username;
    }



}
