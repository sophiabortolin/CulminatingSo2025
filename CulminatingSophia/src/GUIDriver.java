import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;

public class GUIDriver extends Application {
	
	private boolean subButtonClicked = false;
	private Label menuLabel;
	private Label sizeLabel;
	private TextField sizeField;
	private Label treasureLabel;
	private TextField treasureField;
	private Button subButton;
	private Rectangle myRectangle;
	@Override
	
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub		
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10); // Horizontal gap
		gridPane.setVgap(10); // Vertical gap
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 
		
		Color backgroundColor = Color.LIGHTBLUE;
		BackgroundFill backgroundFill = newBackgroundFill(backgroundColor, CornerRadii.EMPTY,Insets.EMPTY);
		Background background = new Background(backgroundFill);
		gridPane.setBackground(background);
		
		menuLabel = new Label("Menu");
		sizeLabel = new Label("Size of Grid:");
		sizeField = new TextField();	
		treasureLabel = new Label("Amount of treasures:");
		treasureField = new TextField();	
		subButton = new Button("Submit");
		
		myRectangle  = new Rectangle(100,50,Color.WHITE);
		gridPane.add(myRectangle,0,20,2,1);
		
		gridPane.add(menuLabel,1,3);
		gridPane.add(sizeLabel, 0, 9); 
		gridPane.add(sizeField, 1, 9); 
	

		gridPane.add(treasureLabel, 0, 15); 
		gridPane.add(treasureField, 1, 15); 
		gridPane.add(subButton, 1, 16); 
	
		menuLabel.setFont(new Font("Ariel",50));
		treasureLabel.setFont(new Font("Ariel",15));
		sizeLabel.setFont(new Font("Ariel", 15));
		
		Scene scene = new Scene(gridPane, 600, 600); 
		stage.setScene(scene);
		stage.setTitle("GridPane Example");
		stage.show();
		
		 
		 subButton.setOnAction(e -> {
	            try {
	             	subButtonClicked = true;
		            checkAndHideElements();

	            } catch (NumberFormatException ex) {
	               
	                System.err.println("Invalid number format for treasures amount.");
	            }
	        });
		
		
	}
	 private BackgroundFill newBackgroundFill(Color backgroundColor, CornerRadii empty, Insets empty2) {
		// TODO Auto-generated method stub
		return null;
	}
	 private void checkAndHideElements() {
	      if (subButtonClicked) {
	          menuLabel.setVisible(false);
	          sizeLabel.setVisible(false);
	          sizeField.setVisible(false);
	          treasureLabel.setVisible(false);
	          treasureField.setVisible(false);
	          subButton.setVisible(false);
	          myRectangle.setVisible(false);
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
