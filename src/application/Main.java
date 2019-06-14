package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	public static void main(String[] args) {

		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
			Parent root=FXMLLoader.load(getClass().getResource("/application/main.fxml"));
			Scene scene = new Scene(root,350,410);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Login Page");
			primaryStage.setScene(scene);
			//primaryStage.setMaximized(true);
			primaryStage.show();
			//primaryStage.setOnCloseRequest(e -> Platform.exit());
			//primaryStage.close();
		} 
	}

