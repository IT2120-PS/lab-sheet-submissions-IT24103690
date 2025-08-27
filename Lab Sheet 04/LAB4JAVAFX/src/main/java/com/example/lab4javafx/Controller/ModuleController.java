package com.example.lab4javafx.Controller;

import com.example.lab4javafx.dao.ModuleDAO;
import com.example.lab4javafx.model.Module;
import com.example.lab4javafx.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;

public class ModuleController {

    @FXML private TextField txtMID;
    @FXML private TextField txtMName;
    @FXML private TextArea txtMDesc;
    @FXML private TableView<Module> moduleTable;
    @FXML private TableColumn<Module, String> colMID;
    @FXML private TableColumn<Module, String> colMName;
    @FXML private TableColumn<Module, String> colMDesc;

    private ModuleDAO dao;
    private ObservableList<Module> moduleList;

    @FXML
    public void initialize() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            dao = new ModuleDAO(conn);
            moduleList = FXCollections.observableArrayList(dao.getAllModules());

            colMID.setCellValueFactory(cellData -> cellData.getValue().MIDProperty());
            colMName.setCellValueFactory(cellData -> cellData.getValue().MNameProperty());
            colMDesc.setCellValueFactory(cellData -> cellData.getValue().MDescriptionProperty());

            moduleTable.setItems(moduleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addModule() {
        try {
            Module m = new Module(txtMID.getText(), txtMName.getText(), txtMDesc.getText());
            dao.addModule(m);
            moduleList.add(m);
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteModule() {
        Module selected = moduleTable.getSelectionModel().getSelectedItem();
        if(selected != null) {
            try {
                dao.deleteModule(selected.getMID());
                moduleList.remove(selected);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void clearFields() {
        txtMID.clear();
        txtMName.clear();
        txtMDesc.clear();
    }
}
