package com.popopapi.services.database.mybatis.services;

import com.popopapi.services.database.models.Player;
import com.popopapi.services.database.mybatis.DatabaseUtils;
import com.popopapi.services.database.mybatis.mappers.PlayerMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PlayerService {
    public void createPlayer(Player player) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PlayerMapper playerMapper = sqlSession.getMapper(PlayerMapper.class);
            playerMapper.createPlayer(player);
            sqlSession.commit();
        }
    }
}