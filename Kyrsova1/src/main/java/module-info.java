module com.example.kyrsova1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kyrsova1 to javafx.fxml;
    exports com.example.kyrsova1;
}