package ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class opcoesLoginController {
	@FXML
	private Button btnAdmin, btnServidor, btnDiscente;
	
	
	public void clickBtn() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		
		Scene menuProductScreen = new Scene(root, 541, 131);
		Stage stage = new Stage();
		stage.setTitle("Veritas");
		stage.setScene(menuProductScreen);
		stage.show();
	}
	
	
}
