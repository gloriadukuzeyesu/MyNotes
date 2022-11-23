package com.example.practicejavafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Demo extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();
        Scene scene = new Scene( root, 1000, 500);
        VBox componentWidget = new VBox();
        componentWidget.setStyle("-fx-background-color: purple");
        componentWidget.relocate(50,50);
        Label title = new Label();
        title.setText("Music studio");
        componentWidget.getChildren().add(title);
        Button button = new Button("PLAY");
        Button SintBtn = new Button("create a sinewave");

        Slider slide = new Slider(220,800,4440);

        root.getChildren().add(slide);
        root.getChildren().add(SintBtn);

        root.getChildren().add(button );
        root.getChildren().add(componentWidget);
        stage.setTitle("Demo purposes");
        stage.setScene(scene);
        stage.show();





    }

    public static void main(String[] args) {
        launch();
    }
}