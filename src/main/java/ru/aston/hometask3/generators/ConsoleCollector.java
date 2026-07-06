package ru.aston.hometask3.generators;

import ru.aston.models.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class ConsoleCollector extends RandomCollector {
    public ConsoleCollector(int size) {
        super(size);
    }

    @Override
    Collection<User> generate() throws NullPointerException {
        Scanner in = new Scanner(System.in);
        Collection<User> collection = new HashSet<>();
        for(int i = 0; i < size; ++i) {
            System.out.print("Введите имя пользователя, пожалуйста: ");
            String name = in.nextLine();
            collection.add(User.Builder.builder()
                    .addName(name.trim())
                    .addPassword()
                    .build());
        }
        in.close();
        return collection;
    }
}
