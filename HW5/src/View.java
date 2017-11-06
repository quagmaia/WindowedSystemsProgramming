import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Vector;
import javafx.*;

public class View extends GridPane {
	
	public Vector<BasicHandler> handlers = new Vector<BasicHandler>();
	
	public void addBasicHandler(BasicHandler bh){
		handlers.add(bh);
	}
	
	public View () {
		
		TextField urlField = new TextField("URL Location");
		add(urlField, 0, 0);
		
		TextField fileField = new TextField("");
		add(fileField, 0, 1);
		
		Button selectFile = new Button("Select file");
		add(selectFile, 1, 1);
		
		Button startDownload = new Button("Start download");
		add(startDownload,0,2);
		
	}
		
}
