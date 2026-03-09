package bt03;

public class Main {
    public static void main(String[] args) {
        Authenticatable user = () -> "mypassword";

        System.out.println("Authenticated: " + user.isAuthenticated());

        String encrypted = Authenticatable.encrypt(user.getPassword());
        System.out.println("Encrypted password: " + encrypted);
    }
}
