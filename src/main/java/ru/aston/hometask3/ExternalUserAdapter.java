package ru.aston.hometask3;

import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

import java.util.Arrays;
import java.util.Collection;

public class ExternalUserAdapter implements IUser {
    @Override
    public UserRole getRole() {
        return ExternalUser.getUserRole();
    }

    @Override
    public Collection<UserPermission> getPermissions() {
        return Arrays.stream(ExternalUser.getPermissions().split(",")).map(UserPermission::valueOf).toList();
    }

    static class ExternalUser {
        public static UserRole getUserRole() {
            return UserRole.USER;
        }

        public static String getPermissions() {
            return UserPermission.READ + "," + UserPermission.WRITE;
        }
    }
}
