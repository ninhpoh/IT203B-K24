package btvn.bt02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OldThermometer oldThermometer = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(oldThermometer);
        SmartHomeFacade facade = new SmartHomeFacade(sensor);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    facade.getCurrentTemperature();
                    break;
                case 2:
                    facade.leaveHome();
                    break;
                case 3:
                    facade.sleepMode();
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