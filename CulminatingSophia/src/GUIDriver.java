import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox root = new VBox(10);
		
		GridPane gp = new GridPane();
		
		

		Rectangle bg = new Rectangle();
		
		bg.setX(0.0);  
        bg.setY(0.0);    
        bg.setWidth(500.0); 
        bg.setHeight(100.0);
        bg.setFill(Color.RED);
        root.setAlignment(Pos.CENTER);
        
        root.getChildren().add(bg);		
		
		Scene scene = new Scene(root, 600, 600, Color.WHITE);
		
		stage.setScene(scene);
		
		stage.show();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
