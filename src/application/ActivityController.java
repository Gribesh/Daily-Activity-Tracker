//Controller for Activity.fxml
package application;

import java.sql.Connection;
import java.sql.SQLException;
import JDBConnectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ActivityController {

    @FXML
    private TextField a_sleep;

    @FXML
    private TextField a_study;

    @FXML
    private TextField a_exercise;

    @FXML
    private TextField a_meals;

    @FXML
    private TextField a_water;
    
    @FXML
    private TextField sleep;

    @FXML
    private TextField study;

    @FXML
    private TextField exercise;

    @FXML
    private TextField meals;

    @FXML
    private TextField water;
    
    @FXML
    private Button upload;
    
    @FXML
    private Button update;
    
    @FXML
    void reset(ActionEvent event) {
    	a_sleep.clear();
    	a_study.clear();
    	a_exercise.clear();
    	a_meals.clear();
    	a_water.clear();
    }
    

    @FXML
    void survey_reset(ActionEvent event) {
    	sleep.clear();
    	study.clear();
    	exercise.clear();
    	meals.clear();
    	water.clear();
    }

    @FXML
    void update(ActionEvent event){
    	try {
	    	ConnectionClass connectionClass=new ConnectionClass();
			Connection connection=connectionClass.getConnection();
			Statement statement=connection.createStatement();
			String sql="UPDATE defined set hours='"+a_exercise.getText()+"' WHERE activity='excercise'";
			//String sql="INSERT INTO `user` VALUES (NULL,'"+a_sleep.getText()+"','"+rbutton.getText()+"','"+bdate.getValue()+"','"+email.getText()+"','"+upwd.getText()+"')";
			statement.executeUpdate(sql);
			sql="UPDATE defined set hours='"+a_meals.getText()+"' WHERE activity='meal'";
			statement.executeUpdate(sql);
			sql="UPDATE defined set hours='"+a_sleep.getText()+"' WHERE activity='sleep'";
			statement.executeUpdate(sql);
			sql="UPDATE defined set hours='"+a_study.getText()+"' WHERE activity='study'";
			statement.executeUpdate(sql);
			sql="UPDATE defined set hours='"+a_water.getText()+"' WHERE activity='water'";
			statement.executeUpdate(sql);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Update Data");
			alert.setHeaderText(null);
			alert.setContentText("Your activities has been set");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
			    // ... user chose OK
				Stage tmp=(Stage) update.getScene().getWindow();
				tmp.close();
			} else {
			    // ... user chose CANCEL or closed the dialog
			}
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Error"+e);
    	}
    }
    
    @FXML
    void upload(ActionEvent event) {
    	try {
    	ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		String sql="INSERT INTO `exercise` VALUES ('1', '"+dayOfWeek+"', '"+exercise.getText()+"')";
		statement.executeUpdate(sql);
		sql="INSERT INTO `meals` VALUES ('1', '"+dayOfWeek+"', '"+meals.getText()+"')";
		statement.executeUpdate(sql);
		sql="INSERT INTO `sleep` VALUES ('1', '"+dayOfWeek+"', '"+sleep.getText()+"')";
		statement.executeUpdate(sql);
		sql="INSERT INTO `study` VALUES ('1', '"+dayOfWeek+"', '"+study.getText()+"')";
		statement.executeUpdate(sql);
		sql="INSERT INTO `water` VALUES ('1', '"+dayOfWeek+"', '"+water.getText()+"')";
		statement.executeUpdate(sql);
		//Stage tmp=(Stage) upload.getScene().getWindow();
		//tmp.close();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Upload Data");
		alert.setHeaderText(null);
		alert.setContentText("Data Uploaded Successfully");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
		    // ... user chose OK
			Stage tmp=(Stage) upload.getScene().getWindow();
			tmp.close();
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Error"+e);
    	}
    }
}