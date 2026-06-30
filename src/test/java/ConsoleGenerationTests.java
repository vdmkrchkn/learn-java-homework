import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.List;

import ru.aston.hometask.User;
import ru.aston.hometask3.generators.BaseCollectionGenerator;
import ru.aston.hometask3.generators.CollectionGeneratorClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ConsoleGenerationTests {
    @Test
    void when_CollectorName_thenReturnCollectionWithName() {
        String name = "Иванов Иван Иванович";
        BaseCollectionGenerator<User> placeholder = Mockito.mock(BaseCollectionGenerator.class);
        CollectionGeneratorClient<User> collectionGeneratorClient = new CollectionGeneratorClient<>(placeholder);
        Mockito.when(collectionGeneratorClient.get()).thenReturn(List.of(new User.Builder(name).build()));
        Collection<User> collection = collectionGeneratorClient.get();
        String actualName = collection.stream()
                .map(User::getName)
                .findFirst()
                .orElse(null);
        assertEquals(name, actualName);
    }
}
