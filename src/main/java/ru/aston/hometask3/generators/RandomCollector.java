package ru.aston.hometask3.generators;

import ru.aston.models.User;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomCollector extends BaseCollectionGenerator<User> {
    protected final int size;

    public RandomCollector(int size) {
        this.size = size;
    }

    @Override
    Collection<User> generate() throws NullPointerException {
        return IntStream.range(0, size).mapToObj(i -> {
            String name = "name" + (i + 1);
            return User.Builder.builder()
                    .addName(name)
                    .addEmail(name + "@email.com")
                    .addPassword()
                    .build();
        }).collect(Collectors.toSet());
    }
}
