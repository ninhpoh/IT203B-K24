package btvn.bt03;

import java.sql.Connection;
import java.sql.Statement;

public class BedManagement {
    public void updateBedStatus(Connection conn, int inputId) {
        try (Statement stmt = conn.createStatement()) {
            String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = " + inputId;
            int rowsAffected = stmt.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật giường bệnh thành công!");
            } else {
                System.out.println("Giường bệnh với ID " + inputId + " không tồn tại.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
phan 1
* - Lệnh executeUpdate(sql) trả về một số nguyên: chính là số hàng bị ảnh hưởng bởi câu lệnh SQL.
- Nếu bed_id tồn tại, giá trị trả về thường là 1 .
- Nếu bed_id không tồn tại, giá trị trả về là 0 .
- Vì vậy, ta có thể dựa vào giá trị này để kiểm tra xem giường bệnh có tồn tại hay không. Nếu kết quả là 0, nghĩa là không có giường nào khớp với inputId.
*/