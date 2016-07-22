package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	public static Stage primaryStage;
	public static Object stage;
	
	public void start(Stage primaryStage) throws Exception{
		this.primaryStage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("opcoesLogin.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("LEG");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args){
		launch(args);
	}
}
