package controller.Administrator;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ADodatkiController {

    private MainController main;
    public void init(MainController main){
        this.main = main;
    }
    @FXML
    public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;

    public void wpiszDane() {
        ADodatkiController af = new ADodatkiController();
        System.out.println("INFORMACJE O DODATKU");
        System.out.println("Nazwa: " + t1.getText());
        System.out.println("Typ: " + t2.getText());
        System.out.println("Cena: " + t3.getText());
        System.out.println("Ilość: " + t4.getText());
        {
            ADodatkiController af2= new ADodatkiController();

        }

    }

    public void wyczyscPola()
    {
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();

    }
    public void dodajDoBazy(){

    }
}
