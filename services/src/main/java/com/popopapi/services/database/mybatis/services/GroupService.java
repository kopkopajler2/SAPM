package com.popopapi.services.database.mybatis.services;
import com.popopapi.services.database.models.Group;
import com.popopapi.services.database.mybatis.DatabaseUtils;
import com.popopapi.services.database.mybatis.mappers.GroupMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class GroupService {
    public void createGroup(Group group) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            groupMapper.createGroup(group);
            sqlSession.commit();
        }
    }
}
