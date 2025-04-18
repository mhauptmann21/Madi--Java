import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGridExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Load images (make sure the image files are in the correct path or use URLs)
        Image image1 = new Image("images/image1.jpg");
        Image image2 = new Image("images/image2.jpg");
        Image image3 = new Image("images/image3.jpg");
        Image image4 = new Image("images/image4.jpg");
        
        // Add images to grid pane
        gridPane.add(new ImageView(image1), 0, 0); // column 0, row 0
        gridPane.add(new ImageView(image2), 1, 0); // column 1, row 0
        gridPane.add(new ImageView(image3), 0, 1); // column 0, row 1
        gridPane.add(new ImageView(image4), 1, 1); // column 1, row 1

        // Create and show scene
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("4 Image Grid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


