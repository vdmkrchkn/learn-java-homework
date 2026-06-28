package ru.aston.hometask3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class User {
    private final String name;
    private final String email;
    private final String password;

    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
        this.password = name + ":" + email;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + "with an email: " + getEmail() + "has a password=" + getPassword();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
