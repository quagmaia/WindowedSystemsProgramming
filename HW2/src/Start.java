import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Panes.MaiaWidget;
import javafx.*;

public class Start extends Application{
	 public static void main(String[] args) {
	        launch(args);
	    }
	
	@Override
	public void start(Stage primary){
		primary.setTitle("Maia Ross");
		
		MaiaWidget maia = new MaiaWidget();
		
		ColumnConstraints col = new ColumnConstraints();
		col.setPercentWidth(100);
		maia.getColumnConstraints().add(col);
	
		primary.setScene(new Scene(maia, 500, 200)); 
		primary.show();
	}
}