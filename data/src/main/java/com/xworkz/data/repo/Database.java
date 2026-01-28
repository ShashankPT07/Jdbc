package com.xworkz.data.repo;

import com.xworkz.data.dto.SignUpDto;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/login_db";
    private static final String USER = "root";
    private static final String PASS = "root";


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean save(SignUpDto dto) {
        String query =
                "INSERT INTO login_tb (name, surname, phoneNumber, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getSurname());
            ps.setLong(3, dto.getPhoneNumber());
            ps.setString(4, dto.getEmail());
            ps.setString(5, dto.getUsername());
            ps.setString(6, dto.getPassword());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getPasswordByUsername(String username) {
        String query = "SELECT password FROM login_tb WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
