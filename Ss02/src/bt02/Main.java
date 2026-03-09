package bt02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = password -> password.length() >= 8;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mật khẩu thứ nhất: ");
        String pw1 = scanner.nextLine();
        System.out.println("Kết quả: " + validator.isValid(pw1));
        scanner.close();
    }
}
