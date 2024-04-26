package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.GroupPermissionService;
import com.popopapi.common.services.database.mybatis.services.GroupService;

public class ClearPermissionsFromGroupCommand {
    GroupPermissionService groupPermissionService = new GroupPermissionService();
    GroupService groupService = new GroupService();
    public boolean clearPermissionsFromGroupCommand(String groupName){
        //get group id by name
        groupPermissionService.clearPermissionsFromGroup(groupName);
        return true;
    }

}
