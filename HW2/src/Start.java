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
		
		MaiaWidget maia = new MaiaWidget();
	
		primary.setScene(new Scene(maia, 400, 400)); 
		primary.show();
	}
}