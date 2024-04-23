package com.popopapi.common.commands;

import com.popopapi.common.services.database.mybatis.services.PermissionService;

import java.util.List;

public class GetAllPermissionNamesCommand {
    PermissionService permissionService = new PermissionService();
    public List<String> getAllPermissionNames() {
        return permissionService.getAllPermissionNames();
    }
}
