package btth;

import btth.util.DataConnect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DataConnect.openConnection()) {
            conn.setAutoCommit(false);

            String splWithdraw = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            String splTransfer = "insert into transfer(sender_id,receive_id,amount,message,transfer_date) values (?, ?, ?,?,?)";
            String sqlDeposit =  "UPDATE accounts SET balance = balance + ? WHERE id = ?";

            PreparedStatement prWithdraw = conn.prepareStatement(splWithdraw);
            PreparedStatement prTransfer = conn.prepareStatement(splTransfer);
            PreparedStatement prDeposit = conn.prepareStatement(sqlDeposit);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
