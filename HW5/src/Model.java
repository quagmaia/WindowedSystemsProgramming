import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.util.Vector;

import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Model {
	
	public Vector<BasicHandler> bHandlers = new Vector<BasicHandler>();
	public Vector<StringHandler> sHandlers = new Vector<StringHandler>();

	public void addHandler(StringHandler sh) {
		sHandlers.add(sh);
	}
	public void addHandler(BasicHandler bh) {
		bHandlers.add(bh);
	}
	
	public Model() {}
	
	public void startDownload(String url, String filepath) {
		try {
			URL webpage = new URL(url);
			Download();
		}catch(Exception e){
			reportFailure(e.getMessage(),e.getStackTrace().toString());
		}
	}
	
	public String chooseFile(Window ownerWindow) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Choose a file");
		File fs = chooser.showOpenDialog(ownerWindow);
		if (fs != null) {
			return fs.getAbsolutePath();
		}
		return null;
	}
	
	public void Download() {
		try {
			//initiate download
		}catch(Exception e) {
			reportFailure(e.getMessage(),e.getStackTrace().toString());
		}
	}
	
	private void reportSuccess() {
		for (BasicHandler bh : bHandlers) {
			bh.handle();
		}
	}
	
	private void reportFailure(String message, String stacktrace) {
		for (StringHandler sh : sHandlers) {
			sh.handle(message,stacktrace);
		}
	}
	
	
}
