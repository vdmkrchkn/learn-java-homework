package ru.aston.hometask3;

import ru.aston.models.User;
import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

import java.util.Collection;

public class SecureUserProxy implements IUser {
    private final UserDecorator user;
    private final UserRole userRole;

    public SecureUserProxy(User user, UserRole userRole) {
        this.user = new AdminUser(user);
        this.userRole = userRole;
    }

    @Override
    public UserRole getRole() {
        return userRole;
    }

    @Override
    public Collection<UserPermission> getPermissions() {
        if (!userRole.equals(UserRole.ADMIN)) {
            throw new SecurityException("Access denied: only admin can view permissions");
        }
        return user.getPermissions();
    }
}
