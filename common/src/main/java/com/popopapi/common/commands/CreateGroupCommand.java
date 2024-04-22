package com.popopapi.common.commands;

import com.popopapi.common.services.database.models.Group;
import com.popopapi.common.services.database.mybatis.services.GroupService;

public class CreateGroupCommand {
    // Create an instance of the GroupService
    GroupService groupService = new GroupService();

    public boolean createGroup(String groupname) {
        // Create a Group object and set its properties
        Group group = new Group();
        group.setName(groupname);
        // Call the createGroup method
        return groupService.createGroup(group);
    }
}
