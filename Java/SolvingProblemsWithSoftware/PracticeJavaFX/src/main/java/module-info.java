module com.example.practicejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.practicejavafx to javafx.fxml;
    exports com.example.practicejavafx;
}