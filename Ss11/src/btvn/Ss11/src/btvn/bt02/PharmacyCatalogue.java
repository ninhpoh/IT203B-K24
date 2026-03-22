package btvn.bt02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PharmacyCatalogue {
    public void printMedicines(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy")) {

            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");
                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 *Phan 1
 * - rs.next() di chuyển con trỏ của ResultSet sang hàng tiếp theo trong bảng.
 * - Khi bạn dùng if (rs.next()), chương trình chỉ kiểm tra một lần duy nhất:
 * - Nếu có dữ liệu, nó in ra chỉ hàng đầu tiên.
 * - Sau đó kết thúc, vì không có vòng lặp để tiếp tục duyệt các hàng khác.
 * - Nếu bảng trống, rs.next() trả về false, nên không in gì cả.
 * - Muốn in toàn bộ danh sách, ta cần lặp lại việc gọi rs.next() cho đến khi hết dữ liệu
 */
