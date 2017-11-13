import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Vector;

import javafx.application.Platform;

enum Status {
	PENDING, SUCCESS, FAILURE
}

public class DownloadThread extends Thread {
	private Status currStatus;
	private String message;
	private URL webpage;
	private Path target;
	
	public DownloadThread(URL webpage, Path target) {
		currStatus = Status.PENDING;
		message = "";
		this.webpage= webpage;
		this.target = target;
	}
	
	@Override
	public void run() {
		try (InputStream in = webpage.openStream()){
			synchronized(in) {
				Files.copy(in, target,StandardCopyOption.REPLACE_EXISTING);
			}
			currStatus = Status.SUCCESS;
			message = "Success!";
			System.out.println(message);
		}catch(Exception e) {
			currStatus = Status.FAILURE;
			message = e.getMessage();
		}
	}
	
	public Status getStatus() {
		return currStatus;
	}
	
	public String getMessage() {
		return message;
	}
	
}
