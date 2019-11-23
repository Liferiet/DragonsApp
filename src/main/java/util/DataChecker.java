package util;

public class DataChecker {
    public boolean checkEmail(String email) {
        return email.matches("[a-z0-9_-]+(?:\\.[a-z0-9_-]+)*@" +
                "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
    }

    public boolean checkNickname(String nickname) {
        return nickname.matches("[a-zA-Z0-9]{3}[a-zA-Z0-9]*");
    }

    public boolean checkPassword(String password) {
        return password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{6,30}");
    }
}
