package bt03;

@FunctionalInterface
public interface Authenticatable {
    String getPassword();
    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    static String encrypt(String rawPassword) {
        return new StringBuilder(rawPassword).reverse().toString();
    }
}
