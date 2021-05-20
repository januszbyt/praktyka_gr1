package controller.Administrator;


import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

import static controller.MainController.stmt;

public class AFilmyController {
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextArea t6;
    @FXML public TextField t7;
    @FXML public TextField t8;


    private MainController main;
    public void init(MainController main){
        this.main = main;
    }

    public void wpiszDane() {
        AFilmyController af = new AFilmyController();
        System.out.println("INFORMACJE O FILMIE");
        System.out.println("Tytul: " + t1.getText());
        System.out.println("Gatunek: " + t2.getText());
        System.out.println("Dlugosc filmu: " + t3.getText());
        System.out.println("Rezyser: " + t4.getText());
        System.out.println("Kraj: " + t5.getText());
        System.out.println("Opis: " + t6.getText());
        System.out.println("Rok produkcji: " + t7.getText());
        System.out.println("Typ: " + t8.getText());
        System.out.println("");


    }




    public void wyczyscPola(){
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();

    }


    public void dodajDoBazy() {
    }
}

