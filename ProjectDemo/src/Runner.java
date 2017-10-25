import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.*;

import javafx.*;

public class Runner extends Application {
	
	public static void main(String[] args){
		launch(args);
	}

	VBox pane = new VBox();
	
	@Override
	public void start(Stage stage) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter 'b <your button text>' to create new button, enter 'l <your label text>' to create new label.");
		
		String input = sc.next();

		if (input.contains("b")){
			String text = sc.nextLine();
			addButton(text);
		} else if (input.contains("l")){
			String text = sc.nextLine();
			addLabel(text);
		}
	
	
		stage.setScene(new Scene(pane,200,200));
		stage.show();
	

	}
	
	private void addButton(String text){
		Button b = new Button(text);
		pane.getChildren().add(b);
	}
	
	private void addLabel(String text){
		Label l = new Label(text);
		pane.getChildren().add(l);
	}

}
