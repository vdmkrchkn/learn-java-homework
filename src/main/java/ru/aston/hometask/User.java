package ru.aston.hometask;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Base64;

public class User {
    private final String name;
    private final String email;
    private String password;
    private IAddress address;

    @org.jetbrains.annotations.Contract(pure = true)
    @JsonCreator
    protected User(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
    }

    private User(Builder builder) {
        name = builder.name;
        email = builder.email;
        password = builder.password;
        address = builder.address;
    }

    public String getName() {
        return name;
    }

    public IAddress getAddress() {
        return address.clone();
    }

    @Override
    public String toString() {
        return getName() + " from " + address.getCity() + " with an email: " + email + " has a password=" + password;
    }

    public static class Builder {
        private final String name;
        private String email;
        private String password;
        private IAddress address;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setPassword() {
            this.password = Base64.getEncoder().encodeToString(name.getBytes());
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(IAddress address) {
            this.address = address.clone();
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
