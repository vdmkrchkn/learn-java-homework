package ru.aston.hometask3;

import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

public class ExternalUser implements IExternalUser {

    @Override
    public UserRole getUserRole() {
        return UserRole.USER;
    }

    @Override
    public String getPermissions() {
        return UserPermission.READ + "," + UserPermission.WRITE;
    }
}
