package com.popopapi.common.services.permissions;


import java.util.List;

public interface PermissionRetrieval {
    List<String> getPlayerPermissions(String uuid);
}
