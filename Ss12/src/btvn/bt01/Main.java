package btvn.bt01;

import btvn.bt01.util.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Thêm bác sĩ");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try (Connection conn = DataBaseConnection.openConnection()) {
                        String sql = "INSERT INTO bt01 (id, doctor_name, code, password) VALUES (?, ?, ?, ?)";
                        PreparedStatement ps = conn.prepareStatement(sql);

                        System.out.print("Nhập ID bác sĩ: ");
                        ps.setInt(1, Integer.parseInt(sc.nextLine()));

                        System.out.print("Nhập tên bác sĩ: ");
                        ps.setString(2, sc.nextLine());

                        System.out.print("Nhập mã bác sĩ: ");
                        ps.setString(3, sc.nextLine());

                        System.out.print("Nhập mật khẩu: ");
                        ps.setString(4, sc.nextLine());

                        ps.executeUpdate();
                        System.out.println("Thêm bác sĩ thành công!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                    case 2:
                        try (Connection conn = DataBaseConnection.openConnection()) {

                            System.out.print("Nhập mã bác sĩ: ");
                            String code = sc.nextLine();

                            System.out.print("Nhập mật khẩu: ");
                            String password = sc.nextLine();

                            String sql = "SELECT * FROM bt01 WHERE code = ? AND password = ?";
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1, code);
                            ps.setString(2, password);

                            ResultSet rs = ps.executeQuery();

                            if (rs.next()) {
                                System.out.println("Đăng nhập thành công! Xin chào bác sĩ " + rs.getString("doctor_name"));
                            } else {
                                System.out.println("Sai mã bác sĩ hoặc mật khẩu.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        break;
            }
        }while (choice != 3);
        // them moi

    }
}