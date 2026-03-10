package btvn.bt02;

import java.util.List;

public class Main {
    static void main() {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );

        users.stream()
                .filter(u -> u.email().endsWith("gmail.com"))
                .forEach(u -> System.out.println(u.username()));
    }
}
