import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class SubmissionLog extends HandledVBox {
	
	TextArea area = new TextArea();
	
	public SubmissionLog(){
		
		area.setEditable(false);
		setVgrow(area, Priority.ALWAYS);
		
		getChildren().add(area);
	}
	
	public void logSubmission(String input){
		area.appendText(input + "\n");
	}
}
