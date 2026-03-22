package btvn.bt01;

import java.sql.*;

public class DBContext {
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/hospital_DB";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "123456$";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}


/*
Phan 1
* Việc khởi tạo kết nối liên tục mà không đóng (close) hoặc không có cơ chế quản lý tập trung gây ra nhiều rủi ro:
- Rò rỉ tài nguyên: Kết nối mở nhưng không đóng sẽ làm đầy connection pool.
- Hệ thống treo: Khi vượt quá giới hạn kết nối, DB từ chối thêm kết nối mới → lỗi Communications link failure.
- Ảnh hưởng 24/7: Hệ thống y tế cần hoạt động liên tục, gián đoạn sẽ ảnh hưởng trực tiếp đến khám chữa bệnh.
- Nguy cơ bảo mật: Kết nối mở lâu dễ bị khai thác nếu không có timeout hoặc kiểm soát truy cập.
* */