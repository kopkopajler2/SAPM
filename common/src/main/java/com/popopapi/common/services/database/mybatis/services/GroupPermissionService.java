package com.popopapi.common.services.database.mybatis.services;

import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.GroupPermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GroupPermissionService implements GroupPermissionMapper {
    public boolean addPermissionToGroup(int groupId, int permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupPermissionMapper groupPermissionMapper = sqlSession.getMapper(GroupPermissionMapper.class);
            boolean result = groupPermissionMapper.addPermissionToGroup(groupId, permissionId);
            sqlSession.commit();
            return result;
        }
    }

    public boolean removePermissionFromGroup(int groupId, int permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupPermissionMapper groupPermissionMapper = sqlSession.getMapper(GroupPermissionMapper.class);
            boolean result = groupPermissionMapper.removePermissionFromGroup(groupId, permissionId);
            sqlSession.commit();
            return result;
        }
    }

    public List<Integer> getGroupPermissions(int groupId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupPermissionMapper groupPermissionMapper = sqlSession.getMapper(GroupPermissionMapper.class);
            return groupPermissionMapper.getGroupPermissions(groupId);
        }
    }

    public List<Integer> getPermissionIdsByGroupIds(List<Integer> groupIds) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupPermissionMapper groupPermissionMapper = sqlSession.getMapper(GroupPermissionMapper.class);
            return groupPermissionMapper.getPermissionIdsByGroupIds(groupIds);
        }
    }

    public boolean isPermissionAssignedToGroup(Integer groupId, Integer permissionId) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            GroupPermissionMapper groupPermissionMapper = sqlSession.getMapper(GroupPermissionMapper.class);
            return groupPermissionMapper.isPermissionAssignedToGroup(groupId, permissionId);
        }
    }
}