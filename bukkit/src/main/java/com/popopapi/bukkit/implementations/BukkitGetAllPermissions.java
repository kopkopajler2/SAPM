package com.popopapi.bukkit.implementations;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import java.util.ArrayList;
import java.util.List;
import com.popopapi.common.services.database.mybatis.services.PermissionService;
public class BukkitGetAllPermissions {
    public BukkitGetAllPermissions() {
        saveAllPermissions();
    }
    // get all permissions using bukkit api
    private List<String> getAllPermissions() {
        List<String> permissionsList = new ArrayList<>();
        for (Permission perm : Bukkit.getPluginManager().getPermissions()) {
            permissionsList.add(perm.getName());
        }
        return permissionsList;
    }
    //save all permissions to database
    public void saveAllPermissions() {
        PermissionService permissionService = new PermissionService();
        List<String> permissions = getAllPermissions();
        for (String permission : permissions) {
            if (permissionService.getPermissionCountByName(permission) == 0) {
                var newPermission = new com.popopapi.common.services.database.models.Permission();
                newPermission.setPermission(permission);
                permissionService.createPermission(newPermission);
            }
        }
    }

}
