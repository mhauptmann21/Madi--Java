import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BatchUpdateDemo extends Application {
    private Connection conn;
    private TextArea textArea = new TextArea();


    @Override
    public void start(Stage primaryStage) {
    Button connectBtn = new Button("Connect to Database");
    Button batchBtn = new Button("Batch Update");
    Button nonBatchBtn = new Button("Non-Batch Update");


    connectBtn.setOnAction(e -> {
        ConnectDialog dialog = new ConnectDialog();
        dialog.display(primaryStage, textArea, connection -> this.conn = connection);
    });


    batchBtn.setOnAction(e -> batchUpdate());
    nonBatchBtn.setOnAction(e -> nonBatchUpdate());


    VBox pane = new VBox(10, connectBtn, batchBtn, nonBatchBtn, textArea);
    Scene scene = new Scene(pane, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Exercise35_01");
    primaryStage.show();
}



    private void batchUpdate() {
        if (conn == null) {
            textArea.appendText("Not connected to database\n");
            return;
        }


        try {
            long startTime = System.currentTimeMillis();
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)");


            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, Math.random() * 100);
                pstmt.setDouble(2, Math.random() * 100);
                pstmt.setDouble(3, Math.random() * 100);
                pstmt.addBatch();
            }


            pstmt.executeBatch();
            conn.commit();
            long endTime = System.currentTimeMillis();
            textArea.appendText("Batch update completed\nElapsed time: " + (endTime - startTime) + " ms\n\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private void nonBatchUpdate() {
        if (conn == null) {
            textArea.appendText("Not connected to database\n");
            return;
        }


        try {
            long startTime = System.currentTimeMillis();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)");


            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, Math.random() * 100);
                pstmt.setDouble(2, Math.random() * 100);
                pstmt.setDouble(3, Math.random() * 100);
                pstmt.executeUpdate();
            }


            long endTime = System.currentTimeMillis();
            textArea.appendText("Non-Batch update completed\nElapsed time: " + (endTime - startTime) + " ms\n\n");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

