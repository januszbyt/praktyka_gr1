package controller.Logowanie;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

public class LogowanieController {

    @FXML public TextField login;
    @FXML public PasswordField haslo;
    @FXML public Label komunikat;
    private MainController main;
    public void init(MainController main){
        this.main = main;
    }


    @FXML public void initialize(){
        login.setPromptText("Tutaj wpisz swój login:");
        haslo.setPromptText("Tutaj wpisz swoje hasło:");
    }
    @FXML public void zaloguj() throws SQLException {
        try {
            String Login = login.getText();
            this.main.bilet.WpiszImie(Login);
            String Haslo = haslo.getText();
            String SGL_A= "select count(*) as ile from administracja where login='" + Login + "' and haslo='" + Haslo + "'";
            String SGL_U = "select count(*) as ile from uzytkownicy where login='" + Login + "' and haslo='" + Haslo + "' and potwierdzony_email='true'";
            ResultSet rsU = this.main.stmt.executeQuery(SGL_U);
            rsU.next();
            int dostepU = rsU.getInt("ile");
            ResultSet rsA = this.main.stmt.executeQuery(SGL_A);
            rsA.next();
            int dostepA = rsA.getInt("ile");
            if (dostepU == 1) {
                main.ViewController.changeBody("WyborOkienekUzyt");
            }
            else if ( dostepA == 1){
                main.ViewController.changeBody("WyborOkienekAdmin");
            }
            else
            {
              komunikat.setVisible(true);
            }


        }catch(Exception e){
            System.out.println(e);
        }
    }
    @FXML public void zarejestruj(){
main.ViewController.changeBody("rejestracja");
    }

}
