import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class GUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		//VBox root = new VBox(10);
		
		
		GridPane gridPane = new GridPane();
		
		gridPane.setHgap(10); // Horizontal gap
		gridPane.setVgap(10); // Vertical gap
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 
		
		Label menuLabel = new Label("Menu");
		Label sizeLabel = new Label("Size of Grid:");
		TextField sizeField = new TextField();	
		Button submitButton = new Button("Submit");

		Label treasureLabel = new Label("Amount of treasures:");
		TextField treasureField = new TextField();	
		Button subButton = new Button("Submit");
		
		gridPane.add(menuLabel,1,3);
		gridPane.add(sizeLabel, 0, 9); 
		gridPane.add(sizeField, 1, 9); 
		gridPane.add(submitButton, 1, 10); 

		gridPane.add(treasureLabel, 0, 15); 
		gridPane.add(treasureField, 1, 15); 
		gridPane.add(subButton, 1, 16); 
	
	//	GridPane.setColumnSpan(submitButton, 10); 
	//	GridPane.setColumnSpan(subButton, 5);
		menuLabel.setFont(new Font("Ariel",50));
		treasureLabel.setFont(new Font("Ariel",15));
		sizeLabel.setFont(new Font("Ariel", 15));
		
		Scene scene = new Scene(gridPane, 600, 600); 
		stage.setScene(scene);
		stage.setTitle("GridPane Example");
		stage.show();
		
		 submitButton.setOnAction(e -> {
	            try {
	              
	              
	            } catch (NumberFormatException ex) {
	               
	                System.err.println("Invalid number format for grid size.");
	            }
	        });
		 
		 subButton.setOnAction(e -> {
	            try {
	             	
	            } catch (NumberFormatException ex) {
	               
	                System.err.println("Invalid number format for treasures amount.");
	            }
	        });
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
