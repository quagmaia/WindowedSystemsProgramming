import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Vector;
import javafx.*;

public class View extends GridPane {

	public Vector<BasicHandler> bHandlers = new Vector<BasicHandler>();
	public Vector<StringHandler> sHandlers = new Vector<StringHandler>();

	public void addHandler(BasicHandler bh) {
		bHandlers.add(bh);
	}

	public void addHandler(StringHandler sh) {
		sHandlers.add(sh);
	}

	TextField fileField = new TextField("");
	TextField urlField = new TextField("URL Location");
	Button selectFile = new Button("Select file");
	Button startDownload = new Button("Start download");

	public View() {

		add(urlField, 0, 0);

		fileField.setEditable(false);
		add(fileField, 0, 1);

		add(selectFile, 1, 1);

		add(startDownload, 0, 2);

		selectFile.setOnAction((event) -> {
			for (BasicHandler bh : bHandlers) {
				bh.handle();
			}
		});

		startDownload.setOnAction((event) -> {
			String url = urlField.getText();
			String filepath = fileField.getText();
			for (StringHandler sh : sHandlers) {
				sh.handle(url, filepath);
			}

		});

	}
	
	public void setFilepath(String str) {
		fileField.setText(str);
	}
	
	public Window getOwnerWindow(){ 
		Scene parentScene = this.getScene();
		if (parentScene != null){
			return parentScene.getWindow();
		}
		return null;
	}
	
	public void displayAlert(AlertType type, String message) {
		Alert a = new Alert(type, message);
		a.showAndWait();
	}

}
