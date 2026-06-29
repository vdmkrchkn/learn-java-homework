import org.junit.jupiter.api.Test;
import ru.aston.hometask.Address;
import ru.aston.hometask.IAddress;
import ru.aston.hometask.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {
    @Test
    void userAddressNotChanged(){
        String city = "city";
        User user = new User.Builder("name").setAddress(new Address(city)).build();
        IAddress newAddress = user.getAddress();
        newAddress.setCity("Moscow");
        assertEquals(city, user.getAddress().getCity());
    }
}
