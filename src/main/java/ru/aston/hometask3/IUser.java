package ru.aston.hometask3;

import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

import java.util.Collection;

public interface IUser {
    UserRole getRole();
    Collection<UserPermission> getPermissions();
}
