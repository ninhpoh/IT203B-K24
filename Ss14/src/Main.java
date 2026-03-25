import util.DataConnect;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String fromId = "ACC01";
        String toId = "ACC02";
        double amount = 500;

        try (Connection conn = DataConnect.openConnection()) {

            conn.setAutoCommit(false);

            if (!checkBalanceEnough(conn, fromId, amount)) {
                throw new RuntimeException("Không đủ số dư hoặc tài khoản không tồn tại");
            }

            CallableStatement cs1 = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}");
            cs1.setString(1, fromId);
            cs1.setDouble(2, -amount);
            cs1.execute();

            CallableStatement cs2 = conn.prepareCall("{CALL sp_UpdateBalance(?, ?)}");
            cs2.setString(1, toId);
            cs2.setDouble(2, amount);
            cs2.execute();

            conn.commit();

            System.out.println("Chuyển tiền thành công");

            showBalance(conn);

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static boolean checkBalanceEnough(Connection conn, String accountId, double amount) throws SQLException {
        String sql = "SELECT balance FROM account WHERE account_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, accountId);

        ResultSet rs = ps.executeQuery();

        if (!rs.next()) {
            return false;
        }

        double balance = rs.getDouble("balance");
        return balance >= amount;
    }

    private static void showBalance(Connection conn) throws SQLException {
        String sql = "SELECT * FROM account";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                    rs.getString("account_id") + " - " + rs.getDouble("balance")
            );
        }
    }
}