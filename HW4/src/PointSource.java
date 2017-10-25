import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class PointSource extends HandledVBox {
	
	Slider x = new Slider();
	Slider y = new Slider();
	Slider z = new Slider();
	
	public PointSource(){
		setSpacing(10);
		
		x.setShowTickLabels(true);
		
		y.setShowTickLabels(true);
		
		z.setShowTickLabels(true);
		
		Button submit = new Button("Submit");
		
		submit.setOnAction(
				(event) -> {
					String str = getPoint();
					for (BasicHandler bh : handlers) {
						bh.handle(str);
					}
				}
			);
		
		getChildren().addAll(x,y,z,submit);
	}
	
	public String getPoint(){
		String output = "Source point:\t\t";
		String xVal = Double.toString(x.getValue());
		String yVal = Double.toString(y.getValue());
		String zVal = Double.toString(z.getValue());
		output += xVal + ", " + yVal + ", " + zVal;
		return output;
	}
}
