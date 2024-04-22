package com.popopapi.common.services.permissions;

import com.popopapi.common.services.database.models.Permission;
import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PermissionRetrieverService implements PermissionAssignment{
    @Override
    public List<String> getPlayerPermissions(String uuid) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            GroupPermissionMapper groupPermissionMapper = sqlSession.getMapper(GroupPermissionMapper.class);
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            // Get the player ID based on the UUID
            Integer playerId = playerMapper.getPlayerIdByUUID(uuid);
            if (playerId == null) {
                // Player not found, handle accordingly (e.g., create a new player record)
                return null;
            }

            // Get the list of group IDs the player belongs to
            List<Integer> groupIds = playerGroupMapper.getGroupIdsByPlayerId(playerId);

            // Get the list of permission IDs directly assigned to the player
            List<Integer> playerPermissionIds = playerPermissionMapper.getPermissionIdsByPlayerId(playerId);

            // Get the list of permission IDs assigned to the player's groups
            List<Integer> groupPermissionIds = groupPermissionMapper.getPermissionIdsByGroupIds(groupIds);

            // Combine the player permissions and group permissions
            List<Integer> allPermissionIds = new ArrayList<>(playerPermissionIds);
            allPermissionIds.addAll(groupPermissionIds);

            // Retrieve the actual permission strings based on the permission IDs
            return allPermissionIds.stream()
                    .map(permissionId -> {
                        Permission permission = permissionMapper.getPermissionById(permissionId);
                        return permission != null ? permission.getPermission() : null;
                    })
                    .filter(Objects::nonNull)
                    .toList();

            // Assign the permissions to the player (e.g., using a permission plugin API)
            // Code to assign permissions goes here
            // ...
        }
    }
}