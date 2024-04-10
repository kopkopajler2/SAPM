package com.popopapi.services.database.models;

 public class GroupPermission {
    private Integer groupId;
    private Integer permissionId;

    // Getters and Setters
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public int getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
