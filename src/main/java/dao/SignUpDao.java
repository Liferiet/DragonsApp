package dao;

import bean.SignUpBean;
import util.C3poDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpDao {

    public boolean createAccount(SignUpBean signUpBean) {
        String email = signUpBean.getEmail();
        String password = signUpBean.getPassword();
        String nickname = signUpBean.getNickname();

        String sql = "INSERT INTO users (email, password, nickname) VALUES (?, ?, ?)";



        try (Connection connection = C3poDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);) {

            if (doesAccountExists(email, connection)) return false;

            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.setString(3, nickname);

            int i = stmt.executeUpdate();

            if (i == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }

    private boolean doesAccountExists(String email, Connection connection) {
        String sql = "SELECT COUNT(1) FROM users WHERE email = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            int exists = 0;

            if (rs.next()) {
                exists = rs.getInt(1);
            }

            if (exists == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
