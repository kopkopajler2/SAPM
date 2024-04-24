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
        Integer permissionId = permissionService.getPermissionByName(permissionName);
        //if permissionId is null, return false
        if (permissionId == null) {
            return false;
        }
        //get group id by name
        Integer groupId = playerGroupService.getPlayerGroupByName(groupName);
        //return if null or 0
        if ( groupId == 0) {
            return false;
        }
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
