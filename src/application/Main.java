package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Stage primaryStage1 = new Stage();
			primaryStage1.getIcons().add(new Image("application/spv.jpg"));
			primaryStage1.setTitle("0 prix cassé");
			Parent root1=FXMLLoader.load(getClass().getResource("PageDaccueil.fxml"));
			Scene scene = new Scene(root1);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage1.setScene(scene);
			primaryStage1.show();
			primaryStage1.setResizable(false);
		} catch(Exception e) {
		
			e.printStackTrace();
		}
	}
	}
	

