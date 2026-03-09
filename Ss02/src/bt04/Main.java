package bt04;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice"),
                new User("Bob"),
                new User("Charlie")
        );
        //1
        List<String> names = users.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
        System.out.println(names);

        //2
        names.forEach(System.out::println);

        //3
        Supplier<User> supplier = User::new;
        User newUser = supplier.get();
        System.out.println("New user: " + newUser.getUsername());
    }
}