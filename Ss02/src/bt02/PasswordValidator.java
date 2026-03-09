package bt02;

@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}
