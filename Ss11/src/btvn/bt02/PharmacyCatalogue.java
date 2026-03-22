package btvn.bt02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PharmacyCatalogue {
    public void printMedicines(Connection conn) {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy")) {

            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");
                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
