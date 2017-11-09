import javafx.stage.*;
import javafx.scene.*;
import javafx.application.*;

public class CircleRunner extends Application {
    @Override
    public void start(Stage stage) {
        CircleMover cm = new CircleMover();

        Scene scene = new Scene(cm, 600, 600);

        stage.setScene(scene);

        stage.setTitle("Parapatetic Circles");
        stage.show();
    }
}