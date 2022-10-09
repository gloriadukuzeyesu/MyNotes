module com.example.synthesizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.junit.jupiter.api;
    requires org.controlsfx.controls;
    requires jdk.jfr;


    opens com.example.synthesizer to javafx.fxml;
    exports com.example.synthesizer;
}