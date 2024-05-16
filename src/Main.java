import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;

// je voulais tester pour implimenter un tableau graphique
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("test");

        Button dummyButton = new Button("burp");

        StackPane layout = new StackPane();
        layout.getChildren().add(dummyButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

