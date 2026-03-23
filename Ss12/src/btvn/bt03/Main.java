package btvn.bt03;

import btvn.bt03.util.DataBaseConnection;
import java.sql.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập hồ sơ phẫu thuật");
            System.out.println("2. Tra cứu chi phí phẫu thuật");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            try (Connection conn = DataBaseConnection.openConnection()) {
                switch (choice) {
                    case 1:
                        String sqlInsert = "INSERT INTO bt03 (id, surgery_name, base_cost, insurance_fee) VALUES (?, ?, ?, ?)";
                        PreparedStatement ps = conn.prepareStatement(sqlInsert);

                        System.out.print("ID phẫu thuật: ");
                        ps.setInt(1, Integer.parseInt(sc.nextLine()));

                        System.out.print("Tên phẫu thuật: ");
                        ps.setString(2, sc.nextLine());

                        System.out.print("Chi phí cơ bản: ");
                        ps.setDouble(3, Double.parseDouble(sc.nextLine()));

                        System.out.print("Chi phí bảo hiểm: ");
                        ps.setDouble(4, Double.parseDouble(sc.nextLine()));

                        ps.executeUpdate();
                        System.out.println("Thêm hồ sơ phẫu thuật thành công!");
                        break;

                    case 2:
                        CallableStatement cstmt = conn.prepareCall("{call GET_SURGERY_FEE(?, ?)}");

                        System.out.print("Nhập ID phẫu thuật: ");
                        int sid = Integer.parseInt(sc.nextLine());

                        cstmt.setInt(1, sid);
                        cstmt.registerOutParameter(2, Types.DECIMAL);

                        cstmt.execute();
                        double cost = cstmt.getDouble(2);
                        System.out.println("Chi phí phẫu thuật: " + cost);
                        break;

                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;

                    default:
                        System.out.println("Chức năng không hợp lệ!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } while (choice != 0);

    }
}