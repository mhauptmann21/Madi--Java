import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.sql.*;


public class Ex34_1 extends Application{
   private Label labelStatus = new Label();
   private Label labelID = new Label("ID");
   private TextField txtID = new TextField();
   private Label labelLastName = new Label("Last Name");
   private TextField txtLastName = new TextField();
   private Label labelFirstName = new Label("First Name");
   private TextField txtFirstName = new TextField();
   private Label labelMI = new Label("MI");
   private TextField txtMI = new TextField();
   private Label labelAddress = new Label("Address");
   private TextField txtAddress = new TextField();
   private Label labelCity = new Label("City");
   private TextField txtCity = new TextField();
   private Label labelState = new Label("State");
   private TextField txtState = new TextField();
   private Label labelPhone = new Label("Phone Number");
   private TextField txtPhone = new TextField();
   private Label labelEmail = new Label("Email");
   private TextField txtEmail = new TextField();


   private Button btnView = new Button("View");
   private Button btnInsert = new Button("Insert");
   private Button btnUpdate = new Button("Update");
   private Button btnClear = new Button("Clear");

   private Statement stmt;


   @Override
   public void start(Stage primaryStage) throws Exception {
       HBox hbox1 = new HBox(5);
       hbox1.getChildren().addAll(labelID, txtID);
       HBox hbox2 = new HBox(5);
       hbox2.getChildren().addAll(labelLastName, txtLastName, labelFirstName, txtFirstName, labelMI, txtMI);
       HBox hbox3 = new HBox(5);
       hbox3.getChildren().addAll(labelAddress, txtAddress);
       HBox hbox4 = new HBox(5);
       hbox4.getChildren().addAll(labelCity, txtCity, labelState, txtState);
       HBox hbox5 = new HBox(5);
       hbox5.getChildren().addAll(labelPhone, txtPhone, labelEmail, txtEmail);


       VBox vbox = new VBox(5);
       vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5);


       HBox btnBox = new HBox(5);
       btnBox.getChildren().addAll(btnView, btnInsert, btnUpdate, btnClear);
       btnBox.setAlignment(Pos.CENTER);


       BorderPane pane = new BorderPane();
       pane.setTop(labelStatus);
       pane.setCenter(vbox);
       pane.setBottom(btnBox);


       Scene scene = new Scene(pane, 500, 200);
       primaryStage.setTitle("Exercise 34.1 - Staff");
       primaryStage.setScene(scene);
       primaryStage.show();

       initializeDB();

       btnView.setOnAction(e -> view());
       btnInsert.setOnAction(e -> insert());
       btnClear.setOnAction(e -> clear());
       btnUpdate.setOnAction(e -> update());

   }

    private void update() {
        String updateQuery = "UPDATE staff SET " +
            "', '" + txtLastName.getText().trim() +
            "', '" + txtFirstName.getText().trim() +
            "', '" + txtMI.getText().trim() +
            "', '" + txtAddress.getText().trim() +
            "', '" + txtCity.getText().trim() +
            "', '" + txtState.getText().trim() +
            "', '" + txtPhone.getText().trim() +
            "', '" + txtEmail.getText().trim() + "');";
        try {
            stmt.executeUpdate(updateQuery);
            labelStatus.setText("Record Updated");
        }
        catch (SQLException ex) {
            labelStatus.setText("Update Failed: " + ex);
            System.out.println("Update Failed: " + ex);
        }
    }

    private void clear() {
        txtID.setText(null);
        txtLastName.setText(null);
        txtFirstName.setText(null);
        txtMI.setText(null);
        txtAddress.setText(null);
        txtCity.setText(null);
        txtState.setText(null);
        txtPhone.setText(null);
        txtEmail.setText(null);
    }

    private void insert() {
        String insertQuery = "INSERT INTO staff (id, lastName, firstName, mi, address," +
            "city, state, telephone, email) VALUES ('" + txtID.getText().trim() +
            "', '" + txtLastName.getText().trim() +
            "', '" + txtFirstName.getText().trim() +
            "', '" + txtMI.getText().trim() +
            "', '" + txtAddress.getText().trim() +
            "', '" + txtCity.getText().trim() +
            "', '" + txtState.getText().trim() +
            "', '" + txtPhone.getText().trim() +
            "', '" + txtEmail.getText().trim() + "');";
        try {
            stmt.executeUpdate(insertQuery);
            labelStatus.setText("Inserted Record Successfully.");
            System.out.println("Insert succeeded");
        }
        catch (SQLException ex) {
            labelStatus.setText("Insert Failed: " + ex);
            System.out.println("Insert Failed: " + ex);
        }
    }

    private void view() {
        String query = "SELECT* FROM staff WHERE id = '" + txtID.getText().trim() +"'";
        try {
            ResultSet rs = stmt.executeQuery(query);
            loadFields(rs);
        }
        catch(SQLException ex) {
            labelStatus.setText("Query Failed");
            System.out.println("Captain, there is a problem with the query" + ex);
        }
    }

    private void loadFields(ResultSet rs) throws SQLException{
        if (rs.next()) {
            txtLastName.setText(rs.getString(2));
            txtFirstName.setText(rs.getString(3));
            txtMI.setText(rs.getString(4));
            txtAddress.setText(rs.getString(5));
            txtCity.setText(rs.getString(6));
            txtState.setText(rs.getString(7));
            txtPhone.setText(rs.getString(8));
            txtEmail.setText(rs.getString(9));
            labelStatus.setText("Record Found");
        }
        else {
            txtLastName.setText("");
            txtFirstName.setText("");
            txtMI.setText("");
            txtCity.setText("");
            txtState.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
            labelStatus.setText("Record NOT Found");
        }
        
    }

    private void initializeDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex34_01","root","");
            System.out.println("Database connected");
            labelStatus.setText("Database connected");
            stmt = connection.createStatement();
        }
        catch(Exception ex) {
            System.out.println("Something is wrong with the database. HELP!!!!" + ex);
            labelStatus.setText("Database Connection Failed. Is your VPN active?");
        }
    }

    public static void main(String[] args){
        launch(args);                                         
    }
}
