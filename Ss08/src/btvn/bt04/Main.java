package btvn.bt04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Đăng ký quạt");
            System.out.println("2. Đăng ký máy tạo ẩm");
            System.out.println("3. Thay đổi nhiệt độ");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sensor.attach(new Fan());
                    System.out.println("Quạt: Đã đăng ký nhận thông báo");
                    break;
                case 2:
                    sensor.attach(new Humidifier());
                    System.out.println("Máy tạo ẩm: Đã đăng ký");
                    break;
                case 3:
                    System.out.print("Nhập nhiệt độ mới: ");
                    int temp = scanner.nextInt();
                    sensor.setTemperature(temp);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 4);
    }
}