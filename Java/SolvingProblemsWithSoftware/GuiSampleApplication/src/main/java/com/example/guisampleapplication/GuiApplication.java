package com.example.guisampleapplication;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

//import static java.awt.Color.BLACK;

public class GuiApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600,400);

        stage.setTitle("My Studio");

        /* right */
        VBox rightPanel = new VBox();
        rightPanel.setPadding(new Insets(5) );
        rightPanel.setStyle("-fx-background-color: yellow");

        Button SineWaveButton = new Button("SineWave");
        rightPanel.getChildren().add(SineWaveButton);
        SineWaveButton.setOnAction(e -> createComponet("SineWave"));



        // center panel stuff:
        AnchorPane mainCanvas = new AnchorPane();
        mainCanvas.setStyle("-fx-background-color: yellow");

        root .setRight(rightPanel);
        root.setCenter(mainCanvas);

        Circle speakerCircle = new Circle(400, 200, 15);
        speakerCircle.setFill(Color.BLACK);

        mainCanvas.getChildren().add(speakerCircle);

        // put the pannel into the borderpane
        root.setRight(rightPanel);
        stage.setScene(scene);
        stage.show();
    }


    private void createComponet(String sineWave) {
        System.out.println("Create  Component");

//        AudioComponentWidget acw = new AudioComponentWidget( sineWave,mainCanvas, "SineWave");

    }

    public static void main(String[] args) {
        launch();
    }


}