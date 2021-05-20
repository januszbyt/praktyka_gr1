package controller.Logowanie;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LogowanieController {

    @FXML public TextField login;
    @FXML public TextField haslo;
    private MainController main;
    public void init(MainController main){
        this.main = main;
    }


    @FXML public void initialize(){
        login.setPromptText("Tutaj wpisz swój login:");
        haslo.setPromptText("Tutaj wpisz swoje hasło:");
    }
    @FXML public void zaloguj(){

    }
    @FXML public void zarejestruj(){

    }

}
