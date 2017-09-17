import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.*;

public class MaiaWidget extends GridPane {
	public MaiaWidget(){
		
		Region region = new Region();
		add(region,1,1);
		
		setHgrow(region, Priority.ALWAYS);
		
		TabPane pane = new TabPane();
		add(pane,0,0);
		setHgrow(pane,Priority.ALWAYS);
		setVgrow(pane,Priority.ALWAYS);
		
		Tab numTab = new Tab();
		numTab.setText("Number Information");
		numTab.setContent(new NumInfo());
		pane.getTabs().add(numTab);
		
		Tab guessTab = new Tab();
		guessTab.setText("Guessing Game");
		guessTab.setContent(new GuessingGame());
		pane.getTabs().add(guessTab);
	}
}

