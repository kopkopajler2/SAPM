package com.popopapi.common.services.database.mybatis.services;

import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.PlayerPermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PlayerPermissionService implements PlayerPermissionMapper{
    public boolean addPermissionToPlayer(int playerId, int permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            boolean result = playerPermissionMapper.addPermissionToPlayer(playerId, permissionId);
            sqlSession.commit();
            return result;
        }
    }

    public boolean removePermissionFromPlayer(int playerId, int permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            boolean result = playerPermissionMapper.removePermissionFromPlayer(playerId, permissionId);
            sqlSession.commit();
            return result;
        }
    }

    public List<Integer> getPlayerPermissions(int playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            return playerPermissionMapper.getPlayerPermissions(playerId);
        }
    }
    public List<Integer> getPermissionIdsByPlayerId(int playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerPermissionMapper playerPermissionMapper = sqlSession.getMapper(PlayerPermissionMapper.class);
            return playerPermissionMapper.getPermissionIdsByPlayerId(playerId);
        }
    }

}