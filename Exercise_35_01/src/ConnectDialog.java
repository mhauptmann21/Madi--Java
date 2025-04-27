import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;


public class ConnectDialog {
    public void display(Stage parentStage, TextArea textArea, Consumer<Connection> onConnect) {
        Stage dialog = new Stage();
        dialog.initOwner(parentStage);


        TextField driverField = new TextField("com.mysql.cj.jdbc.Driver");
        TextField urlField = new TextField("jdbc:mysql://localhost:3306/ex35_01");
        TextField usernameField = new TextField("root");
        PasswordField passwordField = new PasswordField();


        Button connectBtn = new Button("Connect to DB");
        Button closeBtn = new Button("Close Dialog");


        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);


        pane.add(new Label("JDBC Driver:"), 0, 0);
        pane.add(driverField, 1, 0);
        pane.add(new Label("Database URL:"), 0, 1);
        pane.add(urlField, 1, 1);
        pane.add(new Label("Username:"), 0, 2);
        pane.add(usernameField, 1, 2);
        pane.add(new Label("Password:"), 0, 3);
        pane.add(passwordField, 1, 3);
        pane.add(connectBtn, 0, 4);
        pane.add(closeBtn, 1, 4);


        connectBtn.setOnAction(e -> {
            try {
                Class.forName(driverField.getText());
                Connection connection = DriverManager.getConnection(
                        urlField.getText(),
                        usernameField.getText(),
                        passwordField.getText()
                );
                textArea.appendText("Connected to database successfully\n");
                onConnect.accept(connection); // <--- set connection to parent
                dialog.close();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                textArea.appendText("Driver not found!\n");
            } catch (SQLException ex) {
                ex.printStackTrace();
                textArea.appendText("Connection failed!\n");
            }
        });


        closeBtn.setOnAction(e -> dialog.close());


        Scene scene = new Scene(pane);
        dialog.setTitle("Connect to DB");
        dialog.setScene(scene);
        dialog.show();
    }
}


