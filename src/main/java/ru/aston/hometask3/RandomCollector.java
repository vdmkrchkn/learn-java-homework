package ru.aston.hometask3;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomCollector extends BaseCollectionGenerator<User> {
    private final Integer size;

    public RandomCollector(Integer size) {
        this.size = size;
    }

    @Override
    Collection<User> generate() {
        return IntStream.range(0, size)
                .mapToObj(i -> {
                    String name = "name" + (i + 1);
                    return new User(name, name + "@email.com");
                })
                .collect(Collectors.toSet());
    }
}
