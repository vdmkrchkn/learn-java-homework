package ru.aston.hometask3;

import ru.aston.hometask.User;

import java.util.Collection;
import java.util.HashSet;

public class AdminUser extends UserDecorator {
    public AdminUser(User user) {
        super(user);
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public Collection<String> getPermissions() {
        Collection<String> permissions = new HashSet<>(super.getPermissions());
        permissions.add("Write");
        return permissions;
    }
}