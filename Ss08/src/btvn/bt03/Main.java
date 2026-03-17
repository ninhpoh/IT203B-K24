package btvn.bt03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("1. nhan nut");
            System.out.println("2. undo");
            System.out.println("3. thoat");
            System.out.print("Nhap lua chon: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    break;
                    case 2:
                        break;
            }
        }while(choice != 3);
    }
}
