package com.popopapi.common.services.database.mybatis.databaseservices;

import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.PlayerGroupMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PlayerGroupService implements PlayerGroupMapper{






    public boolean deletePlayerGroup(Integer id) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            boolean result = playerGroupMapper.deletePlayerGroup(id);
            sqlSession.commit();
            return result;
        }
    }

    public boolean deletePlayerGroupByName(String playerGroup) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            boolean result = playerGroupMapper.deletePlayerGroupByName(playerGroup);
            sqlSession.commit();
            return result;
        }
    }

    public Integer getPlayerGroupByName(String name) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getPlayerGroupByName(name);
        }
    }

    public List<Integer> getGroupIdsByPlayerId(Integer playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getGroupIdsByPlayerId(playerId);
        }
    }

    public boolean addPlayerToGroup(Integer playerId, Integer groupId) {
        boolean result = false;
        if(playerId == null || groupId == null) {
            return result;
        }
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
             result = playerGroupMapper.addPlayerToGroup(playerId, groupId);
            sqlSession.commit();
            return result;
        }
    }


    public boolean deletePlayerFromGroup(Integer playerId, Integer groupId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            boolean result = playerGroupMapper.deletePlayerFromGroup(playerId, groupId);
            sqlSession.commit();
            return result;
        }
    }

    public boolean deleteAllPlayersFromGroup(Integer groupId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            boolean result = playerGroupMapper.deleteAllPlayersFromGroup(groupId);
            sqlSession.commit();
            return result;
        }
    }

    public List<String>getAllPlayerNamesFromGroup(Integer groupId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getAllPlayerNamesFromGroup(groupId);
        }
    }

   public List<String > getGroupNamesByPlayerId(Integer playerId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getGroupNamesByPlayerId(playerId);
        }
    }

}