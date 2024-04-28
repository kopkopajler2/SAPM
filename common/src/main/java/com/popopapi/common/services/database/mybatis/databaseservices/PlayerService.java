package com.popopapi.common.services.database.mybatis.databaseservices;

import com.popopapi.common.services.database.mybatis.mappers.PlayerMapper;
import com.popopapi.common.services.database.models.Player;
import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PlayerService {
    public boolean createPlayer(Player player) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            // Check if the player already exists in the database
            if (playerMapper.getPlayerByName(player.getUsername()) != null) {
                // The player already exists, return false
                return false;
            }
            boolean result = playerMapper.createPlayer(player);
            sqlSession.commit();
            return result;
        }
    }

    //get all player names
    public List<String> getAllPlayerNames() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            return playerMapper.getAllPlayerNames();
        }
    }

    public Integer getPlayerIdByName(String playerName) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            return playerMapper.getPlayerIdByName(playerName);
        }
    }

    public List<String> getAllPlayerUUIDs() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            return playerMapper.getAllPlayerUUIDs();
        }
    }
}