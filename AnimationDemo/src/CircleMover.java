import javafx.util.Duration;

import javafx.scene.paint.*;

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.control.*;

import javafx.scene.input.*;

import java.util.Stack;
import java.util.Vector;

import javafx.animation.*;

import javafx.event.ActionEvent;

import javafx.beans.binding.*;

/*
 * CHALLENGE:
 * 1.	Make it so that you can click arbitrarily many times and generate more circles
 * 2.	Put a blue square everywhere you click
 */

public class CircleMover extends Pane {
	
    private Vector<AnimatedCircle> circles = new Vector<AnimatedCircle>();
    
    private double initx, inity;
    
    States curState = States.INITIAL;
    //CircleMover should only go between Initial and Clicked.

    public CircleMover() {
        this.setOnMouseClicked(
            (MouseEvent event) -> handleClick(event)
        );

        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button sb = new Button("Start");
        
        sb.setOnAction(
        	(event) -> {
        		//go through all circles and animate each one
        		for (AnimatedCircle c : circles) {
        			this.getChildren().add(c);
        			System.out.print("Animating... ");
        			c.startAnimation();
        		}
        	}
        );
        
        this.getChildren().addAll(sb);
    }

    private void handleClick(MouseEvent me) {
    	System.out.println(curState);
    	switch (curState) {
	    	case INITIAL:
	    		initx = me.getX();
	    		inity = me.getY();
	    		curState = States.CLICKED;
	    		break;
	    	case CLICKED:
	    		circles.add(new AnimatedCircle(initx, inity, me.getX(), me.getY()));
	    		curState = States.INITIAL;
    	}
    	
    }
}
