package ra.presentation;

import ra.business.StudentBusiness;
import ra.entity.Student;
import java.util.Scanner;

public class StudentManagement {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int choise = 0;

        do {
            System.out.println("***********Quản lý sinh viên**********");
            System.out.println("1. Hiện thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Lọc danh sách sinh viên Giỏi");
            System.out.println("7. sắp xếp danh sách sinh viên giảm dần theo điểm ");
            System.out.println("8. Thoát");
            System.out.print("Thao tác của bạn: ");
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("============Dang sách sinh viên==============");
                    StudentBusiness.getInstance().displayAll();
                    break;
                case 2:
                    boolean cout = true;
                    while (cout ) {
                        Student s = new Student();
                        s.inputData(sc);
                        StudentBusiness.getInstance().addStudent(s);
                        System.out.print("Bạn có muốn thêm sinh viên khác? (y/n): ");
                        cout = sc.next().equalsIgnoreCase("y");
                    }
                    break;
                case 3:
                    System.out.println("Nhập mã sinh viên cần cập nhật: ");
                    String idUpdate = sc.next();
                    System.out.println("Nhập tên mới (Enter bỏ qua): ");
                    String newName = sc.next();
                    System.out.println("Nhập tuổi mới (Enter bỏ qua): ");
                    int newAge = sc.nextInt();
                    System.out.println("Nhập điểm mới (Enter bỏ qua): ");
                    double newGpa = sc.nextDouble();
                    Student sUpdate = new Student();
                    sUpdate.setStudentID(idUpdate);
                    if (!newName.trim().isEmpty()) {
                        sUpdate.setStudentName(newName);
                    }
                    if (newAge >= 18) {
                        sUpdate.setAge(newAge);
                    }
                    if (newGpa >= 0 && newGpa <= 10) {
                        sUpdate.setGpa(newGpa);
                    }
                    StudentBusiness.getInstance().updateStudentById(sUpdate);
                    break;
                case 4:
                    System.out.println("Nhập mã sinh viên cần xóa: ");
                    String idDelete = sc.next();
                    Student sDelete = new Student();
                    sDelete.setStudentID(idDelete);
                    StudentBusiness.getInstance().deleteStudentById(sDelete);
                    break;
                case 5:
                    System.out.println("...");
                    break;
                case 6:
                    System.out.println("...");
                    break;
                case 7:
                    System.out.println("Sắp xếp danh sách sinh viên giảm dần theo điểm GPA:");
                    StudentBusiness.getInstance().sortByGpaDescending();
                    System.out.println("============Dang sách sau sắp xếp==============");
                    StudentBusiness.getInstance().displayAll();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                    break;
            }
        }while (choise != 8);
    }
}
