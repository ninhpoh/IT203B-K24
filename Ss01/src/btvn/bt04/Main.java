package btvn.bt04;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        try {
            userService.processUserData();
            System.out.println("Dữ liệu đã được xử lý thành công.");
        } catch (IOException e) {
            System.out.println("Ngoại lệ được bắt tại main: " + e.getMessage());
        }
    }
}
