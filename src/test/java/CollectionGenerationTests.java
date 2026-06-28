import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import ru.aston.hometask3.BaseCollectionGenerator;
import ru.aston.hometask3.Collector;
import ru.aston.hometask3.FileCollector;
import ru.aston.hometask3.CollectionGeneratorClient;
import ru.aston.hometask3.RandomCollector;
import ru.aston.hometask3.User;

import java.util.Collection;

public class CollectionGenerationTests {
    @Test
    void when_validFileCollector_thenReturnNonEmptyCollection() {
        String fileName = "src/main/resources/users.json";
        BaseCollectionGenerator<User> placeholder = new FileCollector<>(fileName);
        CollectionGeneratorClient<User> collectionGeneratorClient = new CollectionGeneratorClient<>(placeholder);
        Collection<User> collection = collectionGeneratorClient.get();
        assertFalse(collection.isEmpty());
    }

    @Test
    void when_noFileCollector_thenReturnEmptyCollection() {
        String fileName = "";
        BaseCollectionGenerator<User> placeholder = new FileCollector<>(fileName);
        CollectionGeneratorClient<User> collectionGeneratorClient = new CollectionGeneratorClient<>(placeholder);
        Collection<User> collection = collectionGeneratorClient.get();
        assertNull(collection);
    }

    @Test
    void when_RandomCollector_thenReturnNonEmptyCollection() {
        Integer size = 100500;
        BaseCollectionGenerator<User> placeholder = new RandomCollector(size);
        CollectionGeneratorClient<User> collectionGeneratorClient = new CollectionGeneratorClient<>(placeholder);
        Collection<User> collection = collectionGeneratorClient.get();
        assertEquals(size, collection.size());
    }

    @Test
    void when_CollectorName_thenReturnCollectionWithName() {
        String name = "Иванов Иван Иванович";
        BaseCollectionGenerator<User> placeholder = new Collector(1, name);
        CollectionGeneratorClient<User> collectionGeneratorClient = new CollectionGeneratorClient<>(placeholder);
        Collection<User> collection = collectionGeneratorClient.get();
        String actualName = collection.stream()
                .map(User::getName)
                .findFirst()
                .orElse("");
        assertEquals(name, actualName);
    }
}
