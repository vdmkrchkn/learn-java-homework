package ru.aston.hometask3;

import java.util.Collection;

public class CollectionGeneratorClient<T> {
    private final BaseCollectionGenerator<T> generator;

    public CollectionGeneratorClient(BaseCollectionGenerator<T> placeholder) {
        this.generator = placeholder;
    }

    public Collection<T> get() {
        return generator.generate();
    }
}
