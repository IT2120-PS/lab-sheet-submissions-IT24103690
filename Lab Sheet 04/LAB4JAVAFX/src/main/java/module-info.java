module com.example.lab4javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    // Open the main package (for MainApp etc.)
    opens com.example.lab4javafx to javafx.fxml;

    // Open the controllers package so FXML can access them
    opens com.example.lab4javafx.Controller to javafx.fxml;

    exports com.example.lab4javafx;
}
