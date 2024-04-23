package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.GroupPermissionService;
import com.popopapi.common.services.database.mybatis.services.PermissionService;
import com.popopapi.common.services.database.mybatis.services.PlayerGroupService;

public class AddPermissionToGroupCommand {
    GroupPermissionService groupPermissionService = new GroupPermissionService();
    PermissionService permissionService = new PermissionService();
    PlayerGroupService playerGroupService = new PlayerGroupService();
    public boolean bukkitAddPermissionToGroup(String groupName, String permissionName) {
        //get permission id by name
        int permissionId = permissionService.getPermissionByName(permissionName);
        //get group id by name
        int groupId = playerGroupService.getPlayerGroupByName(groupName);
        //check if the permission is already assigned to the group
        if (groupPermissionService.isPermissionAssignedToGroup(groupId, permissionId)) {
            //permission is already assigned to the group, return false or inform the user
           return false;

        } else {
            //permission is not assigned to the group, proceed with the addition
            return groupPermissionService.addPermissionToGroup(groupId, permissionId);
        }
    }


}
