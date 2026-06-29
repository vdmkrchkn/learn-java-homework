import org.junit.jupiter.api.Test;
import ru.aston.hometask.Address;
import ru.aston.hometask.IAddress;
import ru.aston.hometask.User;
import ru.aston.hometask3.AdminUser;
import ru.aston.hometask3.ExternalUser;
import ru.aston.hometask3.ExternalUserAdapter;
import ru.aston.hometask3.IExternalUser;
import ru.aston.hometask3.IUser;
import ru.aston.hometask3.UserDecorator;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTests {
    @Test
    void when_createUserAddressAndModify_thenReturnUnChangedCity(){
        String city = "city";
        User user = new User.Builder("name").setAddress(new Address(city)).build();
        IAddress newAddress = user.getAddress();
        newAddress.setCity("Moscow");
        assertEquals(city, user.getAddress().getCity());
    }

    @Test
    void when_grantUserToAdmin_thenReturnAdminRole() {
        User user = new User.Builder("name").build();
        UserDecorator adminUser = new AdminUser(user);
        assertEquals("Admin", adminUser.getRole());
    }

    @Test
    void when_grantUserToAdmin_thenReturnAdminPermissions() {
        User user = new User.Builder("name").build();
        UserDecorator adminUser = new AdminUser(user);
        Collection<String> permissions = adminUser.getPermissions();
        assertTrue(permissions.containsAll(List.of("Read", "Write")));
    }

    @Test
    void when_externalUserProvidePermissions_thenReturnUserPermissions() {
        IExternalUser externalUser = new ExternalUser();
        IUser user = new ExternalUserAdapter(externalUser);
        Collection<String> permissions = user.getPermissions();
        assertTrue(permissions.containsAll(List.of("Read", "Download", "Upload")));
    }
}
