package ru.aston.hometask3.generators;

import java.util.Collection;

public abstract class BaseCollectionGenerator<T> {
    abstract Collection<T> generate() throws NullPointerException;
}
