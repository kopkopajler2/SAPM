package com.popopapi.common.commands;
import com.popopapi.common.services.database.mybatis.services.GroupService;

import java.util.List;

public class GetAllGroupNamesCommand {
    // Create an instance of the GroupService
    GroupService groupService = new GroupService();
    public List<String> getAllGroupNames() {
        // Call the getAllGroupNames method
        return groupService.getAllGroupNames();
    }
}
