package com.popopapi.common.services.database.mybatis.mappers;

import java.util.List;

import com.popopapi.common.services.database.models.Group;

public interface GroupMapper {
    boolean createGroup(Group group);
    Group getGroupById(Integer id);
    List<Group> getAllGroups();
    List<String> getAllGroupNames();
    void updateGroup(Group group);
    boolean deleteGroup(Integer id);
    boolean deleteGroupByName(String group);
    int getGroupByName(String name);
}
