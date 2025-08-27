package com.example.lab4javafx.dao;

import com.example.lab4javafx.model.Student;
import com.example.lab4javafx.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static void insertStudent(Student student) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "INSERT INTO Student (SID, Sname, Address, Dob, NIC, CID) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getSid());
        stmt.setString(2, student.getSname());
        stmt.setString(3, student.getAddress());
        stmt.setString(4, student.getDob());
        stmt.setString(5, student.getNic());
        stmt.setString(6, student.getCid());
        stmt.executeUpdate();
    }

    public static List<Student> getAllStudents() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM Student";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            students.add(new Student(
                    rs.getString("SID"),
                    rs.getString("Sname"),
                    rs.getString("Address"),
                    rs.getString("Dob"),
                    rs.getString("NIC"),
                    rs.getString("CID")
            ));
        }
        return students;
    }

    public static void updateStudent(Student student) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "UPDATE Student SET Sname=?, Address=?, Dob=?, NIC=?, CID=? WHERE SID=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.getSname());
        stmt.setString(2, student.getAddress());
        stmt.setString(3, student.getDob());
        stmt.setString(4, student.getNic());
        stmt.setString(5, student.getCid());
        stmt.setString(6, student.getSid());
        stmt.executeUpdate();
    }

    public static void deleteStudent(String sid) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String sql = "DELETE FROM Student WHERE SID=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, sid);
        stmt.executeUpdate();
    }
}
