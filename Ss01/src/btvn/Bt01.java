package btvn;
import java.util.Scanner;

public class Bt01 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Nhập năm sinh của bạn: ");
                String input = scanner.nextLine();
                int yearOfBirth = Integer.parseInt(input);
                int age = 2026 - yearOfBirth;
                System.out.println("Tuổi của bạn là: " + age);
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập năm sinh bằng số!");
            } finally {
                scanner.close();
                System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
            }
        }
    }