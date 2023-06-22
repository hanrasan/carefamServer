package com.example.carefamserver.services;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class SelectService {
    private static final String DB_URL = "jdbc:mariadb://localhost:33063";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void selectAll() {
        String sql = "SELECT * FROM `CAREFAM`.`mainData` LIMIT 10";

        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // 처리할 예외
                }
            }
        }
    }
}
