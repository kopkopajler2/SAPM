package com.popopapi.common.services.database.mybatis.services;
import com.popopapi.common.services.database.models.Group;
import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.GroupMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GroupService implements GroupMapper{
    public boolean createGroup(Group group) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            if (groupMapper.getGroupByName(group.getName()) > 0) {
                // The group name already exists, return false
                return false;
            }
            boolean result = groupMapper.createGroup(group);
            sqlSession.commit();
            return result;
        }
    }

    public boolean deleteGroup(Integer id) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            boolean result = groupMapper.deleteGroup(id);
            sqlSession.commit();
            return result;
        }
    }
    public boolean deleteGroupByName(String group) {
         SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            boolean result = groupMapper.deleteGroupByName(group);
            sqlSession.commit();
            return result;
        }

    }

    public int getGroupCountByName(String name) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            return groupMapper.getGroupByName(name);
        }
    }

    public List<String> getAllGroupNames() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            return groupMapper.getAllGroupNames();
        }
    }


    public Integer getGroupByName(String name) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            return groupMapper.getGroupByName(name);
        }
    }




    @Override
    public boolean updateGroup(Group group) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            boolean result = groupMapper.updateGroup(group);
            sqlSession.commit();
            return result;
        }
    }

   public Integer getGroupIdByName(String groupName) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
            return groupMapper.getGroupIdByName(groupName);
        }
    }


}
