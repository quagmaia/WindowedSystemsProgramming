import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.Stage;
import java.io.File;
import java.util.Optional;

import javafx.*;


public class Transcode extends GridPane {

	String sourceString;
	String targetString;
	double sliderValue;
	
	public Transcode(){
		
		//setGridLinesVisible(true);
		//put stuff in here
		TextField sourceText = new TextField();
		sourceText.setDisable(true);
		setHgrow(sourceText,Priority.ALWAYS);
		add(sourceText,0,0);
		
		Button sourceGetter = new Button("Get source");
		add(sourceGetter, 1, 0);
		TextField targetText = new TextField();
		targetText.setDisable(true);
		setHgrow(targetText,Priority.ALWAYS);
		add(targetText,0,1);
		
		TextArea ga = new TextArea();
		
		Button targetGetter = new Button("Get target");
		add(targetGetter, 1, 1);
		
		Slider slider = new Slider();
		slider.setMin(0);
		slider.setMax(9);
		slider.setShowTickLabels(true);
		setHgrow(slider,Priority.ALWAYS);
		add(slider,0,2,2,1);
		
		Button starter = new Button("Start");
		add(starter, 1, 3);
		
		ProgressBar bar = new ProgressBar();
		bar.setMaxWidth(Double.MAX_VALUE);
		add(bar,0,4);
		
		Button stepper = new Button("Step");
		stepper.setDisable(true);
		add(stepper, 1, 4);
		
		Pane filler = new Pane();
		setHgrow(filler, Priority.ALWAYS);
		setVgrow(filler, Priority.ALWAYS);
		add(filler, 0, 5);
		
		//add logic here
		
		sourceGetter.setOnAction(
			(event) -> {
				FileChooser chooser = new FileChooser();
				chooser.setTitle("Choose your source file.");
				File fs = chooser.showOpenDialog(getOwnerWindow());
				if (fs != null)
					sourceText.setText(fs.getAbsolutePath());
			}
		);
		
		targetGetter.setOnAction(
				(event) -> {
					FileChooser chooser = new FileChooser();
					chooser.setTitle("Choose your target file.");
					File fs = chooser.showOpenDialog(getOwnerWindow());
					if (fs != null)
						targetText.setText(fs.getAbsolutePath());
				}
			);
		
		starter.setOnAction(
				(event) -> {
					Boolean sourceOrTargetNotChosen = sourceText.getText().isEmpty() || targetText.getText().isEmpty();
					if (sourceOrTargetNotChosen){
						Alert a = new Alert(AlertType.ERROR, "Missing source or target!");
						a.showAndWait();
					} else {
						sourceString = sourceText.getText();
						targetString = targetText.getText();
						sliderValue = slider.getValue();
						bar.setProgress(0);
						stepper.setDisable(false);
						starter.setDisable(true);
					}
				}
			);
		
		stepper.setOnAction(
				(event) -> {
					double current = bar.getProgress();
					if (current < .99){
						bar.setProgress(current+=.1);
					}else{
						Alert a = new Alert(AlertType.INFORMATION, "Encoding complete!");
						a.showAndWait();
						bar.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
						stepper.setDisable(true);
						starter.setDisable(false);
					}
				}
			);
		
	
	}
	
	private Window getOwnerWindow(){ 
		Scene parentScene = this.getScene();
		if (parentScene != null){
			return parentScene.getWindow();
		}
		return null;
	}
}
