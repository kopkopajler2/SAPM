package com.popopapi.common.services.database.mybatis.services;
import com.popopapi.common.services.database.models.Permission;
import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.PermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class PermissionService {
    public boolean createPermission(Permission permission) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            if (permissionMapper.getPermissionByName(permission.getPermission()) > 0) {
                // The permission already exists, return false
                return false;
            }
            boolean result = permissionMapper.createPermission(permission);
            sqlSession.commit();
            return result;
        }
    }

    public boolean deletePermission(Integer id) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            boolean result = permissionMapper.deletePermission(id);
            sqlSession.commit();
            return result;
        }
    }

    public boolean deletePermissionByName(String permission) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            boolean result = permissionMapper.deletePermissionByName(permission);
            sqlSession.commit();
            return result;
        }
    }

    public int getPermissionCountByName(String name) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            return permissionMapper.getPermissionByName(name);
        }
    }

    public List<String> getAllPermissionNames() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            return permissionMapper.getAllPermissionNames();
        }
    }
}
