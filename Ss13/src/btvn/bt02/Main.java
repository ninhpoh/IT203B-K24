package btvn.bt02;

import btvn.bt03.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DataConnect.openConnection();
            conn.setAutoCommit(false); // Tắt Auto-Commit

            int patientId = 202;
            int invoiceId = 1;
            double amount = 500000;

            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();


            String sqlUpdateInvoice = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Thanh toán hoàn tất!");
        } catch (SQLException e) {
            System.out.println("Lỗi hệ thống: " + e.getMessage());
            // Rollback để khôi phục dữ liệu
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback giao dịch, dữ liệu an toàn.");
                } catch (SQLException se) {
                    System.out.println("Rollback thất bại: " + se.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Bật lại Auto-Commit
                    conn.close();
                } catch (SQLException se) {
                    System.out.println("Đóng kết nối thất bại: " + se.getMessage());
                }
            }
        }
    }
}