package controller;
import controller.Administrator.ADodatkiController;
import controller.Administrator.AFilmyController;
import controller.Administrator.AUżytkownicyController;
import controller.Logowanie.LogowanieController;
import controller.Logowanie.RejestracjaController;
import controller.Użytkownik.URecenzjaController;
import controller.Użytkownik.UWybor_dodatkowController;
import controller.Użytkownik.UWybor_filmuController;
import controller.Użytkownik.UWybor_miejscaController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import java.sql.*;

public class MainController {

	public static Connection con;
	public static Statement stmt;
	@FXML public Pane body;
	@FXML public ComboBox WyborFilmu;
	@FXML public  ViewController ViewController = new ViewController();
	@FXML public LogowanieController LogowanieController;
	@FXML public RejestracjaController RejestracjaController;


	@FXML public ADodatkiController ADodatkiController;
	@FXML public AFilmyController AFilmyController;
	@FXML public AUżytkownicyController AUżytkownicyController;

	@FXML public URecenzjaController URecenzjaController;
	@FXML public UWybor_filmuController UWybor_filmuController;
	@FXML public UWybor_miejscaController UWybor_miejscaController;
	@FXML public UWybor_dodatkowController UWybor_dodatkowController;

	@FXML public void initialize() {
		this.PolaczZBazaDanych();
		ViewController.init(this);
		System.out.println("MainController init");
		WyborFilmu.getItems().addAll("logowanie", "Rejestracja", "ADodatki", "AUzytkownicy","AFilmy","URecenzja","UWybor_filmu"
		,"UWybor_miejsca","UWybor_dodatkow");
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

	public boolean dodajFilm(String tytul, String gatunek, int dlugosc, String rezyser,String kraj, String opis, int rok_produkcji,String typ) {
		try {
			PreparedStatement prepStmt = con.prepareStatement(
					"insert into filmy values (NULL, ?, ?, ?,?,?,?,?,?);");
			stmt.execute(dlugosc);
			prepStmt.setString(1, tytul);
			prepStmt.setString(2, gatunek);
			prepStmt.setString(3, dlugosc);
			prepStmt.setString(4, rezyser);
			prepStmt.setString(5, kraj);
			prepStmt.setString(6, opis);
			prepStmt.setString(7, rok_produkcji);
			prepStmt.setString(8, typ);
			prepStmt.execute();
		} catch (SQLException e) {
			System.err.println("Blad przy wstawianiu czytelnika");
			e.printStackTrace();
			return false;
		}
		return true;
	}


}