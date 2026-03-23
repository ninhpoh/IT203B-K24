package btvn.bt02;

import btvn.bt01.util.DataBaseConnection;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. them chỉ số sinh tồn bệnh nhân");
            System.out.println("2. cap nhat");
            System.out.println("3. thoat");
            System.out.println("lua chon cua ban: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try (Connection conn = DataBaseConnection.openConnection()) {
                        String sql = "INSERT INTO bt02 (id, temperature, heart_rate) VALUES (?, ?, ?)";
                        PreparedStatement ps = conn.prepareStatement(sql);

                        System.out.print("Nhập ID bệnh nhân: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhập nhiệt độ ban đầu (double): ");
                        double temp = Double.parseDouble(sc.nextLine());

                        System.out.print("Nhập nhịp tim ban đầu (int): ");
                        int heartRate = Integer.parseInt(sc.nextLine());

                        ps.setInt(1, id);
                        ps.setDouble(2, temp);
                        ps.setInt(3, heartRate);

                        ps.executeUpdate();
                        System.out.println("Thêm hồ sơ bệnh nhân thành công!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try (Connection conn = DataBaseConnection.openConnection()) {
                        String sql = "UPDATE bt02 SET temperature = ?, heart_rate = ? WHERE id = ?";
                        PreparedStatement ps = conn.prepareStatement(sql);

                        System.out.print("Nhập ID bệnh nhân: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhập nhiệt độ (double): ");
                        double temp = Double.parseDouble(sc.nextLine());

                        System.out.print("Nhập nhịp tim (int): ");
                        int heartRate = Integer.parseInt(sc.nextLine());

                        ps.setDouble(1, temp);
                        ps.setInt(2, heartRate);
                        ps.setInt(3, id);

                        int rows = ps.executeUpdate();
                        if (rows > 0) {
                            System.out.println("Cập nhật chỉ số sinh tồn thành công!");
                        } else {
                            System.out.println("Không tìm thấy bệnh nhân với ID này.");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }while(choice != 3);
    }
}