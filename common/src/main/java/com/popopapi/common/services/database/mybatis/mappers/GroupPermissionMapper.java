package com.popopapi.common.services.database.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupPermissionMapper {
    boolean addPermissionToGroup(@Param("groupId") int groupId, @Param("permissionId") int permissionId);
    boolean removePermissionFromGroup(int groupId, int permissionId);
    List<Integer> getGroupPermissions(int groupId);
    List<Integer> getPermissionIdsByGroupIds(List<Integer> groupIds);
    boolean isPermissionAssignedToGroup(@Param("groupId") Integer groupId, @Param("permissionId") Integer permissionId);

}