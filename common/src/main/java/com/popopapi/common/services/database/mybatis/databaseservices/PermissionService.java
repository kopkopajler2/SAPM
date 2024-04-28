package com.popopapi.common.services.database.mybatis.databaseservices;
import com.popopapi.common.services.database.models.Permission;
import com.popopapi.common.services.database.mybatis.DatabaseUtils;
import com.popopapi.common.services.database.mybatis.mappers.PermissionMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class PermissionService implements PermissionMapper{
    public boolean createPermission(Permission permission) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            Integer permissionByName = permissionMapper.getPermissionByName(permission.getPermission());
            if (permissionByName != null && permissionByName > 0) {
                // The permission already exists, return false
                return false;
            }
            boolean result = permissionMapper.createPermission(permission);
            sqlSession.commit();
            return result;
        }
    }

    @Override
    public Permission getPermissionById(Integer id) {
        return null;
    }

    @Override
    public List<Permission> getAllPermissions() {
        return List.of();
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

    @Override
    public Integer getPermissionByName(String name) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            return permissionMapper.getPermissionByName(name);
        }

    }

    public int getPermissionCountByName(String name) {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            Integer permissionCount = permissionMapper.getPermissionByName(name);
            return permissionCount != null ? permissionCount : 0;
        }
    }

    public List<String> getAllPermissionNames() {
        SqlSessionFactory sqlSessionFactory = DatabaseUtils.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            PermissionMapper permissionMapper = sqlSession.getMapper(PermissionMapper.class);
            return permissionMapper.getAllPermissionNames();
        }
    }

    @Override
    public void updatePermission(Permission permission) {

    }
}
