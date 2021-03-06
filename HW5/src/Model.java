import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;
import java.util.Vector;

import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class Model {
	
	private static final CopyOption StandardCopyOption = null;
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
			Path target = Paths.get(filepath);
			
			Download(webpage, target);
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
	
	public void Download(URL webpage, Path target) {
		DownloadThread dt = new DownloadThread(webpage, target);
		try {
			dt.start();
		}catch (Exception e) {
			String message = e.getMessage();
			reportFailure(message, e.getStackTrace().toString());
		}
		
		Status threadStatus = dt.getStatus();
		if (threadStatus == Status.SUCCESS) {
			reportSuccess();
		} else if (threadStatus == Status.FAILURE) {
			reportFailure(dt.getMessage(),null);
		}
	}
	
	/*public void Download(URL webpage, Path target) {
		Thread t = new Thread() {
			@Override
			public void run(){
				try{
					Thread.sleep(5000);
				} catch (Exception e) {
					//pass, fuck it
				}
				
				//lambda expressions can replace all that stuff up there. You're still making an anonymous class definitions which gets expanded into a real class definition by the compiler.
				Platform.runLater(
					() -> System.out.println("I am a lambda and the run completed!\n")
				);
			}
		};//anon thread class def
		t.start();
	}*/
	
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
