
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import JDBConnectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.sql.Statement;
import java.util.ResourceBundle;


public class MainController implements Initializable{

	@FXML
	private Button button;
	
	@FXML
	private Label label;
	
	@FXML
    private TextField name;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button index;

    @FXML
    private Button register;
    
    @FXML
    private Label verify;
    
    @FXML
    private PasswordField upwd;

    @FXML
    private TextField uname;

    @FXML
    private TextField email;

    @FXML
    private DatePicker bdate;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;
   
    @FXML
    private Label disp;
    
    @FXML
    private Button logout;
    
    @FXML
    private Button login;
    
    @FXML
    private ProgressBar progressbar;
    
    @FXML
    private Button recovery;
    
    @FXML
    private Hyperlink loginhyp;
    
    @Override
    public void initialize(URL url,ResourceBundle rb) {
    	
    }    
	
    Stage currentStage;
    
    @FXML
    void index(ActionEvent event) throws IOException,SQLException {
    	try{
    	String username=name.getText().trim();
    	String password=pwd.getText().trim();
    	ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();
    	String sql="SELECT name,pswrd from user where name='"+username+"' and pswrd='"+password+"'";
    	ResultSet rs=statement.executeQuery(sql);
    	int count=0;
    	while(rs.next()) {
    		count=count+1;
    	}
    	if(count==1)
    	{
    		System.out.println("User Found");
    		verify.setText(" ");
        	Stage indexStage= new Stage();
        	Stage tmp=(Stage) index.getScene().getWindow();
    		Parent indexroot = FXMLLoader.load(getClass().getResource("/application/index.fxml"));
    		Scene indexscene = new Scene(indexroot,870,380);
    		indexStage.setScene(indexscene);
    		currentStage=indexStage;
    		tmp.close();
    		indexStage.show();
    	}
    	else if(count>1)
    	{
    		System.out.println("Duplicate User");
    		verify.setText("Duplicate User");
    	}
    	else {
    		System.out.println("User Not Found");
    		verify.setText("Invalid Login Details.");
    	}
    	/*if(name.getText().equals("admin") &&  pwd.getText().equals("admin")) {
    	verify.setText(" ");
    	//dispname.setText("Hello");
    	//Platform.exit();
    	Stage indexStage= new Stage();
		Parent indexroot = FXMLLoader.load(getClass().getResource("/application/index.fxml"));
		Scene indexscene = new Scene(indexroot,635,376);
		indexStage.setScene(indexscene);
		indexStage.show();
		//primaryStage.close();
		if(currentStage != null) {
			currentStage.close();
			currentStage = indexStage;
		}
    	}
    	else {
    		verify.setText("Invalid Login Details");
    	}*/
    	}
        catch(Exception e)
        {
        	System.out.println("Error"+e);
        }
    }

	
	@FXML
	public void register(ActionEvent event) throws IOException,SQLException{
		Stage regStage= new Stage();
		Stage tmp=(Stage) register.getScene().getWindow();
		Parent regroot = FXMLLoader.load(getClass().getResource("/application/register.fxml"));
		Scene regscene = new Scene(regroot,400,500);
		regStage.setScene(regscene);
		tmp.close();
		regStage.show();		
	}
	@FXML
	public void login(ActionEvent event) throws IOException{
		Stage logStage= new Stage();
		Stage tmp=(Stage) login.getScene().getWindow();
		Parent logroot = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
		Scene logscrn = new Scene(logroot,335,410);
		logStage.setScene(logscrn);
		//a.regStage.close();
		tmp.close();
		logStage.show();
		currentStage = logStage;
	}
	@FXML
	public void loginhyp(ActionEvent event) throws IOException{
		Stage logStage= new Stage();
		Stage tmp=(Stage) loginhyp.getScene().getWindow();
		Parent logroot = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
		Scene logscrn = new Scene(logroot,335,410);
		logStage.setScene(logscrn);
		tmp.close();
		logStage.show();
	}
	
	 @FXML
	    void logout(ActionEvent event) throws IOException{
		 Stage logStage= new Stage();
		 Stage tmp=(Stage) logout.getScene().getWindow();
			Parent logroot = FXMLLoader.load(getClass().getResource("/application/main.fxml"));
			Scene logscrn = new Scene(logroot,335,410);
			logStage.setScene(logscrn);
			//a.regStage.close();	
			tmp.close();
			logStage.show();
	    }
	
	@FXML
    void signin(ActionEvent event) throws SQLException,Exception{
		ConnectionClass connectionClass=new ConnectionClass();
		Connection connection=connectionClass.getConnection();
		Statement statement=connection.createStatement();
		//String sql="SELECT uid FROM USER";
		//ResultSet resultSet=statement.executeQuery(sql);
		/*while(resultSet.next()) {
			dispname.setText(resultSet.getString(1));
			resultSet.getString(1)+1
		}*/
		
		RadioButton rbutton = (RadioButton) gender.getSelectedToggle();
		String sql="INSERT INTO `user` VALUES (NULL,'"+uname.getText()+"','"+rbutton.getText()+"','"+bdate.getValue()+"','"+email.getText()+"','"+upwd.getText()+"')";
		//String sql="INSERT INTO user VALUES('NULL','"+uname.getText()+"','"+rbutton.getText()+"','"+bdate.getValue()+"','"+email.getText()+"','"+upwd.getText()+"')";
		statement.executeUpdate(sql);
		Stage logStage= new Stage();
		Parent logroot = FXMLLoader.load(getClass().getResource("/application/signin.fxml"));
		Scene logscrn = new Scene(logroot,600,400);
		logStage.setScene(logscrn);
		//a.regStage.close();
		
		logStage.show();
		currentStage = logStage;
		
    }
	
	@FXML
    void recovery(ActionEvent event) throws IOException {
		Stage actStage= new Stage();
		Stage tmp=(Stage) recovery.getScene().getWindow();
		Parent actroot = FXMLLoader.load(getClass().getResource("/application/recovery.fxml"));
		Scene actscrn = new Scene(actroot,698,505);
		actStage.setScene(actscrn);
		tmp.close();
		actStage.show();
    }
	@FXML
    private TextField find_email;

    @FXML
    private Label find;

    @FXML
    void find_ac(ActionEvent event) throws IOException {
    	try{
        	String rec_email=find_email.getText().trim();
        	ConnectionClass connectionClass=new ConnectionClass();
    		Connection connection=connectionClass.getConnection();
    		Statement statement=connection.createStatement();
        	String sql="SELECT email from user where email='"+rec_email+"'";
        	ResultSet rs=statement.executeQuery(sql);
        	int count=0;
        	while(rs.next()) {
        		count=count+1;
        	}
        	sql="SELECT pswrd from user where email='"+rec_email+"'";
        	rs=statement.executeQuery(sql);
        	String pass = null;
        	while(rs.next()) {
        		pass=rs.getString(1);
        	}
        	if(count==1)
        	{
        		System.out.println("Email Address Found");
        		find.setTextFill(Color.web("#00FF00"));
        		find.setText("Email Address  Found.\n Your password is "+pass);
        	}
        	else if(count>1)
        	{
        		System.out.println("Duplicate email address");
        		find.setTextFill(Color.web("#FF0000"));
        		find.setText("Duplicate email address");
        	}
        	else {
        		System.out.println("User Not Found");
        		find.setTextFill(Color.web("#FF0000"));
        		find.setText("User doenot exists");
        	}
    	}
        	catch(Exception e)
        	{
        		System.out.println("Error"+e);
        	}
    	
    }

	
    @FXML
    void activity(ActionEvent event) throws IOException{
		Stage actStage= new Stage();
		Parent actroot = FXMLLoader.load(getClass().getResource("/application/Activity.fxml"));
		Scene actscrn = new Scene(actroot,698,505);
		actStage.setScene(actscrn);
		//a.regStage.close();	
		actStage.show();
		/*if(currentStage != null) {
			currentStage.close();
			currentStage = actStage;
		}
		*/
    }
    @FXML
    void progress(ActionEvent event) throws IOException{
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Progress/Exercise.fxml"));
		Scene scrn = new Scene(root,655,610);
		Stage.setScene(scrn);	
		Stage.show();
    }

    @FXML
    void survey(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Survey.fxml"));
		Scene scrn = new Scene(root,698,510);
		Stage.setScene(scrn);	
		Stage.show();
    }
    

    @FXML
    void report(ActionEvent event) throws IOException {
		Stage Stage= new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Report.fxml"));
		Scene scrn = new Scene(root,745,610);
		Stage.setScene(scrn);
		Stage.show();
    }
    
    @FXML
    private Label udsleep;

    @FXML
    private Label avgsleep;

    @FXML
    private Label inssleep;
    
    @FXML
    private Label udmeal;

    @FXML
    private Label avgmeal;

    @FXML
    private Label insmeal;

    @FXML
    private Label udstudy;

    @FXML
    private Label avgstudy;

    @FXML
    private Label insstudy;

    @FXML
    private Label udwater;

    @FXML
    private Label avgwater;

    @FXML
    private Label inswater;

    @FXML
    private Label udexercise;

    @FXML
    private Label avgexercise;

    @FXML
    private Label insexercise;


    @FXML
    void generate(ActionEvent event) {
    	try {
    		//udsleep.setText("8");
    		ConnectionClass connectionClass=new ConnectionClass();
    		Connection connection=connectionClass.getConnection();
    		Statement statement=connection.createStatement();		
    		String sql = "SELECT hours FROM defined WHERE activity='sleep' ";
    		ResultSet rs=statement.executeQuery(sql);
    		//System.out.println(rs.getString(1));
    		//udsleep.setText(rs.getString(1));
    		int slp=0;
    		int avgslp=0;
    		while(rs.next())
    		{
    			udsleep.setText(rs.getString(1));
    			slp=rs.getInt(1);
    		}
    		System.out.println(slp);
    		sql = "SELECT avg(hour) FROM sleep ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			avgsleep.setText(rs.getString(1));
    			avgslp=rs.getInt(1);
    		}
    		if(slp<avgslp)
    		{
    			inssleep.setText("You have enough sleep");
    		}
    		else {
    			inssleep.setText("You don't have enough sleep");
    		}
    		//Meal
    		int mel=0;
    		int avgmel=0;
    		sql = "SELECT hours FROM defined WHERE activity='meal' ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			udmeal.setText(rs.getString(1));
    			mel=rs.getInt(1);
    		}
    		System.out.println(mel);
    		sql = "SELECT avg(hour) FROM meals ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			avgmeal.setText(rs.getString(1));
    			avgmel=rs.getInt(1);
    		}
    		if(mel<avgmel)
    		{
    			insmeal.setText("You have enough meal");
    		}
    		else {
    			insmeal.setText("You don't have enough meal");
    		}
    		//STUDY
    		int sty=0;
    		int avgsty=0;
    		sql = "SELECT hours FROM defined WHERE activity='study' ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			udstudy.setText(rs.getString(1));
    			sty=rs.getInt(1);
    		}
    		System.out.println(sty);
    		sql = "SELECT avg(hour) FROM study ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			avgstudy.setText(rs.getString(1));
    			avgsty=rs.getInt(1);
    		}
    		if(sty<avgsty)
    		{
    			insstudy.setText("You are topper");
    		}
    		else {
    			insstudy.setText("Go and Read Man");
    		}
    		//Water
    		
    		int wtr=0;
    		int avgwtr=0;
    		sql = "SELECT hours FROM defined WHERE activity='water' ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			udwater.setText(rs.getString(1));
    			wtr=rs.getInt(1);
    		}
    		System.out.println(slp);
    		sql = "SELECT avg(times) FROM water ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			avgwater.setText(rs.getString(1));
    			avgwtr=rs.getInt(1);
    		}
    		if(wtr<avgwtr)
    		{
    			inswater.setText("You have enough water");
    		}
    		else {
    			inswater.setText("You don't have enough water");
    		}
    		
    		//Exercise
    		int exe=0;
    		int avgexe=0;
    		sql = "SELECT hours FROM defined WHERE activity='excercise' ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			udexercise.setText(rs.getString(1));
    			exe=rs.getInt(1);
    		}
    		System.out.println(exe);
    		sql = "SELECT avg(hour) FROM exercise ";
    		rs=statement.executeQuery(sql);
    		while(rs.next())
    		{
    			avgexercise.setText(rs.getString(1));
    			avgexe=rs.getInt(1);
    		}
    		if(exe<avgexe)
    		{
    			insexercise.setText("You have enough exercise");
    		}
    		else {
    			insexercise.setText("You don't have enough exercise");
    		}
    		double avgall=(avgexe+avgmel+avgslp+avgsty+avgwtr)/5;
    		System.out.println(avgall);
    		for(int i=0;i<=avgall;i++) {
    			progressbar.setProgress(avgall/10.0);
    			//TimeUnit.SECONDS.sleep(1);
    			//Thread.sleep(1000);
    		}
    		
   	
    	}
    	catch(Exception e) {
    		System.out.println("Error"+e);
    	}

    }
   
}
