import javafx.scene.control.Alert.AlertType;

public class Controller {
	
		public Controller(View view) {
			
			Model model = new Model();
			
			view.addHandler(
					(String str1, String str2) -> {
						if (str1 != "" || str2 != "") {
							model.startDownload(str1, str2);
						} else {
							view.displayAlert(AlertType.ERROR,"One or more of your fields are missing text.");
						}
					}
				);
			
			view.addHandler(
					() -> {
						String filepath = model.chooseFile(view.getOwnerWindow());
						if (filepath != null) {
							view.setFilepath(filepath);
						}
					}
				);
			
			model.addHandler(
					(String str1, String str2) -> {
						view.displayAlert(AlertType.ERROR, "Following exception occured:" + str1);
					}
				);
			
		}
		
		
}
