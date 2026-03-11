package btvn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserValidator {
    private final UserValidator validator = new UserValidator();

    @Test
    void TC01_validUsername() {
        String input = "user123";

        boolean result = validator.isValidUsername(input);

        assertTrue(result, "Username hợp lệ phải trả về true");
    }

    @Test
    void TC02_tooShortUsername() {
        String input = "abc";

        boolean result = validator.isValidUsername(input);

        assertFalse(result, "Username quá ngắn phải trả về false");
    }

    @Test
    void TC03_containsWhitespace() {
        String input = "user name";

        boolean result = validator.isValidUsername(input);

        assertFalse(result, "Username chứa khoảng trắng phải trả về false");
    }

}
