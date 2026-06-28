package ru.aston.hometask3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Base64;

public class User {
    private final String name;
    private final String email;
    private String password;

    @org.jetbrains.annotations.Contract(pure = true)
    @JsonCreator
    protected User(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
    }

    private User(UserBuilder builder) {
        name = builder.name;
        email = builder.email;
        password = builder.password;
    }

    public String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return getName() + " with an email: " + getEmail() + " has a password=" + getPassword();
    }

    static class UserBuilder {
        private final String name;
        private String email;
        private String password;

        UserBuilder(String name) {
            this.name = name;
        }

        UserBuilder setUserPassword() {
            this.password = Base64.getEncoder().encodeToString(name.getBytes());
            return this;
        }

        UserBuilder setUserEmail(String email) {
            this.email = email;
            return this;
        }

        User build() {
            return new User(this);
        }
    }
}
