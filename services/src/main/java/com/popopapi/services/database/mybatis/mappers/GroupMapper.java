package com.popopapi.services.database.mybatis.mappers;

import java.util.List;
import com.popopapi.services.database.models.Group;
public interface GroupMapper {
    void createGroup(Group group);
    Group getGroupById(Integer id);
    List<Group> getAllGroups();
    void updateGroup(Group group);
    void deleteGroup(Integer id);

}
