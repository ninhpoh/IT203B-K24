package btth;

import btth.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try(Connection con = DataBaseConnection.openConnection()){
            String spl = "INSERT INTO doctors VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(spl);

            System.out.println("Nhap ma bac si: ");
            preparedStatement.setString(1, sc.nextLine());
            preparedStatement.setString(2, sc.nextLine());
            preparedStatement.setString(3, sc.nextLine());
            preparedStatement.setInt(4, Integer.parseInt(sc.nextLine()));
            preparedStatement.setString(5, sc.nextLine());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
