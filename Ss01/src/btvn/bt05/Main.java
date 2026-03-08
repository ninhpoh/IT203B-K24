package btvn.bt05;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        try {
            user.setAge(-5);
            System.out.println("Tuổi của user: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Ngoại lệ tùy chỉnh được bắt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}