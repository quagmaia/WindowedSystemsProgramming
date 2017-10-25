import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;


public class Runner extends Application {

	GridPane pane = new GridPane();
	PointSource pointS = new PointSource();
	TextSource textS = new TextSource();
	SelectionSource selectionS = new SelectionSource();
	SubmissionLog log = new SubmissionLog();
	
	String currentSubmission = "";
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		stage.setTitle("Maia Ross");

		//
		// add fillers
		//
		
		Pane emptyLeft = new Pane();
		pane.add(emptyLeft,1,0);
		
		Pane emptyRight = new Pane();
		pane.add(emptyRight,3,0);
		
		Pane emptyBotton = new Pane();
		pane.add(emptyBotton,1,6);
		
		pane.setHgap(20);
		pane.setVgap(20);
		
		//
		// add widgets
		//
		
		GridPane.setHgrow(pointS,Priority.ALWAYS);
		pane.add(pointS,1,0);
		
		GridPane.setHgrow(textS,Priority.ALWAYS);
		pane.add(textS,1,2);
		
		GridPane.setHgrow(selectionS,Priority.ALWAYS);
		pane.add(selectionS,1,3);
		
		GridPane.setHgrow(log,Priority.ALWAYS);
		GridPane.setVgrow(log,Priority.ALWAYS);
		pane.add(log,1,4);
		
		//
		// handling
		//
		
		pointS.addBasicHandler(
				(String str) -> log.logSubmission(str)
			);
		
		textS.addBasicHandler(
				(String str) -> log.logSubmission(str)
			);
		
		selectionS.addBasicHandler(
				(String str) -> log.logSubmission(str)
			);
		
		//
		// staging
		//
		
		stage.setScene(new Scene(pane,800,800));
		stage.show();
		
	}


}
