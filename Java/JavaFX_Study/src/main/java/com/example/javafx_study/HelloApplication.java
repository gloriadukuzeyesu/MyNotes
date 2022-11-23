package com.example.javafx_study;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.AccessibleAction;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 500);

        //parent Top  layer
        HBox topLayer = new HBox();
        topLayer.setAlignment(Pos.BOTTOM_CENTER);
        topLayer.setStyle("-fx-background-color: oldlace");
        topLayer.setPadding(new Insets(10));

        Button playBtn = new Button("PLAY");
        playBtn.setTextFill(Color.GREEN);
        topLayer.getChildren().add(playBtn);







        //parent Bottom  layer
        HBox bottomLayer = new HBox();



        //parent left  layer
        VBox leftLayer = new VBox();
        leftLayer.setStyle("-fx-background-color: yellow");
        leftLayer.setSpacing(50);
        leftLayer.setPadding(new Insets(10,10,10,10));

        Button SineWaveButton = new Button("SineWave");
        SineWaveButton.setTextFill(Color.BROWN);

        Button VolumeButton = new Button("Volume");
        VolumeButton.setTextFill(Color.BLACK);

        leftLayer.getChildren().add(SineWaveButton);
        leftLayer.getChildren().add(VolumeButton);
        leftLayer.setAlignment(Pos.CENTER);

        //parent right  layer
        VBox rightLayer = new VBox();
        rightLayer.setPadding(new Insets(5));
        rightLayer.setSpacing(80);
        rightLayer.setAlignment(Pos.CENTER);
        rightLayer.setStyle("-fx-background-color: green");
        rightLayer.setPadding(new Insets(10,10,10,10));
        rightLayer.setSpacing(50);

        Circle rightcircle = new Circle(40);
        rightcircle.setFill(Color.BLACK);

        rightLayer.getChildren().add(rightcircle);


        //parent center
        AnchorPane mainCanvas = new AnchorPane();
        mainCanvas.setStyle("-fx-background-color: red");




        Circle mycircle = new Circle(300, 400,30);
        mycircle.setFill(Color.PURPLE);

        mainCanvas.getChildren().add(mycircle);



        // add layers to the parent
        root.setBottom(bottomLayer);
        root.setRight(rightLayer);
        root.setLeft(leftLayer);
        root.setTop(topLayer);
        root.setCenter(mainCanvas);


        stage.setTitle("Midterm");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}