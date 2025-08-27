package com.example.lab4javafx;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Change these according to your SQL Server settings
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=UniversityDB;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "1111";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connection successful!");
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
        return connection;
    }
}