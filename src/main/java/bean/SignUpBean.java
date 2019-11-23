package bean;

import model.User;

public class SignUpBean {

        private User user;

    public SignUpBean() {
            this.user = new User();
        }

        public void setEmail(String email) {
            user.setEmail(email);
        }

        public String getEmail() {
            return user.getEmail();
        }

        public void setPassword(String password) {
            user.setPassword(password);
        }

        public String getPassword() {
            return user.getPassword();
        }

        public void setNickname(String nickname) {
            user.setNickname(nickname);
    }

    public String getNickname() {
        return user.getNickname();
    }
}
