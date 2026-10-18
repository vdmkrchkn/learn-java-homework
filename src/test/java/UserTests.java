import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.models.Address;
import ru.aston.models.IAddress;
import ru.aston.models.User;
import ru.aston.hometask3.AdminUser;
import ru.aston.hometask3.validators.EmailValidationHandler;
import ru.aston.hometask3.ExternalUserAdapter;
import ru.aston.hometask3.IUser;
import ru.aston.hometask3.SecureUserProxy;
import ru.aston.hometask3.UserDecorator;
import ru.aston.hometask3.enums.UserPermission;
import ru.aston.hometask3.enums.UserRole;
import ru.aston.hometask3.validators.UserValidationHandler;
import ru.aston.hometask3.validators.UsernameValidationHandler;
import ru.aston.hometask3.validators.ValidationException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

public class UserTests {
    static User.Builder userBuilder;

    @BeforeAll
    static void setupUser() {
        userBuilder = User.Builder.builder();
    }

    @Test
    void when_createUserAddressAndModify_thenReturnUnChangedCity(){
        String city = "city";
        User user = userBuilder.addAddress(new Address(city)).build();
        IAddress newAddress = user.getAddress();
        newAddress.setCity("Moscow");
        assertEquals(city, user.getAddress().getCity());
    }

    @Test
    void when_grantUserToAdmin_thenReturnAdminRole() {
        User user = userBuilder.build();
        UserDecorator adminUser = new AdminUser(user);
        assertEquals(UserRole.ADMIN, adminUser.getRole());
    }

    @Test
    void when_grantUserToAdmin_thenReturnAdminPermissions() {
        User user = userBuilder.build();
        UserDecorator adminUser = new AdminUser(user);
        Collection<UserPermission> permissions = adminUser.getPermissions();
        List<UserPermission> adminPermissions = List.of(UserPermission.READ, UserPermission.WRITE);
        assertTrue(permissions.containsAll(adminPermissions));
    }

    @Test
    void when_externalUserProvidePermissions_thenReturnUserPermissions() {
        IUser user = new ExternalUserAdapter();
        Collection<UserPermission> permissions = user.getPermissions();
        List<UserPermission> adminPermissions = List.of(UserPermission.READ, UserPermission.WRITE);
        assertTrue(permissions.containsAll(adminPermissions));
    }

    @Test
    void when_adminUser_thenReturnPermissions() {
        User user = userBuilder.build();
        IUser userProxy = new SecureUserProxy(user, UserRole.ADMIN);
        Collection<UserPermission> permissions = userProxy.getPermissions();
        List<UserPermission> adminPermissions = List.of(UserPermission.READ, UserPermission.WRITE);
        assertTrue(permissions.containsAll(adminPermissions));
    }

    @Test
    void validate_nullUsername_throwsNullPointerExceptionAndDoesNotDelegate() {
        User user = userBuilder.build();
        UserValidationHandler userNameValidator = new UsernameValidationHandler();
        UserValidationHandler userEmailValidator = mock();

        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> userNameValidator.validate(user)
        );
        assertEquals("Имя пользователя не может быть null", exception.getMessage());
        verifyNoInteractions(userEmailValidator);
    }

    @Test
    void validate_nullEmail_throwsNullPointerException() {
        User user = userBuilder.build();
        UserValidationHandler userEmailValidator = new EmailValidationHandler();

        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> userEmailValidator.validate(user)
        );
        assertEquals("Email пользователя не может быть null", exception.getMessage());
    }

    @Test
    void when_userWithValidEmail_thenDoesNotThrowException() {
        User user = userBuilder.addName("someName").addEmail("anyEmail@email.com").build();
        UserValidationHandler userNameValidator = new UsernameValidationHandler();
        UserValidationHandler userEmailValidator = new EmailValidationHandler();
        userNameValidator.setNext(userEmailValidator);
        assertDoesNotThrow(() -> userNameValidator.validate(user));
    }

    @Test
    void when_userWithInValidEmail_thenThrowException() {
        User user = userBuilder.addName("someName").addEmail("anyEmail").build();
        UserValidationHandler userNameValidator = new UsernameValidationHandler();
        UserValidationHandler userEmailValidator = new EmailValidationHandler();
        userNameValidator.setNext(userEmailValidator);
        assertThrows(ValidationException.class, () -> userNameValidator.validate(user));
    }
}
