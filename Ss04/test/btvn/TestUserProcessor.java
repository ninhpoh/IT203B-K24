package btvn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestUserProcessor {
    private UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void testValidEmailFormat() {
        String input = "user@gmail.com";

        String result = processor.processEmail(input);

        assertEquals("user@gmail.com", result, "Email hợp lệ phải giữ nguyên và lowercase");
    }

    @Test
    void testMissingAtSymbol() {
        String input = "usergmail.com";

        assertThrows(IllegalArgumentException.class,
                () -> processor.processEmail(input),
                "Email thiếu ký tự @ phải ném ngoại lệ");
    }

    @Test
    void testMissingDomain() {
        String input = "user@";

        assertThrows(IllegalArgumentException.class,
                () -> processor.processEmail(input),
                "Email có @ nhưng thiếu tên miền phải ném ngoại lệ");
    }

    @Test
    void testEmailNormalizationToLowercase() {
        String input = "Example@Gmail.com";

        String result = processor.processEmail(input);

        assertEquals("example@gmail.com", result, "Email phải được chuyển về lowercase");
    }

}
