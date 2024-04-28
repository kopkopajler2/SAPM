package com.popopapi.common.commands;
import com.popopapi.common.services.database.mybatis.databaseservices.GroupService;
public class DeleteGroupCommand {
    // Create an instance of the GroupService
    GroupService groupService = new GroupService();

    public boolean deleteGroup(String groupname) {

        return groupService.deleteGroupByName(groupname);
    }
}
