import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class GameMenuFX {

    private Stage stage;
    private Pane root;

    private TextField sizeField;
    private TextField treasureField;
    private Label errorLabel;

    public GameMenuFX(Stage s) {
        stage = s;
        root = new Pane();
    }
    
    public void show() {
        showMenuScreen();
    }

    public void showMenuScreen() {
        root.getChildren().clear();

        Label title = new Label("Treasure Hunt");
        title.setLayoutX(230);
        title.setLayoutY(50);
        title.setStyle("-fx-font-size: 28px;");

        Label q1 = new Label("How many treasures do you want to find?");
        q1.setLayoutX(150);
        q1.setLayoutY(120);
        q1.setStyle("-fx-font-size: 15px;");

        Label q2 = new Label("How big do you want the grid to be?");
        q2.setLayoutX(170);
        q2.setLayoutY(150);
        q2.setStyle("-fx-font-size: 15px;");

        sizeField = new TextField();
        sizeField.setLayoutX(420);
        sizeField.setLayoutY(145);
        sizeField.setPrefWidth(60);

        treasureField = new TextField();
        treasureField.setLayoutX(420);
        treasureField.setLayoutY(115);
        treasureField.setPrefWidth(60);

        errorLabel = new Label();
        errorLabel.setLayoutX(200);
        errorLabel.setLayoutY(190);
        errorLabel.setStyle("-fx-text-fill: red;");

        Button playButton = new Button("Play");
        playButton.setStyle("-fx-font-weight: bold;");
        playButton.setLayoutX(270);
        playButton.setLayoutY(230);
        playButton.setMinSize(60, 40);
        playButton.setMaxSize(60, 40);
        playButton.setPrefSize(60, 40);
        playButton.setPadding(new Insets(10));
        playButton.setOnAction(e -> handlePlay());
       
        
        Button settingsButton = new Button("Settings");
        settingsButton.setLayoutX(10);
        settingsButton.setLayoutY(10);
        settingsButton.setOnAction(e -> showSettingsScreen());

        Button instructionsButton = new Button("Instructions");
        instructionsButton.setLayoutX(90);
        instructionsButton.setLayoutY(10);
        instructionsButton.setOnAction(e -> showInstructionsScreen());

        root.getChildren().addAll(title, q1, q2, sizeField, treasureField, playButton, errorLabel, settingsButton, instructionsButton);
        
        stage.setScene(new Scene(root, 600, 600));
        stage.setTitle("Treasure Hunt");
        
        stage.centerOnScreen();
        stage.setAlwaysOnTop(true);
        stage.show();
        stage.toFront();
        stage.requestFocus();
        stage.setAlwaysOnTop(false);
        stage.show();
    }

    private void handlePlay() {
        try {
            int size = Integer.parseInt(sizeField.getText());
            int treasures = Integer.parseInt(treasureField.getText());

            if (size < 4 || size > 8) {
                errorLabel.setText("Grid size must be between 4 and 8");
                return;
            }

            if (treasures < 1 || treasures > (size * size) / 2) {
                errorLabel.setText("Invalid treasure amount");
                return;
            }

            GUIDriver game = new GUIDriver();
            game.startGame(stage, size, treasures);

        } catch (NumberFormatException ex) {
            errorLabel.setText("Please enter valid numbers");
        }
    }

    private void showSettingsScreen() {
        root.getChildren().clear();

        Label title = new Label("Settings");
        title.setLayoutX(270);
        title.setLayoutY(50);
        title.setStyle("-fx-font-size: 22px;");

        Button blueBg = new Button("Blue Background");
        blueBg.setLayoutX(220);
        blueBg.setLayoutY(120);
        blueBg.setOnAction(e -> root.setStyle("-fx-background-color: lightblue;"));

        Button greenBg = new Button("Green Background");
        greenBg.setLayoutX(220);
        greenBg.setLayoutY(170);
        greenBg.setOnAction(e -> root.setStyle("-fx-background-color: lightgreen;"));

        Button whiteBg = new Button("White Background");
        whiteBg.setLayoutX(220);
        whiteBg.setLayoutY(220);
        whiteBg.setOnAction(e -> root.setStyle("-fx-background-color: white;"));

        Button backButton = new Button("Back");
        backButton.setLayoutX(10);
        backButton.setLayoutY(10);
        backButton.setOnAction(e -> showMenuScreen());

        root.getChildren().addAll(title, blueBg, greenBg, whiteBg, backButton);
    }

    private void showInstructionsScreen() {
        root.getChildren().clear();

        Label title = new Label("Instructions");
        title.setLayoutX(250);
        title.setLayoutY(50);
        title.setStyle("-fx-font-size: 22px;");

        Label instructions = new Label(
                "1. Enter grid size and treasure count\n" +
                "2. Click Play\n" +
                "3. Find all treasures\n" +
                "4. Avoid bombs (4 lives)"
        );
        instructions.setStyle("-fx-font-size: 16px;");
        instructions.setLayoutX(200);
        instructions.setLayoutY(120);

        Button backButton = new Button("Back");
        backButton.setLayoutX(10);
        backButton.setLayoutY(10);
        backButton.setOnAction(e -> showMenuScreen());

        root.getChildren().addAll(title, instructions, backButton);
    }
}
