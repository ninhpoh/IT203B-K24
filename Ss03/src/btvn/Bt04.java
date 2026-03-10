package btvn;

import java.util.*;

public class Bt04 {
    public static void main(String[] args) {
        record User(String username, String email, String status) {}

        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE"),
                new User("alice", "alice@other.com", "INACTIVE")
        );

        Set<String> seen = new HashSet<>();
        List<User> uniqueUsers = new ArrayList<>();

        for (User u : users) {
            if (seen.add(u.username())) {
                uniqueUsers.add(u);
            }
        }

        uniqueUsers.forEach(System.out::println);
    }
}
