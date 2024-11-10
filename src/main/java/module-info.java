module com.example.ejercicior {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejercicior to javafx.fxml;
    exports com.example.ejercicior;
}