package com.popopapi.common.services.database.mybatis.services;

import com.popopapi.common.services.database.models.PlayerGroup;
import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.PlayerGroupMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PlayerGroupService implements PlayerGroupMapper{
    public boolean createPlayerGroup(PlayerGroup playerGroup) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            boolean result = playerGroupMapper.createPlayerGroup(playerGroup);
            sqlSession.commit();
            return result;
        }
    }

    public PlayerGroup getPlayerGroupById(Integer id) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getPlayerGroupById(id);
        }
    }

    public List<PlayerGroup> getAllPlayerGroups() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getAllPlayerGroups();
        }
    }

    public List<String> getAllPlayerGroupNames() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            return playerGroupMapper.getAllPlayerGroupNames();
        }
    }

    public void updatePlayerGroup(PlayerGroup playerGroup) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerGroupMapper playerGroupMapper = sqlSession.getMapper(PlayerGroupMapper.class);
            playerGroupMapper.updatePlayerGroup(playerGroup);
            sqlSession.commit();
        }
    }

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

    public int getPlayerGroupByName(String name) {
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
}