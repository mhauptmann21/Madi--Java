
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MouseClickedColor extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Create a pane
        Pane pane = new Pane();

        //Create a circle
        Circle circle = new Circle(200,200,80); //centerX, centerY, radius
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        //Add mouse event handlers
        circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        //Add Circle to pane
        pane.getChildren().add(circle);

        //Set up the scene and stage
        Scene scene = new Scene(pane, 400, 400, Color.GRAY);
        primaryStage.setTitle("Circle Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
