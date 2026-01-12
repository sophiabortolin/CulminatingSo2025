import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application{
    @Override
    
    /**
     * Launches the main menu
     * @param stage JavaFX stage
     */
    
    public void start(Stage stage) {
        Menu menu = new Menu(stage);
        menu.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

