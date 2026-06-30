package ru.aston.hometask3;

import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;

import java.util.Arrays;
import java.util.Collection;

public class ExternalUserAdapter implements IUser {
    private final IExternalUser externalUser;

    public ExternalUserAdapter(IExternalUser externalUser) {
        this.externalUser = externalUser;
    }

    @Override
    public UserRole getRole() {
        return externalUser.getUserRole();
    }

    @Override
    public Collection<UserPermission> getPermissions() {
        return Arrays.stream(externalUser.getPermissions().split(",")).map(s -> switch (s) {
            case "Read" -> UserPermission.READ;
            case "Write" -> UserPermission.WRITE;
            default -> null;
        }).toList();
    }
}
