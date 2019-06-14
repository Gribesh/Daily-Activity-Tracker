package application;

import java.sql.Connection;
import java.sql.ResultSet;
import JDBConnectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.Statement;

public class ReportController {

    @FXML
    private Label udsleep;

    @FXML
    private Label avgsleep1;

    @FXML
    private Label inssleep;

    @FXML
    void generate(ActionEvent event) {
    	try {
    		ConnectionClass connectionClass=new ConnectionClass();
    		Connection connection=connectionClass.getConnection();
    		Statement statement=connection.createStatement();		
    		String sql = "SELECT hours FROM defined WHERE activity='sleep' ";
    		ResultSet rs=statement.executeQuery(sql);
    		udsleep.setText(rs.getString(1));
    		
    	}
    	catch(Exception e) {
    		System.out.println("Error"+e);
    	}

    }

}
