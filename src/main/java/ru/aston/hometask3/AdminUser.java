package ru.aston.hometask3;

import ru.aston.models.User;
import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

import java.util.Collection;
import java.util.HashSet;

public class AdminUser extends UserDecorator {
    public AdminUser(User user) {
        super(user);
    }

    @Override
    public UserRole getRole() {
        return UserRole.ADMIN;
    }

    @Override
    public Collection<UserPermission> getPermissions() {
        Collection<UserPermission> permissions = new HashSet<>(super.getPermissions());
        permissions.add(UserPermission.WRITE);
        return permissions;
    }
}