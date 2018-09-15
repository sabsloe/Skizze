import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.animation.AnimationTimer;

/**
 * Hauptanwendung
 */

public class App extends Application {

    public void start(Stage stage)
    {
        Canvas canvas = new Canvas(400, 400);         // Zeichenfläche
        GraphicsContext gc = canvas.getGraphicsContext2D(); // Graphikkontext der Zeichenfläche

        Skizze skizze = new Skizze();     //Meine Zeichnung!

        StackPane root = new StackPane();    
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Meine Skizze");
        stage.show();
        skizze.setup(gc);  // Setup der Skizze aufrufen

        AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    skizze.draw(gc);
                }
            };
        timer.start();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
