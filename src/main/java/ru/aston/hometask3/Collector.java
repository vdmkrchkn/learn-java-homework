package ru.aston.hometask3;

import java.util.Collection;
import java.util.List;

public class Collector extends RandomCollector {
    private final String name;

    public Collector(Integer size, String name) {
        super(size);
        this.name = name;
    }

    @Override
    Collection<User> generate() {
        
        return List.of(new User.UserBuilder(name)
                .setUserPassword()
                .build());
    }
}
