package btvn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestUserService {
    private final UserService service = new UserService();

    @Test
    void testAge18_validBoundary() {
        int inputAge = 18;

        boolean result = service.checkRegistrationAge(inputAge);

        assertEquals(true, result, "Tuổi 18 phải hợp lệ");
    }

    @Test
    void testAge17_invalidTooYoung() {
        int inputAge = 17;

        boolean result = service.checkRegistrationAge(inputAge);

        assertEquals(false, result, "Tuổi 17 phải không hợp lệ");
    }

    @Test
    void testAgeNegative_throwException() {
        int inputAge = -1;

        assertThrows(IllegalArgumentException.class,
                () -> service.checkRegistrationAge(inputAge),
                "Tuổi âm phải ném ra IllegalArgumentException");
    }

}
