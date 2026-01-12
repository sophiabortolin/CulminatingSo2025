import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Controls game for the Treasure Hunt by building the grid UI, responding to clicks, and showing win/lose
 */

public class GameController {
	
	private GridPane gameGrid;
	private TreasureGrid treasureGrid;
	private int treasuresFound = 0;
	private int totalTreasures;
	private int bombsFound = 0;
	private int totalBombs = 4;
	private Label livesLabel;
	private Stage stage;

	/**
     * Starts a new game on the given stage
     * @param stage the stage to render into
     * @param size grid size (X by X)
     * @param treasureAmount number of treasures to place
     */
	
	public void startGame(Stage s, int size, int treasureAmount){
		// TODO Auto-generated method stub		
		
		stage = s;
		totalTreasures = treasureAmount;
		treasureGrid = new TreasureGrid(size, totalTreasures);
		
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: lightblue;");

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        createGameGrid(size);

        livesLabel = new Label("♥ ♥ ♥ ♥");
        livesLabel.setStyle("-fx-font-size: 26px; -fx-text-fill: red;");

        layout.getChildren().addAll(gameGrid, livesLabel);
        root.getChildren().add(layout);

        stage.setScene(new Scene(root, 600, 600));
		
	}

	/**
     * Creates the button grid for the game
     * @param size grid size (X by X)
     */
	 
	 private void createGameGrid(int size) {
		 gameGrid = new GridPane();
		 gameGrid.setHgap(10);
		 gameGrid.setVgap(10);
		 gameGrid.setAlignment(Pos.CENTER); // center

		    for (int row = 0; row < size; row++) {
		        for (int col = 0; col < size; col++) {
		            Button btn = new Button();
		            btn.setPrefSize(60, 60);

		            int r = row;
		            int c = col;

		            btn.setOnAction(e -> {
		            	if (treasureGrid.hasTreasure(r, c)) {
		                    btn.setText("💰");
		                    btn.setStyle("-fx-background-color: yellow;");
		                    treasuresFound++;
		                    
		                    if (treasuresFound == totalTreasures) {
		                        showWinScreen();
		                    }
		                } else if (treasureGrid.hasBomb(r,c)){
		                	btn.setText("💣");
		                	btn.setStyle("-fx-background-color: black;");
		                	bombsFound++;
		                	
		                	showLives(bombsFound);
		     
		                	
		                	if (bombsFound == totalBombs) {
		                		showLoseScreen();
		                	}
		                }
		             
		                else {
		                    btn.setText("🚫");
		                    btn.setStyle("-fx-background-color: lightgray;");
		                }

		                btn.setDisable(true);
		            });

		            gameGrid.add(btn, col, row);
		        }
		    }
	 }
	 
	 /**
	 * Show win screen
	 */
	 
	 private void showWinScreen() {
		    VBox winLayout = new VBox(20);
		    winLayout.setAlignment(Pos.CENTER);
		    winLayout.setStyle("-fx-background-color: lightgreen;");

		    Label winLabel = new Label("🎉 YOU WIN! 🎉");
		    winLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
		    winLabel.setTextFill(Color.DARKGREEN);

		    winLayout.getChildren().add(winLabel);

		    stage.setScene( new Scene(winLayout, 600, 600));

		}
	 
	 /**
	* Show lose screen
	*/
	 
	 private void showLoseScreen() {
		 VBox loseLayout = new VBox(20);
		 loseLayout.setAlignment(Pos.CENTER);
		 loseLayout.setStyle("-fx-background-color: pink;");

		    Label loseLabel = new Label("❌ YOU LOSE! ❌");
		    loseLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
		    loseLabel.setTextFill(Color.DARKRED);

		    loseLayout.getChildren().add(loseLabel);

		    stage.setScene(new Scene(loseLayout, 600, 600));
		   
	 }
	 
	 /**
	     * Updates the lives label based on bombs found
	     * @param bombsFound number of bombs found so far
	     */
	 
	 private void showLives(int numBombs) {
		 
		 if (numBombs == 1) {
			 livesLabel.setText("♥ ♥ ♥ ♡");
		 } else if (numBombs == 2) {
			 livesLabel.setText("♥ ♥ ♡ ♡");
		 } else if (numBombs == 3) {
			 livesLabel.setText("♥ ♡ ♡ ♡");
		 }
		 
	 }

}
