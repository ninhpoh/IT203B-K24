package btvn.bt03;

import java.sql.*;

public class Main {
    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rikkei_hospital", "root", "password");
            conn.setAutoCommit(false);

            String sqlCheckBalance = "SELECT so_du FROM benh_nhan WHERE ma_benh_nhan = ?";
            ps = conn.prepareStatement(sqlCheckBalance);
            ps.setInt(1, maBenhNhan);
            rs = ps.executeQuery();

            if (!rs.next()) {
                throw new Exception("Bệnh nhân không tồn tại!");
            }

            double soDu = rs.getDouble("so_du");

            if (soDu < tienVienPhi) {
                throw new Exception("Số dư không đủ để thanh toán!");
            }

            // 4. Trừ tiền viện phí
            String sqlUpdateBalance = "UPDATE benh_nhan SET so_du = so_du - ? WHERE ma_benh_nhan = ?";
            ps = conn.prepareStatement(sqlUpdateBalance);
            ps.setDouble(1, tienVienPhi);
            ps.setInt(2, maBenhNhan);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Không thể cập nhật số dư!"); // Bẫy 2
            }

            // 5. Giải phóng giường
            String sqlUpdateBed = "UPDATE giuong SET trang_thai = 'Trống' WHERE ma_giuong IN " +
                    "(SELECT ma_giuong FROM benh_nhan WHERE ma_benh_nhan = ?)";
            ps = conn.prepareStatement(sqlUpdateBed);
            ps.setInt(1, maBenhNhan);
            affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Không thể giải phóng giường!"); // Bẫy 2
            }

            // 6. Cập nhật trạng thái bệnh nhân
            String sqlUpdatePatient = "UPDATE benh_nhan SET trang_thai = 'Đã xuất viện' WHERE ma_benh_nhan = ?";
            ps = conn.prepareStatement(sqlUpdatePatient);
            ps.setInt(1, maBenhNhan);
            affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new Exception("Không thể cập nhật trạng thái bệnh nhân!"); // Bẫy 2
            }
            
            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công cho bệnh nhân " + maBenhNhan);

        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            // 8. Đóng kết nối
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }
}