package btvn;

import java.util.Scanner;

public class Bt02 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập tổng số người dùng: ");
            int totalUsers = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập số lượng nhóm muốn chia: ");
            int groups = Integer.parseInt(scanner.nextLine());

            int usersPerGroup = totalUsers / groups;
            System.out.println("Mỗi nhóm có: " + usersPerGroup + " người.");
        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0!");
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Vui lòng nhập dữ liệu bằng số!");
        } finally {
            scanner.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }

        System.out.println("Chương trình tiếp tục thực thi sau khối try-catch-finally...");
    }

}