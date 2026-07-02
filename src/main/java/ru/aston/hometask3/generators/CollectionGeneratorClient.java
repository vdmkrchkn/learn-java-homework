package ru.aston.hometask3.generators;

import java.util.Collection;

public class CollectionGeneratorClient<T> {
    private final BaseCollectionGenerator<T> generator;

    public CollectionGeneratorClient(BaseCollectionGenerator<T> generator) {
        this.generator = generator;
    }

    public Collection<T> get() throws NullPointerException {
        if (generator != null) {
            return generator.generate();
        }

        throw new NullPointerException("Не задан генератор коллекции");
    }
}
