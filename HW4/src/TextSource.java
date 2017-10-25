import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class TextSource extends HandledVBox {
	
	TextField field = new TextField();
	
	public TextSource(){
		Button submit = new Button("Submit");
		
		submit.setOnAction(
				(event) -> {
					String str = getText();
					for (BasicHandler bh : handlers) {
						bh.handle(str);
					}
				}
			);
		
		this.getChildren().addAll(field,submit);
	}
	
	public String getText(){
		return "User text:\t\t\t" + field.getText();
	}
}
