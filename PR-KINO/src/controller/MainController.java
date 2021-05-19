package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;


public class MainController {

	@FXML public Pane body;
	@FXML public ComboBox WyborFilmu;
	@FXML public  ViewController ViewController = new ViewController();;
	@FXML public controller.Logowanie.LogowanieController LogowanieController;
	@FXML public controller.Logowanie.RejestracjaController RejestracjaController;
	@FXML public void initialize() {
		ViewController.init(this);
		System.out.println("MainController init");
		WyborFilmu.getItems().addAll("logowanie", "Rejestracja", "ADodatki", "AUzytkownicy","AFilmy","URecenzja","UWybor_filmu"
		,"UWybor_miejsca","UWybor_dodatkow");
	}
	public void Wybierz(){
		ViewController.changeBody(WyborFilmu.getValue()+"");
	}



}