package btvn; //bt01

public class UserValidator {
    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        int length = username.length();
        return length >= 6 && length <= 20 && !username.contains(" ");
    }

}
