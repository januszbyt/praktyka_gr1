package controller.Logowanie;

import controller.MainController;
import javafx.event.ActionEvent;

public class WyborOkienekAdminController {
    private MainController main;
    public void init(MainController main){
        this.main = main;
    }
    public void przejscie_do_filmow(){
main.ViewController.changeBody("AFilmy");
    }
    public void przejscie_do_dodatkow(){
        main.ViewController.changeBody("ADodatki");
    }
    public void przejscie_do_uzytkownikow(){
        main.ViewController.changeBody("AUzytkownicy");
    }

    public void powrot() {
    }

    public void wylogowanie() {
    }
}

