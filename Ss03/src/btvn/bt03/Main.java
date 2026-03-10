package btvn.bt03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập username: ");
        String input = scanner.nextLine();

        repo.findUserByUsername(input)
                .ifPresentOrElse(
                        u -> System.out.println("Welcome " + u.username()),
                        () -> System.out.println("Guest login")
                );

        scanner.close();
    }

}
