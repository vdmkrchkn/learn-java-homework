package ru.aston.hometask3;

import java.util.Collection;

public interface IUser {
    String getRole();
    Collection<String> getPermissions();
}
