package ru.aston.hometask3;

import java.util.Arrays;
import java.util.Collection;

public class ExternalUserAdapter implements IUser {
    private final IExternalUser externalUser;

    public ExternalUserAdapter(IExternalUser externalUser) {
        this.externalUser = externalUser;
    }

    @Override
    public String getRole() {
        return externalUser.getUserRole();
    }

    @Override
    public Collection<String> getPermissions() {
        return Arrays.stream(externalUser.getPermissions().split(",")).toList();
    }
}
