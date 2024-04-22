package com.popopapi.common.services.database.mybatis.mappers;

import java.util.List;

public interface GroupPermissionMapper {
    boolean addPermissionToGroup(int groupId, int permissionId);
    boolean removePermissionFromGroup(int groupId, int permissionId);
    List<Integer> getGroupPermissions(int groupId);
    List<Integer> getPermissionIdsByGroupIds(List<Integer> groupIds);

}