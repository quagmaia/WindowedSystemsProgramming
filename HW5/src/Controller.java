
public class Controller {
	
		public Controller(View view) {
			
			Model model = new Model();
			
			view.addHandler(
					(String str1, String str2) -> model.startDownload(str1, str2)
				);
			
			view.addHandler(
					() -> {
						String filepath = model.chooseFile();
						view.setFilepath(filepath);
					}
				);
			
		}
}
