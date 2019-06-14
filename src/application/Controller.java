//Controller for the application.Progress.fxml/ 
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ResourceBundle;
import JDBConnectivity.ConnectionClass;


public class Controller implements Initializable {

    @FXML
    private CategoryAxis exercisex;

    @FXML
    private NumberAxis exerxisey;
    
    @FXML
    private CategoryAxis mealsy;

    @FXML
    private NumberAxis mealsx;
    
    @FXML
    private CategoryAxis sleepx;

    @FXML
    private NumberAxis sleepy;
    
    @FXML
    private CategoryAxis studyy;

    @FXML
    private NumberAxis studyx;
    
    @FXML
    private CategoryAxis waterx;

    @FXML
    private NumberAxis watery;
    

    
    @FXML
    private BarChart<String, Double> barChart;
    
    @FXML
    private BarChart<String, Double> mealChart;
    
    @FXML
    private BarChart<String, Double> studyChart;
    
    @FXML
    private BarChart<String, Double> sleepChart;
    
    @FXML
    private BarChart<String, Double> waterChart;
    
    @FXML
    void meal(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Progress/Meals.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);
		Stage.show();
    }

    @FXML
    void exercise(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Progress/Exercise.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);	
		Stage.show();
    }

    @FXML
    void sleep(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Progress/Sleep.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);	
		Stage.show();

    }
    
    @FXML
    void study(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Progress/Study.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);	
		Stage.show();
    }
    
    @FXML
    void water(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Progress/Water.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);	
		Stage.show();
    }
    
    @FXML
    void index(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/index.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);	
		Stage.show();
    }
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    	//loadexercise(); 	
    }
    @FXML
    void loadexercise(ActionEvent event) {
    	try{
    	XYChart.Series<String,Double> series=new XYChart.Series<>();
		ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();		
		String sql = "SELECT * FROM exercise";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(2)+"  "+ rs.getDouble(3));
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(3)));
		}
		
		barChart.getData().add(series);
		
		//mealChart.getData().add(series); 
		
    	}
    	catch(SQLException e){
    		System.out.println("Error:"+e);
    	}
    }
    
    @FXML
    void loadmeals(ActionEvent event) {
    	try{
    	XYChart.Series<String,Double> series=new XYChart.Series<>();
		ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();		
		String sql = "SELECT * FROM meals";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(2)+"  "+ rs.getDouble(3));
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(3)));
		}
		
		mealChart.getData().add(series);
		
		//mealChart.getData().add(series); 
		
    	}
    	catch(SQLException e){
    		System.out.println("Error:"+e);
    	}
    }
    
    @FXML
    void loadsleep(ActionEvent event) {
    	try{
    	XYChart.Series<String,Double> series=new XYChart.Series<>();
		ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();		
		String sql = "SELECT * FROM meals";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(2)+"  "+ rs.getDouble(3));
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(3)));
		}
		
		sleepChart.getData().add(series);
		
		//mealChart.getData().add(series); 
		
    	}
    	catch(SQLException e){
    		System.out.println("Error:"+e);
    	}
    }
    
    @FXML
    void loadstudy(ActionEvent event) {
    	try{
    	XYChart.Series<String,Double> series=new XYChart.Series<>();
		ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();		
		String sql = "SELECT * FROM meals";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(2)+"  "+ rs.getDouble(3));
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(3)));
		}
		
		studyChart.getData().add(series);
		
		//mealChart.getData().add(series); 
		
    	}
    	catch(SQLException e){
    		System.out.println("Error:"+e);
    	}
    }
    
    @FXML
    void loadwater(ActionEvent event) {
    	try{
    	XYChart.Series<String,Double> series=new XYChart.Series<>();
		ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();		
		String sql = "SELECT * FROM meals";
		ResultSet rs=statement.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(2)+"  "+ rs.getDouble(3));
			series.getData().add(new XYChart.Data<>(rs.getString(2),rs.getDouble(3)));
		}
		
		waterChart.getData().add(series);
		
		//mealChart.getData().add(series); 
		
    	}
    	catch(SQLException e){
    		System.out.println("Error:"+e);
    	}
    }
    
    @FXML
    private MenuItem home;

    @FXML
    private MenuItem addactivity;

    @FXML
    private MenuItem survey;

    @FXML
    private MenuItem logout;
    
    @FXML
    private MenuButton myMenu;
    
    @FXML
    void addactivity(ActionEvent event) throws IOException{
    	Stage Stage= new Stage();
    	//Stage tmp=(Stage) logout.getScene().getWindow();
    	//Stage tmp = (Stage) myMenu.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Activity.fxml"));
		Scene scrn = new Scene(root,698,510);
		Stage.setScene(scrn);
		//tmp.close();
		Stage.show();
    }

    @FXML
    void home(ActionEvent event) throws IOException{
    	Stage Stage= new Stage();
    	//Stage tmp=(Stage) logout.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/index.fxml"));
		Scene scrn = new Scene(root,698,510);
		Stage.setScene(scrn);	
		Stage.show();

    }
    
    @FXML
    void logout(ActionEvent event) throws IOException {
    	Stage Stage= new Stage();
    	//Stage tmp=(Stage) logout.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
		Scene scrn = new Scene(root,350,410);
		Stage.setScene(scrn);	
		Stage.show();

    }
    
    @FXML
    void survey(ActionEvent event) throws IOException {
    	Stage Stage= new Stage();
    	//Stage tmp=(Stage) logout.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/survey.fxml"));
		Scene scrn = new Scene(root,698,510);
		Stage.setScene(scrn);	
		Stage.show();

    }
    
    @FXML
    private AnchorPane excercisebkg;
    
    @FXML
    private Button tableview;

    @FXML
    void tableview(ActionEvent event) throws IOException {
    	
    	try {
    	Stage stage = (Stage) tableview.getScene().getWindow();
        AnchorPane root;
        root = (AnchorPane) FXMLLoader.load(getClass().getResource("/application/Progress/ExcerciseTableView.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
    	}
    	catch(Exception e) {
    		System.out.println("Error"+e);
    	}
    }


}
