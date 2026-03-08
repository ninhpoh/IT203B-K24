package btvn.bt03;

public class User {
    private int age;

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không thể là số âm!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
