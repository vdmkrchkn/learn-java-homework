package ru.aston.hometask3;

public class ExternalUser implements IExternalUser {

    @Override
    public String getUserRole() {
        return "User";
    }

    @Override
    public String getPermissions() {
        return "Read,Download,Upload";
    }
}
