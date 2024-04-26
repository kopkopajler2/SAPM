package com.popopapi.common.services.database.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupPermissionMapper {
    boolean addPermissionToGroup(@Param("groupId") int groupId, @Param("permissionId") int permissionId);
    boolean removePermissionFromGroup(int groupId, int permissionId);
    boolean removePermissionFromGroupByName(@Param("groupName") String groupName, @Param("permission") String permission);
    List<String> getGroupPermissions(int groupId);
    List<Integer> getPermissionIdsByGroupIds(List<Integer> groupIds);
    List<String> getGroupPermissionsByGroupName(String groupName);
    boolean isPermissionAssignedToGroup(@Param("groupId") Integer groupId, @Param("permissionId") Integer permissionId);
    boolean clearPermissionsFromGroup(String GroupName);
}
