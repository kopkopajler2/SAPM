package com.popopapi.common.services.database.mybatis.mappers;

import java.util.List;

public interface PlayerPermissionMapper {
    boolean addPermissionToPlayer(int playerId, int permissionId);
    boolean removePermissionFromPlayer(int playerId, int permissionId);
    List<Integer> getPlayerPermissions(int playerId);
    List<Integer> getPermissionIdsByPlayerId(int playerId);
}