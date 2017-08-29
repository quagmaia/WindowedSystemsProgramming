import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class Start extends Application{
	 public static void main(String[] args) {
	        launch(args);
	    }
	
	@Override
	public void start(Stage primary){
		primary.setTitle("Window");
		
		GridPane root = new GridPane(); 
										
		Label foo = new Label("foo");
		root.add(foo, 0, 0);
		
		Region r = new Region();
		root.add(r,1,1);
		
		GridPane.setHgrow(r, Priority.ALWAYS);
		GridPane.setVgrow(r, Priority.ALWAYS);
		
		Button butt = new Button("clicky");
		root.add(butt,1,2);
		butt.setOnAction(
			event -> { System.out.println("clickoo"); }	
		);
	
		primary.setScene(new Scene(root, 400, 400)); 
		primary.show();
	}
}