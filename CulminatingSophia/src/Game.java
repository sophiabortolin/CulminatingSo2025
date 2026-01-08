import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application{
    @Override
    
    public void start(Stage stage) {
        GameMenuFX menu = new GameMenuFX(stage);
        menu.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}

