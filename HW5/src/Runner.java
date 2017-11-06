import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;


public class Runner extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		stage.setTitle("Maia Ross");
		View view = new View();
		Controller controller = new Controller(view);
		
		stage.setScene(new Scene(view,300,200));
		stage.show();
		
	}


}
