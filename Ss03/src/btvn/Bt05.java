package btvn;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bt05 {
    public static void main(String[] args) {
        record User(String username, String email, String status) {}

        List<User> users = List.of(
                new User("alexander", "alexander@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlotte", "charlotte@gmail.com", "ACTIVE"),
                new User("Benjamin", "benjamin@gmail.com", "ACTIVE"),
                new User("Ann", "ann@gmail.com", "ACTIVE")
        );

        List<User> top3 = users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .collect(Collectors.toList());
        
        top3.forEach(u -> System.out.println(u.username()));
    }

}
