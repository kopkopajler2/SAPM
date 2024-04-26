package com.popopapi.common.commands;

import com.popopapi.common.services.database.models.Group;
import com.popopapi.common.services.database.mybatis.services.GroupService;

public class UpdateGroupCommand {
    GroupService groupService=new GroupService();
    public boolean updateGroup(String groupName, String newName) {
        if (groupName == null || groupName.isEmpty() || newName == null || newName.isEmpty()) {
            return false;
        }
        Integer groupname=groupService.getGroupIdByName(groupName);
        //convert to a Group object
        Group group = new Group();
        group.setName(newName);
        group.setId(groupname);
        return groupService.updateGroup(group);

    }
}
