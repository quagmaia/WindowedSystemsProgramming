package FromClassNotes;
import javafx.util.Duration;

import javafx.scene.paint.*;

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.control.*;

import javafx.scene.input.*;

import javafx.animation.*;

import javafx.event.ActionEvent;

import javafx.beans.binding.*;


public class CircleMover extends Pane {
	
    private enum States {
        INITIAL, CLICKED, ANIMATING;
    }

    private States curState = States.INITIAL;

    private double firstX, firstY, secondX, secondY;

    private Circle animCircle;

    public CircleMover() {
        this.setOnMouseClicked(
            (MouseEvent event) -> handleClick(event)
        );

        this.animCircle = new Circle();
        animCircle.setVisible(false);
        animCircle.setRadius(50.0);
        animCircle.setFill(Color.RED);
        this.getChildren().add(animCircle);

        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //ensures that the circle widget takes up the entire avaliable window

        /*
       // this is written by bolding!!!!
        
        Button sb = new Button("Start");
        sb.translateXProperty().bind(Bindings.subtract(this.widthProperty(), Bindings.add(sb.widthProperty(), 15)));
        sb.translateYProperty().bind(Bindings.subtract(this.heightProperty(), Bindings.add(sb.heightProperty(), 15)));
        this.getChildren().add(sb);
        */
    }

    private void handleClick(MouseEvent me) {
        System.out.println(curState);

        if (curState == States.INITIAL) {
            firstX = me.getX();
            firstY = me.getY();

            curState = States.CLICKED;
        } else if (curState == States.CLICKED) {
            secondX = me.getX();
            secondY = me.getY();

            curState = States.ANIMATING;

            startAnimation();
        }
        // ignore clicks during animation
    }

    private void startAnimation() {
        Timeline tl = new Timeline();
        
        //getting the x position (translateXProperty) as an argument and associating it with firstX, repeat with Y
        KeyFrame start = new KeyFrame(Duration.millis(0),
                                      new KeyValue(animCircle.translateXProperty(), firstX),
                                      new KeyValue(animCircle.translateYProperty(), firstY));
        //at the 5th second, the properties should be at the second X and Y
        KeyFrame end = new KeyFrame(Duration.millis(5000),
                                    new KeyValue(animCircle.translateXProperty(), secondX),
                                    new KeyValue(animCircle.translateYProperty(), secondY));
        
       /* also valid. you don't need to include many values
        *  KeyFrame middle = new KeyFrame(Duration.millis(2000),
        *							new KeyValue(animCircle.translateXProperty(), 0.0));
        */
        
       KeyFrame middle = new KeyFrame(Duration.millis(2000),
        							new KeyValue(animCircle.translateXProperty(), 0.0),
        							new KeyValue(animCircle.translateYProperty(), 0.0));
        
        //now adding to the animation. parts between keyframes get filled in 
        tl.getKeyFrames().addAll(start, end, middle);
        
        //you could declare those two keyframes in different orders and it wouldn't matter. 
        //it's Duration.millis() that determines when it happens in the animation.

        tl.setOnFinished(
            (ActionEvent ev) -> {
            	//init the circle and make it invisible
                curState = States.INITIAL;
                animCircle.setVisible(false);
            }
        );

        //make circle visible and start playing the animation
        animCircle.setVisible(true);
        tl.play();
    }
}
