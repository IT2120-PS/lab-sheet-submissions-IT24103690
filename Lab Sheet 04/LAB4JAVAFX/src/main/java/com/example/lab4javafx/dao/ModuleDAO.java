package com.example.lab4javafx.dao;

import com.example.lab4javafx.model.Module;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAO {
    private Connection conn;

    public ModuleDAO(Connection conn) {
        this.conn = conn;
    }

    public void addModule(Module module) throws SQLException {
        String sql = "INSERT INTO Module(MID, MName, MDescription) VALUES(?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, module.getMID());
        stmt.setString(2, module.getMName());
        stmt.setString(3, module.getMDescription());
        stmt.executeUpdate();
    }

    public List<Module> getAllModules() throws SQLException {
        List<Module> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Module");
        while(rs.next()) {
            Module m = new Module(rs.getString("MID"), rs.getString("MName"), rs.getString("MDescription"));
            list.add(m);
        }
        return list;
    }

    public void deleteModule(String MID) throws SQLException {
        String sql = "DELETE FROM Module WHERE MID=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, MID);
        stmt.executeUpdate();
    }
}
