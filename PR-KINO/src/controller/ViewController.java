package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewController {
    private MainController main;
    public void init(MainController main){
        System.out.println("ViewController init");
        this.main = main;
    }
    public void changeBody(String name){
        FXMLLoader loader;
        AnchorPane panel = null; 
        boolean work = true;
        try {
           switch(name){
               case"Logowanie": case"logowanie":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/logowanie.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"Rejestracja": case"rejestracja":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/Rejestracja.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"ADodatki":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/ADodatki.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"AUzytkownicy":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/AUżytkownicy.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"UWybor_miejsca":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UWybor_miejsca.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"UWybor_filmu":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UWybor_filmu.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"URecenzja":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/URecenzja.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"UWybor_dodatkow":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UWybor_dodatkow.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;
               case"AFilmy":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/AFilmy.fxml"));
                   panel = (AnchorPane)loader.load();
                   break;

               default:
                   System.err.println("Bład wyboru okna, Nazwa: '"+name+"' nie jest znana");
                   work = false;
                   break;
           }
          if(work){
              this.main.body.getChildren().removeAll();
              this.main.body.getChildren().setAll(panel);
          }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}