package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl {

    public ArrayList<User> getAllUsers(Connection connection) {

        String sql = "SELECT * FROM users";
        ArrayList<User> usersList = new ArrayList<User>();

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setAccountCreationDate(rs.getDate("creation_date"));

                usersList.add(user);
            }
            return usersList;

        } catch (SQLException se) {
            System.err.println("Exception with executing query" + se.getMessage());
        }
        return usersList;
    };

    public User getUserByEmailAndPassword(Connection connection, String email, String password) {
        String sql = "SELECT id, nickname FROM users WHERE email = ? AND password = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setNickname(rs.getString("nickname"));
            }


        } catch (SQLException se) {
            System.err.println(se.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {
                System.err.println(e.getMessage());
            };
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {
                System.err.println(e.getMessage());
            };
            try { if (connection != null) connection.close(); } catch (SQLException e) {
                System.err.println(e.getMessage());
            };
        }
        return user;
    }

    public boolean insertUser(Connection connection, User user) {
        String sql = "INSERT INTO users (email, password, nickname) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getNickname());

            int updatedRows = pstmt.executeUpdate();
            if (updatedRows == 1) {
                System.out.println("User was successfully added");
                return true;
            }

            System.out.println("Cannot add user");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("inside finally block");
        }
        return false;
    }

    public boolean doesUserEmailExist(Connection connection, String email) {
        String sql = "SELECT email FROM users WHERE email = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

/*    public boolean changePassword(Connection connection, int userId) {

    }*/
//    boolean deleteUser();

}
