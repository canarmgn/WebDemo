package org.example.webdemo.repository;

import org.example.webdemo.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class WebRepository {
    public void save(String title) throws SQLException {
        String dbUrl = DatabaseConfig.DB_URL;
        String username = DatabaseConfig.USERNAME;
        String password = DatabaseConfig.PASSWORD;

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
            String sql = "INSERT INTO haberler (title) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.executeUpdate();
            }
        }
    }
}
