package com.popopapi.common.services.database.mybatis.mappers;

import java.util.List;

public interface PlayerPermissionMapper {
    boolean addPermissionToPlayer(Integer playerId, Integer permissionId);
    boolean removePermissionFromPlayer(Integer playerId, Integer permissionId);
    List<Integer> getPlayerPermissions(Integer playerId);
    List<Integer> getPermissionIdsByPlayerId(Integer playerId);
}