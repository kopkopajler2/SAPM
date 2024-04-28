package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.GroupPermissionService;

public class ClearPermissionsFromGroupCommand {
    GroupPermissionService groupPermissionService = new GroupPermissionService();

    public boolean clearPermissionsFromGroupCommand(String groupName){
        //get group id by name
      return  groupPermissionService.clearPermissionsFromGroup(groupName);

    }

}
