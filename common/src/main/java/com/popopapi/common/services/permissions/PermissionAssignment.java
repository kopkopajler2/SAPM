package com.popopapi.common.services.permissions;


import java.util.List;

public interface PermissionAssignment {
    List<String> getPlayerPermissions(String uuid);
}
