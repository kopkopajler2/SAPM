package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.databaseservices.GroupPermissionService;

import java.util.List;

public class GetGroupPermissionsCommand {
    GroupPermissionService groupPermissionService = new GroupPermissionService();
    public List<String> getGroupPermissions(String groupName)
    {

        return groupPermissionService.getGroupPermissionsByGroupName(groupName);
    }

}
