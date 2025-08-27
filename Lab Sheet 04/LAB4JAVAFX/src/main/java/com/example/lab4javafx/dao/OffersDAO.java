package com.example.lab4javafx.dao;

import com.example.lab4javafx.model.Offers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OffersDAO {

    private Connection conn;

    public OffersDAO(Connection conn) {
        this.conn = conn;
    }

    public void addOffer(Offers offer) throws SQLException {
        String sql = "INSERT INTO Offers(CID, Mcode, Accademic_year, Semester) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, offer.getCID());
        stmt.setString(2, offer.getMcode());
        stmt.setString(3, offer.getAccademic_year());
        stmt.setInt(4, offer.getSemester());
        stmt.executeUpdate();
    }

    public List<Offers> getAllOffers() throws SQLException {
        List<Offers> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Offers");
        while(rs.next()) {
            Offers o = new Offers(
                    rs.getString("CID"),
                    rs.getString("Mcode"),
                    rs.getString("Accademic_year"),
                    rs.getInt("Semester")
            );
            list.add(o);
        }
        return list;
    }

    public void deleteOffer(String CID, String Mcode) throws SQLException {
        String sql = "DELETE FROM Offers WHERE CID=? AND Mcode=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, CID);
        stmt.setString(2, Mcode);
        stmt.executeUpdate();
    }
}
