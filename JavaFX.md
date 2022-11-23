* New GUI library
* JavaFx uses a lot of interfaces and inheritance

# Components

1. main window has a Stage 
   * displays one Scence at time
   * a scene contains a parent object. Example `AnchorPane root = new AnchorPane();`  // roor is the parent object and contains child nodes 

## how to make a GUI 

1. create nodes
2. add them to the parent
3. create a scene from the top level parent
4. put the scence on the stage 





## widget 

* button
* Label
* Slider
* Circle, line, rectangle, many other shapes
* parent itself which is a container of more nodes



*NOTES*

when a user does something. like moves the mouse, presses a key, etc. the code will be notified by *events* 

NODES enables us to attach "***listeners***"



### Layout 

1. Need a top layout "parent" to be the base. Ex: Border pane has top, bottom, right, left and center position  for children layouts

   `BorderPane bp = new BorderPane()`

2. Add borderPane to the scene and then add the scene to the Stage ( refer above, how to make GUI, refer to SYnthesiser project)
3. `Scene scene = new Scene ( bp, 1000, 500);`// add size of the window



```java
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("How are you!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

my Example 

```java
public void start(Stage stage) throws IOException {

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene( root, 440, 300);

        //creat an audion component  as verticle box

        VBox componentWidget = new VBox();
        componentWidget.setStyle ("-fx-background-color: purple");

        Label title = new Label();
        title.setText("I am red for the cool music.Sine wave(440HZ)");

        componentWidget.getChildren().add(title);

        // how to set the widget on different location on the screen
        componentWidget.relocate(50, 100);


        // ability to move the box and move around this around the screen
        componentWidget.setOnMousePressed( e -> handleMOusePressed (e) );

        // add a slider that can be moved around
        Slider slider = new Slider(220,880,4440 );
        componentWidget.getChildren().add(slider);

//        slider.setOnMouseDragged(e -> handleSlider (e) );

        //1. get the children and add
        root.getChildren().add(componentWidget);

        // write once and odo not worry about it
        stage.setScene(scene);
        stage.show();





        // TODO how to create GUI
        Button submit_b = new Button("submit ");
        Button cancel_B = new Button("Cancel");

        GridPane g1 = new GridPane();
        // add our object to the layout
        g1.add(submit_b,1, 1 ); // the first argument is the colum
        g1.add(cancel_B, 1, 2);

        Scene s1 = new Scene(g1, 500, 500);

        // add the scene to the stage
        stage.setScene(s1);
        stage.show();


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


/*
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cancel_B.setText("text updated");
            }

            // add some cool feature like dragging
        };

 */



    }



    private void handleSlider(MouseEvent e, Slider slider, Label Title ) {
       int value = (int) slider.getValue();
       // TODO check on the title
//       title.setText("Sine wave" + value + "HZ");

    }

    private void handleMOusePressed(MouseEvent e) {
        System.out.println("Mouse was pressed " );
    }

    public static void main(String[] args) {
        Application.launch(SynthesizeApplication.class); // this will run my JavaFx GUI app, basically it will run the start()
    }
}
```



```java
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
```

```java
// module-info.java



module com.example.practicejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.practicejavafx to javafx.fxml;
    exports com.example.practicejavafx;
}
```



```java
// code for my GUI cheat sheet


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
```





Notes

1. I need to find a way of deleting the audio system after closing the widget because after closing it, I can still play the sound using play button. 
2. Start playing the sound after the sinewave is connected to the speaker. 





Volume widget

* parent as the border box
* location of it at the screen
* slide 



```java
 AudioComponentWidget(AudioComponent ac, AnchorPane parent, String name )
    {
        audioComponent_ = ac;
        parent_ = parent;
        name_ = name;
        baseLayout = new HBox();
        baseLayout.setStyle("-fx-border-color: black; -fx-border-image-width: 10; -fx-background-color: seashell");

        /* Right side of the widget */
        VBox rightRightSide = new VBox();
        Button closeButton = new Button();
        closeButton.setText("X");
        closeButton.setOnAction( e -> closeWidget() );
        closeButton.setTextFill(Color.RED);

        Circle OutputCircle = new Circle(10);
        OutputCircle.setFill(Color.GREEN);
        OutputCircle.setOnMousePressed( e -> startConnection ( e, OutputCircle));
        OutputCircle.setOnMouseDragged( e -> moveConnection ( e, OutputCircle));
        OutputCircle.setOnMouseReleased( e -> endConnection ( e, OutputCircle));

        rightRightSide.getChildren().add(closeButton);
        rightRightSide.getChildren().add(OutputCircle);
        rightRightSide.setAlignment( Pos.CENTER );
        rightRightSide.setPadding(new Insets(6));
        rightRightSide.setSpacing( 5 );


        /***** center portion of the widget *****/
        VBox centerComponent = new VBox();
        centerComponent.setStyle("-fx-background-color: lavender");
        centerComponent.setAlignment( Pos.CENTER);
        /* add a nameLabel */
        Label title = new Label();
        title.setMouseTransparent(true);
        title.setText("Sine Wave (440 Hz)");


        /* add a slide */
        Slider slide = new Slider(220, 880, 440);
        slide.setOnMouseDragged( e -> handleSlider(e, slide, title) );


        centerComponent.getChildren().add(title);
        centerComponent.getChildren().add(slide);
        
        centerComponent.setOnMousePressed(e -> startDrag( e ) );
        centerComponent.setOnMouseDragged(e -> handleDrag ( e ) );

//        centerComponent.relocate(50,50);

        baseLayout.getChildren().add(centerComponent);
        baseLayout.getChildren().add( rightRightSide );
        // add the baseLayout to the pane. baseLayout is the object of Pane
        this.getChildren().add( baseLayout );

        this.setLayoutX( 80 );
        this.setLayoutY( 100 );

        parent_.getChildren().add( this );
    }
```





