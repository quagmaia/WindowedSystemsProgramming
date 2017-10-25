import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class SelectionSource extends HandledVBox {
	
	ToggleGroup group = new ToggleGroup();
	
	SelectionSource(){

		RadioButton one = new RadioButton("One");
		RadioButton two = new RadioButton("Two");
		RadioButton three = new RadioButton("Three");
		RadioButton four = new RadioButton("Four");
		
		one.setToggleGroup(group);
		two.setToggleGroup(group);
		three.setToggleGroup(group);
		four.setToggleGroup(group);
		
		Button submit = new Button("Submit");
		
		submit.setOnAction(
				(event) -> {
					String str = getSelection();
					for (BasicHandler bh : handlers) {
						bh.handle(str);
					}
				}
			);
		
		this.getChildren().addAll(one,two,three,four,submit);
	}
	
	public String getSelection(){
		String output = "Selected button:\t";
		try {
			String selected = group.getSelectedToggle().toString();
			if (selected.contains("One")){
				output += "One";
			} else if (selected.contains("Two")){
				output += "Two";
			} else if (selected.contains("Three")){
				output += "Three";
			} else if (selected.contains("Four")){
				output += "Four";
			} 
		} catch (java.lang.NullPointerException e){
			output += "Null";
		}
		return output;
	}
	
	
}
