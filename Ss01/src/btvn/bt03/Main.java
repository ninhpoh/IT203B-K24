package btvn.bt03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.print("Nhập tuổi của bạn: ");
        int inputAge = scanner.nextInt();

        try {
            user.setAge(inputAge);
            System.out.println("Tuổi của user: " + user.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

}
