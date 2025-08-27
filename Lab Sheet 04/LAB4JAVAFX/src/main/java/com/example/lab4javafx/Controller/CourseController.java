package com.example.lab4javafx.Controller;

import com.example.lab4javafx.dao.CourseDAO;
import com.example.lab4javafx.model.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CourseController {
    @FXML private TextField cidField;
    @FXML private TextField cnameField;
    @FXML private TextArea descriptionField;
    @FXML private TextField feeField;
    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, String> cidCol;
    @FXML private TableColumn<Course, String> cnameCol;
    @FXML private TableColumn<Course, String> descCol;
    @FXML private TableColumn<Course, Double> feeCol;

    private ObservableList<Course> courseList;

    @FXML
    public void initialize() {
        cidCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCid()));
        cnameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getCname()));
        descCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDescription()));
        feeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getFee()));

        courseList = FXCollections.observableArrayList(CourseDAO.getAllCourses());
        courseTable.setItems(courseList);
    }

    @FXML
    private void addCourse() {
        Course course = new Course(cidField.getText(), cnameField.getText(),
                descriptionField.getText(), Double.parseDouble(feeField.getText()));
        if (CourseDAO.insertCourse(course)) {
            courseList.add(course);
            clearFields();
        }
    }

    private void clearFields() {
        cidField.clear();
        cnameField.clear();
        descriptionField.clear();
        feeField.clear();
    }
}
