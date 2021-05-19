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
                   this.main.LogowanieController = loader.getController();
                   this.main.LogowanieController.init(this.main);
                   break;
               case"Rejestracja": case"rejestracja":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/Rejestracja.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.RejestracjaController = loader.getController();
                   this.main.RejestracjaController.init(this.main);
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