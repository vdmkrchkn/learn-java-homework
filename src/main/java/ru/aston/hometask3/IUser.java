package ru.aston.hometask3;

import java.util.Collection;

public interface IUser {
    UserRole getRole();
    Collection<UserPermission> getPermissions();
}
