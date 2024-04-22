package com.popopapi.common.services.database.mybatis.services;

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

    public List<String> getPlayerPermissions(String uuid) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            return playerMapper.getPlayerPermissions(uuid);
        }
    }
    //get player id by uuid
    public Integer getPlayerIdByUUID(String uuid) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            return playerMapper.getPlayerIdByUUID(uuid);
        }
    }
}