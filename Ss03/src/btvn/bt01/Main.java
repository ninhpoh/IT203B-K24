package btvn.bt01;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice = new User("alice", "alice@example.com", "ACTIVE");
        User bob = new User("bob", "bob@example.com", "INACTIVE");
        User charlie = new User("charlie", "charlie@example.com", "ACTIVE");

        List<User> users = List.of(alice, bob, charlie);

        users.forEach(System.out::println);
    }

}
