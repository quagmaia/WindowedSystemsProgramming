import java.util.Vector;
import javafx.scene.layout.VBox;

public class HandledVBox extends VBox {
	
	public Vector<BasicHandler> handlers = new Vector<BasicHandler>();
	
	public void addBasicHandler(BasicHandler bh){
		handlers.add(bh);
	}
}
