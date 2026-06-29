package ru.aston.hometask3;

import ru.aston.hometask.User;

import java.util.Collection;
import java.util.List;

public abstract class UserDecorator {
    protected User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    public String getRole() {
        return "User";
    }

    public Collection<String> getPermissions() {
        return List.of("Read");
    }
}
