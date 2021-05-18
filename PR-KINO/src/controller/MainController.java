package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;


public class MainController {

	@FXML public Pane body;
	@FXML public TextField test;
	@FXML public  ViewController ViewController;

	@FXML public void initialize() {
		System.out.println("MainController init");
		changeBody();
	}
	public void test(){
		System.out.println(ViewController.ttt.getText());
	}
	public void changeBody(){
		try {
			FXMLLoader loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/logowanie.fxml"));
			AnchorPane panel = (AnchorPane)loader.load();
			ViewController = loader.getController();
			ViewController.init(this);
			body.getChildren().removeAll();
			body.getChildren().setAll(panel);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}