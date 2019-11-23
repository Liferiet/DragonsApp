package bean;

import model.User;

public class LoginBean {

    private User user;
    private String email;
    private String password;

    public LoginBean() {
        user = new User();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }
}
