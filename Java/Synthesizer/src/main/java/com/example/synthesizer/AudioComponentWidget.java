package com.example.synthesizer;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class AudioComponentWidget extends Pane {

    private AudioComponent audioComponent_;
    private AnchorPane parent_;
    private String name_;
    private HBox baseLayout;
    private Line line_;

    private double mouseStartDragX_, mouseStartDragY_, widgetStartDragX_, widgetStartDragY_;

    AudioComponentWidget () {

    }

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

    private void endConnection(MouseEvent e, Circle outputCircle) {
        Circle speaker = SynthesizeApplication.speaker_;
        Bounds speakerBounds = speaker.localToScreen( speaker.getBoundsInLocal() );
        double distance = Math.sqrt( Math.pow ( speakerBounds.getCenterX() - e.getScreenX(), 2.0 ) +
                                        Math.pow( speakerBounds.getCenterY() - e.getScreenY(), 2.0 ) );
        if ( distance < 10 ) {
            //handle actual connection to speaker
//            SynthesizeApplication.widgets_.remove( this );
        }
        else {
            parent_.getChildren().remove( line_);
            line_ = null;
        }
        SynthesizeApplication.SpeakerWidgets_.add(this);

    }

    private void moveConnection(MouseEvent e, Circle outputCircle) {
        Bounds parentBounds = parent_.getBoundsInParent();
        line_.setEndX( e.getSceneX() - parentBounds.getMinX() );
        line_.setEndY( e.getSceneY() - parentBounds.getMinY() );
    }

    private void startConnection(MouseEvent e, Circle outputCircle) {
        // if a line exists (if there is a line connected to someone else)
        if ( line_ != null ) {
            // remove that line so that we can create a new connection
            parent_.getChildren().remove( line_ );
            System.out.println("remove the line");
        }

        Bounds parentBounds = parent_.getBoundsInParent();
        Bounds bounds = outputCircle.localToScene( outputCircle.getBoundsInLocal() );

        line_ = new Line();
        line_.setStrokeWidth ( 4 );
        line_.setStartX( bounds.getCenterX() - parentBounds.getMinX() );
        line_.setStartY( bounds.getCenterY() - parentBounds.getMinY() );
        line_.setEndX( e.getSceneX() );
        line_.setEndY( e.getSceneY() );
        // add line to the parent so it can be drawn
        parent_.getChildren().add( line_ );


    }

    private void handleDrag(MouseEvent e) {
        double mouseDelX = e.getSceneX() - mouseStartDragX_;
        double mouseDelY = e.getSceneY() - mouseStartDragY_;
        this.relocate(widgetStartDragX_ + mouseDelX,widgetStartDragY_ + mouseDelY );
    }

    private void startDrag(MouseEvent e) {
        mouseStartDragX_  = e.getSceneX();
        mouseStartDragY_ = e.getSceneY();
        widgetStartDragX_ = this.getLayoutX();
        widgetStartDragY_ = this.getLayoutY();
    }

    private void handleSlider(MouseEvent e, Slider slider, Label title) {
        int value = (int) slider.getValue();
        title.setText("Sine Wave (" + value + "Hz)");
        audioComponent_ = new SineWave( value );
    }


    private void closeWidget() {
        parent_.getChildren().remove(this );
        SynthesizeApplication.widgets_.remove( this ); // spaghetti code.
        System.out.println("widget has been removed");
        if( line_ != null ) {
            parent_.getChildren().remove( line_ );
        }
        SynthesizeApplication.SpeakerWidgets_.remove(this);


    }



    public AudioComponent getAudioComponent() { return audioComponent_;}

}

