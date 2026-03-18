import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("----------------------Quan ly san pham----------------------");
            System.out.println("Menu:");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm ");
            System.out.println("5. Thoát");
            System.out.println("-------------------------------------------------------------");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Chọn loại: 1. Digital, 2. Physical");
                    int type = sc.nextInt();
                    sc.nextLine();

                    ProductFactory factory = new ProductFactory();

                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    if (type == 1) {
                        System.out.print("Nhập kích thước (MB): ");
                        double size = sc.nextDouble();
                        sc.nextLine();
                        factory.createDigital(id, name, price, size);
                    } else if (type == 2) {
                        System.out.print("Nhập trọng lượng (kg): ");
                        double weight = sc.nextDouble();
                        sc.nextLine();
                        factory.createPhysical(id, name, price, weight);
                    } else {
                        System.out.println("Loại không hợp lệ!");
                    }
                    break;
                case 2:
                    System.out.println("Danh sách sản phẩm:");

                    break;
                case 3:
                    System.out.println("Cập nhật sản phẩm");

                    break;
                case 4:
                    System.out.println("Xóa sản phẩm");
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }while(choice!=5);
    }
}
