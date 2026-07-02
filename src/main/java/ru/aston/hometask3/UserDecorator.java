package ru.aston.hometask3;

import ru.aston.models.User;
import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

import java.util.Collection;
import java.util.List;

public abstract class UserDecorator implements IUser {
    protected final User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    public UserRole getRole() {
        return UserRole.USER;
    }

    public Collection<UserPermission> getPermissions() {
        return List.of(UserPermission.READ);
    }
}
