import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
    @Test
    void userAddressNotChanged(){
        String city = "city";
        User user = new User("name", new Address(city), "email@email.com");
        IAddress newAddress = user.getAddress();
        newAddress.setCity("Moscow");
        assertEquals(city, user.getAddress().getCity());
    }
}
