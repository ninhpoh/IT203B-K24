import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        int choise = -1;
        do {
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========\n" +
                    "1. Thêm sản phẩm mới\n" +
                    "2. Hiển thị danh sách sản phẩm\n" +
                    "3. Cập nhật số lượng theo ID\n" +
                    "4. Xóa sản phẩm đã hết hàng\n" +
                    "5. Thoát chương trình\n" +
                    "=============================================\n");
            System.out.print("Nhập lựa chọn của bạn: ");
            choise = sc.nextInt();
            sc.nextLine();
            switch (choise) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Giá: ");
                    double price = sc.nextDouble();

                    System.out.print("Số lượng: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Danh mục: ");
                    String category = sc.nextLine();

                    manager.addProduct(new Product(id, name, price, qty, category));
                    break;
                case 2:
                    manager.displayProducts();
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    int updateId = sc.nextInt();

                    System.out.print("Số lượng mới: ");
                    int newQty = sc.nextInt();

                    manager.updateQuantity(updateId, newQty);
                    break;
                case 4:
                    manager.deleteOutOfStock();
                    System.out.println("Đã xóa sản phẩm hết hàng");
                    break;
                case 5:
                    System.out.println("Thoát chương trình. Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }while (choise != 5);
    }
}
