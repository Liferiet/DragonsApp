package dao;

import bean.LoginBean;
import util.C3poDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {

    public boolean authenticateUser(LoginBean loginBean) {
        String email = loginBean.getEmail();
        String password = loginBean.getPassword();

        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = C3poDataSource.getConnection();
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            String dbEmail = "";
            String dbPassword = "";

            if (rs.next()) {
                dbEmail = rs.getString("email");
                dbPassword = rs.getString("password");
            }

            if (email.equals(dbEmail) && password.equals(dbPassword)) return true;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if( stmt != null )
                try{stmt.close( );} catch(Exception e) {}
            if( connection != null )
                try{connection.close( );} catch(Exception e) {}
        }
        return false;
    }
}
