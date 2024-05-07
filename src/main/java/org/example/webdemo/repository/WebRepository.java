package org.example.webdemo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.example.webdemo.config.DatabaseConfig;

public class WebRepository {
    public void save(String title) throws SQLException {
        // Veritabanı bağlantı bilgilerini properties dosyasından al
        String dbUrl = DatabaseConfig.getUrl();
        String username = DatabaseConfig.getUsername();
        String password = DatabaseConfig.getPassword();

        try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
            String sql = "INSERT INTO haberler (title) VALUES (?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, title);
                statement.executeUpdate();
            }
        }
    }
}
