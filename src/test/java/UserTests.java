import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
    @Test
    void when_immutableUserSetCity_returnUnchanged(){
        String city = "city";
        User user = new User("name", new Address(city));
        IAddress newAddress = user.getAddress();
        newAddress.setCity("Moscow");
        assertEquals(city, user.getAddress().getCity());
    }
}
