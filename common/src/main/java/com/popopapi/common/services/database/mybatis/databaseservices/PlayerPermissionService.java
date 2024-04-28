package com.popopapi.common.services.database.mybatis.databaseservices;

import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.PlayerPermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PlayerPermissionService implements PlayerPermissionMapper{
    public boolean addPermissionToPlayer(Integer playerId, Integer permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            boolean result = playerPermissionMapper.addPermissionToPlayer(playerId, permissionId);
            sqlSession.commit();
            return result;
        }
    }

    public boolean removePermissionFromPlayer(Integer playerId, Integer permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            boolean result = playerPermissionMapper.removePermissionFromPlayer(playerId, permissionId);
            sqlSession.commit();
            return result;
        }
    }

    public List<Integer> getPlayerPermissions(Integer playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            return playerPermissionMapper.getPlayerPermissions(playerId);
        }
    }
    public List<String> getPlayerPermissionByName(Integer playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            return playerPermissionMapper.getPlayerPermissionByName(playerId);
        }
    }
    public List<Integer> getPermissionIdsByPlayerId(Integer playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            return playerPermissionMapper.getPermissionIdsByPlayerId(playerId);
        }
    }

    public boolean playerHasPermission(Integer playerId, Integer permissionId) {
          SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
                return playerPermissionMapper.playerHasPermission(playerId, permissionId);
            }

    }

}