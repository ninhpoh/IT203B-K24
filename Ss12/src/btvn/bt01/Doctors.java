package btvn.bt01;

public class Doctors {
    private String id;
    private String doctorName;
    private String code;
    private String password;

    public Doctors(String id, String doctorName, String code, String password) {
        this.id = id;
        this.doctorName = doctorName;
        this.code = code;
        this.password = password;
    }

    // Getter & Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Doctor{id='" + id + "', name='" + doctorName + "', code='" + code + "'}";
    }
}
