package ru.aston.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Contract;

import java.util.Base64;

public class User {
    private final String name;
    private final String email;
    private String password;
    private IAddress address;

    @Contract(pure = true)
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
        StringBuilder city = new StringBuilder(" from ");
        if (address != null) {
            city.append(address.getCity());
        }

        return getName() + city + " with an email: " + email + " has a password=" + password;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String name;
        private String email;
        private String password;
        private IAddress address;

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Builder addPassword() {
            this.password = Base64.getEncoder().encodeToString(name.getBytes());
            return this;
        }

        public Builder addEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder addAddress(IAddress address) {
            this.address = address.clone();
            return this;
        }

        public User build() {
            return new User(this);
        }

        public static Builder builder() {
            return new Builder();
        }
    }
}
