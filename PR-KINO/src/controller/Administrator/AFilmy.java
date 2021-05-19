package controller.Administrator;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AFilmy {
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextArea t6;
    @FXML public TextField t7;
    @FXML public TextField t8;



    public void wpiszDane() {
        AFilmy af = new AFilmy();
    System.out.println(t1.getText() + t2.getText() + t3.getText() + t4.getText() + t5.getText() + t6.getText() + t7.getText() + t8.getText());
    }
    public void edytujDane()
    {
        AFilmy af2= new AFilmy();

    }

    public void wczytajInt(){

    }

    public void wyczyscPola(){
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        t6.clear();
        t7.clear();
        t8.clear();
    }
}
