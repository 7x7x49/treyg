module com.example.l7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.l7 to javafx.fxml;
    exports com.example.l7;
}