package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SampleController {
	
	  @FXML
	  private Label test;
	  
	  @FXML
	  private Pane body;
public void test() 
	{
	this.body.getId();
	try {
		AnchorPane panel = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("./Logowanie/Logowanie.fxml"));

		body.getChildren().removeAll();
		body.getChildren().setAll(panel);

	} catch (IOException e) {
		e.printStackTrace();
	}
	}
public void test2() 
{
	this.body.getId();
	try {
		AnchorPane panel = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("./Rejestracja/Rejestracja.fxml"));
		body.getChildren().removeAll();
		body.getChildren().setAll(panel);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
