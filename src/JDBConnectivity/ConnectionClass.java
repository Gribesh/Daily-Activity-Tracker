package JDBConnectivity;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	public Connection connection;
	public Connection getConnection() {
		
		 String dbName="dat";
	     String userName="root";
	     String password="";

	       	try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();

	        connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        return connection;
	}

}
