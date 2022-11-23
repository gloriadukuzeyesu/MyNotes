module com.example.guisampleapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guisampleapplication to javafx.fxml;
    exports com.example.guisampleapplication;
}