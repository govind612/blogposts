package com.blog.DAOImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.blog.DAO.UserDAO;
import com.blog.model.User;

public class UserDAOImp implements UserDAO {
    String url = "jdbc:mysql://localhost:3306/blog_application";
    String username = "root";
    String password = "root";
    Connection con;

    public UserDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addUser(User user) {
        String query = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
       System.out.println(user);
       try {
    	   PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPasswordHash());
            stmt.setString(4, user.getRole());
          return  stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	return 0;
    }

    @Override
    public User getUser(int userId) {
        String query = "SELECT * FROM users WHERE id = ?";
        User user = null;
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                user = extractUserFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        User user = null;
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                user = extractUserFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ?, role = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPasswordHash());
            stmt.setString(4, user.getRole());
            stmt.setInt(5, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                users.add(extractUserFromResultSet(res));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private User extractUserFromResultSet(ResultSet res) throws SQLException {
        User user = new User();
        user.setId(res.getInt("id"));
        user.setName(res.getString("name"));
        user.setEmail(res.getString("email"));
        user.setPasswordHash(res.getString("password"));
        user.setRole(res.getString("role"));
        return user;
    }
}
