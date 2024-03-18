package com.popopapi.common.permissions;

public interface PermissionCommandHandler {

        void sapm();
        void createGroup();
        void deleteGroup();
        void webEditor();
        void group(String groupName, String action);
        void groupPermission(String groupName, String action);

}

