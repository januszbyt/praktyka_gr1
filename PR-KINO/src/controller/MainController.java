package controller;

import controller.Logowanie.RejestracjaController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import object.Bilet;


public class MainController {

	public object.Bilet Bilet = new Bilet();
	@FXML public Pane body;
	@FXML public TextField test;

	@FXML public ViewController ViewController = new ViewController();;
	@FXML public controller.Logowanie.LogowanieController LogowanieController;
	@FXML public controller.Logowanie.RejestracjaController RejestracjaController = new RejestracjaController();

	@FXML public void initialize() {
		ViewController.init(this);
		RejestracjaController.init(this);

		ViewController.changeBody("Rejestracja");


	}
	public void Logowanie(){
	ViewController.changeBody("logowanie");

	}
	public void Rejestracja(){
		ViewController.changeBody("Rejestracja");

	}



}