package controller;

import controller.Administrator.ADodatkiController;
import controller.Administrator.AFilmyController;
import controller.Administrator.AUżytkownicyController;
import controller.Logowanie.LogowanieController;
import controller.Logowanie.RejestracjaController;
import controller.Logowanie.WyborOkienekAdminController;
import controller.Logowanie.WyborOkienekUzytController;
import controller.Użytkownik.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import object.Bilet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainController {

	public Bilet bilet  = new Bilet();

	public Connection con;
	public Statement stmt;
	@FXML public Pane body;
	@FXML public ComboBox WyborFilmu;
	@FXML public  ViewController ViewController = new ViewController();
	@FXML public LogowanieController LogowanieController;
	@FXML public RejestracjaController RejestracjaController;
	@FXML public WyborOkienekAdminController WyborOkienekAdminControler;
	@FXML public WyborOkienekUzytController WyborOkienekUzytControler;

	@FXML public ADodatkiController ADodatkiController;
	@FXML public AFilmyController AFilmyController;
	@FXML public AUżytkownicyController AUżytkownicyController;

	@FXML public URecenzjaController URecenzjaController;
	@FXML public UWybor_filmuController UWybor_filmuController;
	@FXML public UWybor_miejscaController UWybor_miejscaController;
	@FXML public UZnizkiController UZnizkiController;
	@FXML public UWybor_dodatkowController UWybor_dodatkowController;
	@FXML public UZakonczenieController UZakonczenieController;
	@FXML public UPodsumowanieController UPodsumowanieController;
	@FXML public controller.Użytkownik.UWybur_seansuController UWybur_seansuController;
	@FXML public controller.Administrator.ASeansuController ASeansuController;



	@FXML public void initialize() {
		this.PolaczZBazaDanych();
		ViewController.init(this);
		System.out.println("MainController init");
		//WyborFilmu.getItems().addAll("UZnizki","UZakonczenie","logowanie", "Rejestracja", "WyborOkienekUzyt","WyborOkienekAdmin", "ADodatki", "AUzytkownicy","AFilmy","URecenzja","UWybor_filmu"
		//,"UWybor_miejsca","UWybor_dodatkow","USeansu","ASeansu","UPodsumowanie");
		ViewController.changeBody("logowanie");

	}
	public void Wybierz(){
		ViewController.changeBody(WyborFilmu.getValue()+"");
	}
	private void PolaczZBazaDanych(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11412360","sql11412360","MLKI6a5Yh3");
			stmt=con.createStatement();
		/*	ResultSet rs=stmt.executeQuery("select * from filmy");  jak pobierać dane
			while(rs.next())
				System.out.println(rs.getInt(1)+" "+rs.getString(2));*/
		}catch(Exception e){
			System.out.println(e);
		}

	}


	public void wyloguj(){
ViewController.changeBody("Logowanie");
	}


}