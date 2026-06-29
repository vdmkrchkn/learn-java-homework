package ru.aston.hometask3;

import ru.aston.hometask3.enums.UserRole;

public interface IExternalUser {
    UserRole getUserRole();
    String getPermissions();
}
