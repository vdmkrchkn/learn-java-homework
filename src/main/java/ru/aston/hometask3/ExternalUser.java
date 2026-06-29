package ru.aston.hometask3;

public class ExternalUser implements IExternalUser {

    @Override
    public UserRole getUserRole() {
        return UserRole.USER;
    }

    @Override
    public String getPermissions() {
        return "Read,Write,Upload";
    }
}
