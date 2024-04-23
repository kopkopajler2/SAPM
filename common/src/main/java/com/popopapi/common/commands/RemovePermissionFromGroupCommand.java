package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.GroupPermissionService;

public class RemovePermissionFromGroupCommand {
    GroupPermissionService groupPermissionService = new GroupPermissionService();
    public boolean removePermissionFromGroup(String groupName, String permission)
    {
        if(groupName == null || permission == null)             return false;

        return groupPermissionService.removePermissionFromGroupByName(groupName, permission);
    }
}
