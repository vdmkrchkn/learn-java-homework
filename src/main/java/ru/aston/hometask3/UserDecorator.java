package ru.aston.hometask3;

import ru.aston.hometask.User;

import java.util.Collection;
import java.util.List;

public abstract class UserDecorator implements IUser {
    protected User user;

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
