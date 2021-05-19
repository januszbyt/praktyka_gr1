package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class MainController {

	@FXML public Pane body;
	@FXML public TextField test;
	@FXML public  ViewController ViewController = new ViewController();;
	@FXML public controller.Logowanie.LogowanieController LogowanieController;
	@FXML public controller.Logowanie.RejestracjaController RejestracjaController;
	@FXML public void initialize() {
		ViewController.init(this);
		System.out.println("MainController init");
		ViewController.changeBody("logowanie");
	}
	public void test(){

		System.out.println(LogowanieController.ttt.getText());
	}



}