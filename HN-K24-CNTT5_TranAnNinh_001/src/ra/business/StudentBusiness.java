package ra.business;

import ra.entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentBusiness {
    private static StudentBusiness instance;
    private List<Student> students = new ArrayList<Student>();

    public static StudentBusiness getInstance() {
        if (instance == null) {
            instance = new StudentBusiness();
        }
        return instance;
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("Chưa có sinh viên nào!");
        } else {
            students.forEach(Student::displayData);
        }
    }

    public boolean addStudent(Student s) {
        Optional<Student> exists = students.stream()
                .filter(st -> st.getStudentID().equalsIgnoreCase(s.getStudentID()))
                .findFirst();
        if (exists.isPresent()) {
            System.out.println(" Lỗi:Id bị trùng!");
            return false;
        }
        students.add(s);
        return true;
    }

    public void updateStudentById(Student s) {
        Optional<Student> exists = students.stream()
                .filter(st -> st.getStudentID().equalsIgnoreCase(s.getStudentID()))
                .findFirst();
        if (exists.isPresent()) {
            Student studentToUpdate = exists.get();
            studentToUpdate.setStudentName(s.getStudentName());
            studentToUpdate.setAge(s.getAge());
            studentToUpdate.setGpa(s.getGpa());
        }else {
            System.out.println("Không tìm thấy sinh viên có mã: " + s.getStudentID());
        }
    }

    public void deleteStudentById(Student s) {
        Optional<Student> exists = students.stream()
                .filter(st -> st.getStudentID().equalsIgnoreCase(s.getStudentID()))
                .findFirst();
        if (exists.isPresent()) {
            students.remove(exists.get());
        }else {
            System.out.println("Không tìm thấy sinh viên có mã: " + s.getStudentID());
        }
    }

    public void sortByGpaDescending() {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
    }
}
