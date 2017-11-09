import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AnimatedCircle extends Circle {
	
	private double firstX, firstY, secondX, secondY;
	
	public AnimatedCircle(double firstx, double firsty, double secondx, double secondy) {
		
		setVisible(false);
        setRadius(50.0);
        setFill(Color.RED);
        
		firstX = firstx;
		firstY = firsty;
		secondX = secondx;
		secondY = secondy;
		
		System.out.println(firstX + " " + firstY + " " + secondX + " " + secondY);
	}
	
	public void startAnimation() {
        Timeline tl = new Timeline();
        
        KeyFrame start = new KeyFrame(Duration.millis(0),
                                      new KeyValue(translateXProperty(), firstX),
                                      new KeyValue(translateYProperty(), firstY));

        KeyFrame end = new KeyFrame(Duration.millis(5000),
                                    new KeyValue(translateXProperty(), secondX),
                                    new KeyValue(translateYProperty(), secondY));
        tl.getKeyFrames().addAll(start, end);
        

        tl.setOnFinished(
            (ActionEvent ev) -> {
                setVisible(false);
            }
        );
            
        setVisible(true);
        tl.play();
        
	}

}
