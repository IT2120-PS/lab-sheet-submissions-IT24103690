package com.example.lab4javafx.Controller;

import com.example.lab4javafx.dao.StudentDAO;
import com.example.lab4javafx.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {
    @FXML private TextField sidField;
    @FXML private TextField snameField;
    @FXML private TextField addressField;
    @FXML private DatePicker dobField;
    @FXML private TextField nicField;
    @FXML private TextField cidField;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> sidCol;
    @FXML private TableColumn<Student, String> snameCol;
    @FXML private TableColumn<Student, String> addressCol;
    @FXML private TableColumn<Student, String> dobCol;
    @FXML private TableColumn<Student, String> nicCol;
    @FXML private TableColumn<Student, String> cidCol;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        sidCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getSid()));
        snameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getSname()));
        addressCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getAddress()));
        dobCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDob()));
        nicCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNic()));
        cidCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCid()));
        loadStudents();
    }

    public void loadStudents() {
        try {
            studentList.setAll(StudentDAO.getAllStudents());
            studentTable.setItems(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        try {
            Student student = new Student(
                    sidField.getText(),
                    snameField.getText(),
                    addressField.getText(),
                    dobField.getValue().toString(),
                    nicField.getText(),
                    cidField.getText()
            );
            StudentDAO.insertStudent(student);
            loadStudents();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        try {
            Student student = new Student(
                    sidField.getText(),
                    snameField.getText(),
                    addressField.getText(),
                    dobField.getValue().toString(),
                    nicField.getText(),
                    cidField.getText()
            );
            StudentDAO.updateStudent(student);
            loadStudents();
            clearFields();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        try {
            Student selected = studentTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                StudentDAO.deleteStudent(selected.getSid());
                loadStudents();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        sidField.clear();
        snameField.clear();
        addressField.clear();
        dobField.setValue(null);
        nicField.clear();
        cidField.clear();
    }
}
