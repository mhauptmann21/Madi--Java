
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSelecter extends Application{

    @Override
    public void start(Stage primaryStage) {
        //Create the text
        Text text = new Text("Show Colors");
        text.setFont(Font.font("Arial", 40));
        text.setFill(Color.color(1,0,0)); //Initial color (red)

        //Create sliders for RGBA
        Slider sliderRed = createSlider();
        Slider sliderGreen = createSlider();
        Slider sliderBlue = createSlider();
        Slider sliderOpacity = createSlider();

        //Create labels
        Label labelRed = new Label("Red");
        Label labelGreen = new Label("Green");
        Label labelBlue = new Label("Blue");
        Label labelOpacity = new Label("Opacity");

        //Layout for sliders
        GridPane sliderPane = new GridPane();
        sliderPane.setPadding(new Insets(10));
        sliderPane.setHgap(10);
        sliderPane.setVgap(10);

        sliderPane.add(labelRed, 0, 0);
        sliderPane.add(sliderRed,1,0);
        sliderPane.add(labelGreen,0,1);
        sliderPane.add(sliderGreen,1,1);
        sliderPane.add(labelBlue,0,2);
        sliderPane.add(sliderBlue,1,2);
        sliderPane.add(labelOpacity, 0, 3);
        sliderPane.add(sliderOpacity, 1, 3);

        //Add listener to sliders
        ChangeListener<Number> colorChangeListener = (observable, oldValue, newValue) -> {
            double red = sliderRed.getValue() / 100.0;
            double green = sliderGreen.getValue() / 100.0;
            double blue = sliderBlue.getValue() / 100.0;
            double opacity = sliderOpacity.getValue() / 100.0;
            text.setFill(Color.color(red,green,blue,opacity));
        };

        sliderRed.valueProperty().addListener(colorChangeListener);
        sliderGreen.valueProperty().addListener(colorChangeListener);
        sliderBlue.valueProperty().addListener(colorChangeListener);
        sliderOpacity.valueProperty().addListener(colorChangeListener);

        //Set up main layout
        BorderPane root = new BorderPane();
        root.setCenter(text);
        root.setBottom(sliderPane);
        BorderPane.setAlignment(text,Pos.CENTER);

        //Set up the scene and stage
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Text Color Adjuster");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Helper method to create a slider
    private Slider createSlider() {
        Slider slider = new Slider(0,100,100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(25);
        slider.setBlockIncrement(1);
        slider.setPrefWidth(300);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
