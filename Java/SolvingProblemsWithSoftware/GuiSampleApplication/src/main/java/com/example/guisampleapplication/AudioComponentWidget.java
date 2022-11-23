package com.example.guisampleapplication;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AudioComponentWidget extends Pane {
    AudioComponentWidget audoiComponent;
    AnchorPane parent_;
    String name_;
    HBox baseLayout;



    AudioComponentWidget(AudioComponentWidget ac, AnchorPane parent, String name){
        audoiComponent = ac;
        parent_ = parent;
        name_ = name;


        baseLayout = new HBox();

        //rightsisef
        VBox rightside = new VBox();
        Button closeBtn = new Button("X");
        Circle output = new Circle(10);
        output.setFill(Color.BLUE);
        rightside.getChildren().add(closeBtn);
        rightside.getChildren().add(output);

        baseLayout.getChildren().add(rightside);





    }
}
