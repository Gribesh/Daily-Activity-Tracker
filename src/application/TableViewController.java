package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import JDBConnectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TableViewController implements Initializable  {

	@FXML
    private TableView<TableModel> table;

    @FXML
    private TableColumn<TableModel,String> days;

    @FXML
    private TableColumn<TableModel,String> hours;

    ObservableList<TableModel> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		try {
			ConnectionClass connectionClass=new ConnectionClass();
			Connection connection=connectionClass.getConnection();
			Statement statement=connection.createStatement();
			String sql="SELECT * from exercise";
			ResultSet rs=statement.executeQuery(sql);

			while(rs.next()){
				oblist.add(new TableModel(rs.getString(2),rs.getString(3)));

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}


		
		days.setCellValueFactory(new PropertyValueFactory<>("p1"));
		hours.setCellValueFactory(new PropertyValueFactory<>("p2"));
		

		table.setItems(oblist);
	}
	
}

