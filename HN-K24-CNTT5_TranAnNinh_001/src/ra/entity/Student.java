package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentID;
    private String studentName;
    private int age;
    private double gpa;

    public Student(String studentID, String studentName, int age, double gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.age = age;
        this.gpa = gpa;
    }

    public Student() {

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void inputData(Scanner scanner) {
        do {
            System.out.print("Nhập mã sinh viên: ");
            this.studentID = scanner.next();
        }while (this.studentID.trim().isEmpty());

        do {
            System.out.print("Nhập tên sinh viên: ");
            this.studentName = scanner.next();
        }while (this.studentName.trim().isEmpty());

        do {
            System.out.print("Nhập tuổi sinh viên: ");
            this.age = scanner.nextInt();
        }while (this.age <= 17);

        do {
            System.out.print("Nhap diem gpa: ");
            this.gpa = scanner.nextDouble();
        }while (this.gpa < 0 || this.gpa > 10);
    }

    public void displayData() {
        System.out.printf("| %-10s | %-20s | %-3d | %-4.2f |\n",
                studentID, studentName, age, gpa);
    }

}
