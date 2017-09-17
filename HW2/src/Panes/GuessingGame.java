package Panes;
import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.*;

public class GuessingGame extends GridPane {
	
	//gosh dealing with properties like this is nasty
	private final StringProperty score = new SimpleStringProperty();
	
	public StringProperty scoreProperty(){ return score; }
	
	private final String getScore(){
		return scoreProperty().get();
	}
	
	private final void setScore(String score){
		scoreProperty().set(score);
	}
	
	private final StringProperty count = new SimpleStringProperty();
	
	public StringProperty countProperty(){ return count; }
	
	private final String getCount(){
		return countProperty().get();
	}
	
	private final void setCount(String count){
		countProperty().set(count);
	}
	
	public GuessingGame(){
		
		//ColumnConstraints column = new ColumnConstraints();
	    //column.setPercentWidth(10);
	    //column.setHalignment(HPos.RIGHT);
	    //getColumnConstraints().add(column);
		//setGridLinesVisible(true);
		
		setScore("0");
		setCount("0");
		
		//ToggleGroupPane tgp = new ToggleGroupPane();
		//add(tgp,0,0);
		ToggleGroup toggle = new ToggleGroup();
		
		RadioButton butta = new RadioButton("A");
		add(butta,0,0);
		butta.setToggleGroup(toggle);
		
		RadioButton buttb = new RadioButton("B");
		add(buttb,2,0);
		buttb.setToggleGroup(toggle);
		
		RadioButton buttc = new RadioButton("C");
		add(buttc,0,1);
		buttc.setToggleGroup(toggle);
		
		RadioButton buttd = new RadioButton("D");
		add(buttd,2,1);
		buttd.setToggleGroup(toggle);
		//
		//
		
		setHgap(10);
		
		Button guess = new Button("Guess");
		setHalignment(guess, HPos.RIGHT);
		add(guess,3,0);

		
		
		TextField result = new TextField();
		result.setEditable(false);
		result.textProperty().bind(Bindings.format("%s / %s", scoreProperty(),countProperty()));
		result.setMaxWidth(USE_PREF_SIZE);
		setHalignment(result, HPos.RIGHT);
		setHgrow(result,Priority.NEVER);
		add(result,3,1);
		
		guess.setOnAction((event) ->
		{
			Boolean isCorrect = calcCorrectness();
			if (isCorrect)
				incrementScore();
				incrementCount();
		});
		
		
		//time do do a really dumb thing just to fill out the center
		TextArea filler = new TextArea();
		filler.setVisible(false);
		filler.setPrefWidth(0.0);
		setHgrow(filler,Priority.ALWAYS);
		add(filler,2,3);
		
	}
	
	private Boolean calcCorrectness(){
		double random = Math.random();
		if (random < .25){
			return true;
		}
		return false;
	}
	
	private void incrementScore(){
		int iscore = Integer.parseInt(getScore());
		iscore++;
		setScore(Integer.toString(iscore));
	}
	
	private void incrementCount(){
		int icount = Integer.parseInt(getCount());
		icount++;
		setCount(Integer.toString(icount));
	}
}
