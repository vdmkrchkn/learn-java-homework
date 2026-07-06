package ru.aston.hometask;

import ru.aston.hometask3.generators.BaseCollectionGenerator;
import ru.aston.hometask3.generators.CollectionGeneratorClient;
import ru.aston.hometask3.generators.ConsoleCollector;
import ru.aston.models.User;

import java.util.Collection;

public class GreetingApp {

	public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int size = Integer.parseInt(args[0]);
                BaseCollectionGenerator<User> generator = new ConsoleCollector(size);
                CollectionGeneratorClient<User> collectionGeneratorClient = new CollectionGeneratorClient<>(generator);
                Collection<User> collection = collectionGeneratorClient.get();
                collection.stream().peek(System.out::println).toList();
            } catch (NumberFormatException nfe) {
                System.out.println("Неверный формат размера коллекции");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Пожалуйста, задайте размер коллекции");
        }
	}

}
