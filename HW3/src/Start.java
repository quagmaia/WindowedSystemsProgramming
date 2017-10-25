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
	public void start(Stage stage){
		stage.setTitle("Maia Ross");
		GridPane pane = new GridPane();
		
		//pane.setGridLinesVisible(true);
		
		//just gonna add the outer bit here
		TabPane tabs = new TabPane();
		pane.setHgrow(tabs,Priority.ALWAYS);
		pane.setVgrow(tabs,Priority.ALWAYS);
		pane.add(tabs, 0, 0, 2, 2);

		Pane filler = new Pane();
		pane.setHgrow(filler, Priority.ALWAYS);
		pane.setVgrow(filler, Priority.ALWAYS);
		pane.add(filler, 0, 2);
		Button add = new Button("Add Transcode");
		pane.add(add, 1, 5);
		
		Tab first = new Tab("Transcode");
		first.setContent(new Transcode());
		tabs.getTabs().add(first);
		
		add.setOnAction(
				(event) -> {
					Tab t = new Tab("New Transcode");
					t.setContent(new Transcode());;
					tabs.getTabs().add(t);
				}
		);
		
		
		stage.setScene(new Scene(pane,900,400));
		stage.show();
	}

}
