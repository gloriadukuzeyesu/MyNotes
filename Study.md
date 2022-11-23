```Java
 public void startConnection(MouseEvent e, Circle outputCircle, AudioComponentWidgetBase acw) {
        // if a line exists (if there is a line connected to someone else)
        if (acw.line_ != null) {
            // remove that line so that we can create a new connection
            parent.getChildren().remove(acw.line_);
            System.out.println("remove the line");
        }

        Bounds parentBounds = parent.getBoundsInParent();
        Bounds bounds = outputCircle.localToScene(outputCircle.getBoundsInLocal());
        acw.line_ = new Line();
        acw.line_.setStrokeWidth(2);
        acw.line_.setStartX(bounds.getCenterX() - parentBounds.getMinX());
        acw.line_.setStartY(bounds.getCenterY() - parentBounds.getMinY());
        acw.line_.setEndX(e.getSceneX());
        acw.line_.setEndY(e.getSceneY());
        // add line to the parent so it can be drawn
        parent_.getChildren().add(acw.line_);
    }
```

```java
    public  void moveConnection(MouseEvent e, AudioComponentWidgetBase acw ) {
        Bounds parentBounds = parent.getBoundsInParent();
        acw.line_.setEndX(e.getSceneX() - parentBounds.getMinX());
        acw.line_.setEndY(e.getSceneY() - parentBounds.getMinY());
    }
```

```java
    public  void moveConnection(MouseEvent e, AudioComponentWidgetBase acw ) {
        Bounds parentBounds = parent.getBoundsInParent();
        acw.line_.setEndX(e.getSceneX() - parentBounds.getMinX());
        acw.line_.setEndY(e.getSceneY() - parentBounds.getMinY());
    }

```

```java
    public void endConnection(MouseEvent e, Circle outputCircle, AudioComponentWidgetBase acw) {
        Bounds VolumeBounds = outputCircle.localToScreen(outputCircle.getBoundsInLocal());
        double distance = Math.sqrt(Math.pow(VolumeBounds.getCenterX() - e.getScreenX(), 2.0) +
                Math.pow(VolumeBounds.getCenterY() - e.getScreenY(), 2.0));
        System.out.println("DEBUG: on endconnection, distance: " + distance);
        if (distance > 10) {
            //handle actual connection to speaker
            SpeakerWidget.SpeakerWidgets_.add(this);
        } else {
            parent.getChildren().remove(acw.line_);
            acw.line_ = null;
            SpeakerWidget.SpeakerWidgets_.remove(this);
        }
        System.out.println("Drawing the line");
    }

```

