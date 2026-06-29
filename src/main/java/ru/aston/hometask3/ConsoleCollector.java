package ru.aston.hometask3;

import ru.aston.hometask.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class ConsoleCollector extends RandomCollector {
    public ConsoleCollector(Integer size) {
        super(size);
    }

    @Override
    Collection<User> generate() {
        Scanner in = new Scanner(System.in);
        Collection<User> collection = new HashSet<>();
        for(int i = 0; i < size; ++i) {
            System.out.print("Введите имя пользователя, пожалуйста: ");
            String name = in.nextLine();
            collection.add(new User.Builder(name.trim())
                    .setPassword()
                    .build());
        }
        in.close();
        return collection;
    }
}
