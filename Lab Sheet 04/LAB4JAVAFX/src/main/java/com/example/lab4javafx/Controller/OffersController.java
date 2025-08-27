package com.example.lab4javafx.Controller;

import com.example.lab4javafx.dao.OffersDAO;
import com.example.lab4javafx.model.Offers;
import com.example.lab4javafx.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;

public class OffersController {

    @FXML private TextField txtCID;
    @FXML private TextField txtMcode;
    @FXML private TextField txtAccYear;
    @FXML private TextField txtSemester;
    @FXML private TableView<Offers> offersTable;
    @FXML private TableColumn<Offers, String> colCID;
    @FXML private TableColumn<Offers, String> colMcode;
    @FXML private TableColumn<Offers, String> colAccYear;
    @FXML private TableColumn<Offers, Integer> colSemester;

    private OffersDAO dao;
    private ObservableList<Offers> offersList;

    @FXML
    public void initialize() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            dao = new OffersDAO(conn);
            offersList = FXCollections.observableArrayList(dao.getAllOffers());

            colCID.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getCID()));
            colMcode.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getMcode()));
            colAccYear.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getAccademic_year()));
            colSemester.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getSemester()).asObject());

            offersTable.setItems(offersList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addOffer() {
        try {
            int semester = Integer.parseInt(txtSemester.getText());
            Offers o = new Offers(txtCID.getText(), txtMcode.getText(), txtAccYear.getText(), semester);
            dao.addOffer(o);
            offersList.add(o);
            clearFields();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteOffer() {
        Offers selected = offersTable.getSelectionModel().getSelectedItem();
        if(selected != null) {
            try {
                dao.deleteOffer(selected.getCID(), selected.getMcode());
                offersList.remove(selected);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clearFields() {
        txtCID.clear();
        txtMcode.clear();
        txtAccYear.clear();
        txtSemester.clear();
    }
}
