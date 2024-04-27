package com.popopapi.common.services.database.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerPermissionMapper {
    boolean addPermissionToPlayer(@Param("playerId") Integer playerId, @Param("permissionId") Integer permissionId);
    boolean removePermissionFromPlayer(Integer playerId, Integer permissionId);
    List<Integer> getPlayerPermissions(Integer playerId);
    List<Integer> getPermissionIdsByPlayerId(Integer playerId);
}