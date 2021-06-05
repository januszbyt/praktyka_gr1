package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class ViewController {
    private MainController main;
    private String lastPanel;
    private ArrayList backList = new ArrayList();
    public void init(MainController main){
        System.out.println("ViewController init");
        this.main = main;
    }
    public void changeBody(String name){
        this.backList.add(name);
        FXMLLoader loader;

        AnchorPane panel = null; 
        boolean work = true;
        try {
           switch(name){
               case"Logowanie": case"logowanie":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/logowanie.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.LogowanieController=loader.getController();
                   this.main.LogowanieController.init(main);

                   break;
               case"Rejestracja": case"rejestracja":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/Rejestracja.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.RejestracjaController=loader.getController();
                   this.main.RejestracjaController.init(main);
                   break;
               case"ADodatki":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/ADodatki.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.ADodatkiController=loader.getController();
                   this.main.ADodatkiController.init(main);

                   break;
               case"AUzytkownicy":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/AUżytkownicy.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.AUżytkownicyController=loader.getController();
                   this.main.AUżytkownicyController.init(main);
                   break;
               case"UWybor_miejsca":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UWybor_miejsca.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.UWybor_miejscaController=loader.getController();
                   this.main.UWybor_miejscaController.init(main);
                   break;

               case"UWybor_filmu":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UWybor_filmu.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.UWybor_filmuController=loader.getController();
                   this.main.UWybor_filmuController.init(main);
                   break;
               case"URecenzja":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/URecenzja.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.URecenzjaController =loader.getController();
                   this.main.URecenzjaController.init(main);
                   break;
               case"UWybor_dodatkow":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UWybor_dodatkow.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.UWybor_dodatkowController=loader.getController();
                   this.main.UWybor_dodatkowController.init(main);
                   break;
               case"AFilmy":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/AFilmy.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.AFilmyController=loader.getController();
                   this.main.AFilmyController.init(main);
                   break;
               case"WyborOkienekUzyt":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/WyborOkienekUzyt.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.WyborOkienekUzytControler=loader.getController();
                   this.main.WyborOkienekUzytControler.init(main);
                   break;
               case"WyborOkienekAdmin":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Logowanie/WyborOkienekAdmin.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.WyborOkienekAdminControler=loader.getController();
                   this.main.WyborOkienekAdminControler.init(main);
                   break;
               case"ASeansu":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Administrator/ASeans.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.ASeansuController=loader.getController();
                   this.main.ASeansuController.init(main);
                   break;
               case"USeansu":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/WWybur_seansu.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.UWybur_seansuController=loader.getController();
                   this.main.UWybur_seansuController.init(main);
                   break;
               case"UPodsumowanie":
                   loader =  new FXMLLoader(getClass().getClassLoader().getResource("./view/Użytkownicy/UPodsumowanie.fxml"));
                   panel = (AnchorPane)loader.load();
                   this.main.UPodsumowanieController=loader.getController();
                   this.main.UPodsumowanieController.init(main);
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
    public void back(){
        int a =this.backList.size() -2;
        this.changeBody((String) this.backList.get(a));
    }


}