module com.example.javafx_study {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx_study to javafx.fxml;
    exports com.example.javafx_study;
}