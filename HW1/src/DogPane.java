import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class DogPane extends GridPane {
	private String output = "";
	private String tgaVal = "";
	private String tgbVal = "";
	
	public DogPane(){
		
		Region region = new Region();
		add(region,1,1);
		
		GridPane.setHgrow(region, Priority.ALWAYS);
		
		//column 1
		
		CheckBox checka = new CheckBox("Dogs are good");
		add(checka,0,0);
		
		ToggleGroup tga = new ToggleGroup();
		
		RadioButton ra1 = new RadioButton("ra1");
		add(ra1, 0, 1);
		ra1.setToggleGroup(tga);
		
		RadioButton ra2 = new RadioButton("ra2");
		add(ra2, 0, 2);
		ra2.setToggleGroup(tga);
		
		RadioButton ra3 = new RadioButton("ra3");
		add(ra3, 0, 3);
		ra3.setToggleGroup(tga);
		

		
		//column 2
		CheckBox checkb = new CheckBox("Dogs are really good");
		add(checkb,1,0);
		
		ToggleGroup tgb = new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("rb1");
		add(rb1, 1, 1);
		rb1.setToggleGroup(tgb);
		
		RadioButton rb2 = new RadioButton("rb2");
		add(rb2, 1, 2);
		rb2.setToggleGroup(tgb);
		
		RadioButton rb3 = new RadioButton("rb3");
		add(rb3, 1, 3);
		rb3.setToggleGroup(tgb);
		
		//column 3
		Button print = new Button("Print");
		add(print,2,1);
		print.setOnAction(
			(event) -> printEvent()
		);
		
		Button submit = new Button("Submit");
		add(submit,2,2);
		submit.setOnAction(
			(event) -> {
				Boolean aSelected = checka.selectedProperty().get();
				Boolean bSelected = checkb.selectedProperty().get();
				RadioButton aToggle = (RadioButton)tga.getSelectedToggle();
				RadioButton bToggle = (RadioButton)tgb.getSelectedToggle();
				submitEvent(aSelected, bSelected, aToggle, bToggle);
			}
		);
		
		//column 4
		Label easySpaceFiller = new Label();
		add(easySpaceFiller,3,0);
		
		
	}
	
	private void printEvent(){
		System.out.println(output);
	}
	
	private void submitEvent(Boolean aSelected, Boolean bSelected, RadioButton aToggle, RadioButton bToggle){
		if (aSelected){
			String selectedToggle = aToggle.getText();
			if (selectedToggle != null)
				output+= " " + selectedToggle;
		}
		if (bSelected){
			String selectedToggle = bToggle.getText();
			if (selectedToggle != null)
				output+= " " + selectedToggle;
		}
	}
}

