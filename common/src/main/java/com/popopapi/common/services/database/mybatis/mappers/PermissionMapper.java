package com.popopapi.common.services.database.mybatis.mappers;
import com.popopapi.common.services.database.models.Permission;
import java.util.List;


public interface PermissionMapper {
    boolean createPermission(Permission permission);
    Permission getPermissionById(Integer id);
    List<Permission> getAllPermissions();
    List<String> getAllPermissionNames();
    void updatePermission(Permission permission);
    boolean deletePermission(Integer id);
    boolean deletePermissionByName(String permission);
    Integer getPermissionByName(String name);
}
