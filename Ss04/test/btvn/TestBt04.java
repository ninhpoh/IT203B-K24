package btvn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestBt04 {

    private final Bt04 service = new Bt04();

    @Test
    void testStrongPassword() {
        String result = service.evaluatePasswordStrength("Abc123!@");
        assertEquals("Mạnh", result);
    }

    @Test
    void testMissingUppercase() {
        String result = service.evaluatePasswordStrength("abc123!@");
        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingLowercase() {
        String result = service.evaluatePasswordStrength("ABC123!@");
        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingDigit() {
        String result = service.evaluatePasswordStrength("Abcdef!@");
        assertEquals("Trung bình", result);
    }

    @Test
    void testMissingSpecialCharacter() {
        String result = service.evaluatePasswordStrength("Abc12345");
        assertEquals("Trung bình", result);
    }

    @Test
    void testTooShortPassword() {
        String result = service.evaluatePasswordStrength("Ab1!");
        assertEquals("Yếu", result);
    }

    @Test
    void testOnlyLowercase() {
        String result = service.evaluatePasswordStrength("password");
        assertEquals("Yếu", result);
    }

    @Test
    void testUppercaseAndDigitsOnly() {
        String result = service.evaluatePasswordStrength("ABC12345");
        assertEquals("Yếu", result);
    }

    @Test
    void testMultipleConditionsWithAssertAll() {
        assertAll(
                () -> assertEquals("Mạnh", service.evaluatePasswordStrength("Abc123!@")),
                () -> assertEquals("Trung bình", service.evaluatePasswordStrength("abc123!@")),
                () -> assertEquals("Yếu", service.evaluatePasswordStrength("Ab1!"))
        );
    }
}