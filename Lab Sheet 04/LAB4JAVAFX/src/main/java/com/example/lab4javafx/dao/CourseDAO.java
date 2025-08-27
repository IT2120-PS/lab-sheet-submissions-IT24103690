package com.example.lab4javafx.dao;

import com.example.lab4javafx.DatabaseConnection;
import com.example.lab4javafx.model.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public static boolean insertCourse(Course course) {
        String sql = "INSERT INTO Course (CID, Cname, C_Description, C_fee) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, course.getCid());
            stmt.setString(2, course.getCname());
            stmt.setString(3, course.getDescription());
            stmt.setDouble(4, course.getFee());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public static List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM Course";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Course(rs.getString("CID"), rs.getString("Cname"),
                        rs.getString("C_Description"), rs.getDouble("C_fee")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }
}