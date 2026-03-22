package btvn.bt04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientLookup {
    public void findPatientByName(Connection conn, String patientName) {
        String sql = "SELECT * FROM Patients WHERE fullName = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patientName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Bệnh nhân: " + rs.getString("fullName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
* pHAN 1
* - điều kiện OR '1'='1' luôn đúng. Nghĩa là:
        - Nếu fullName = '' sai, thì '1'='1' vẫn đúng.
        - Kết quả: toàn bộ bảng Patients được trả về, không chỉ một bệnh nhân.
*/