package controller.Administrator;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ASeansuController {
    private MainController main;

    public void init(MainController main) {
        this.main = main;
    }

    @FXML public TextField tid;
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;



    public void powrotButton() {
        main.ViewController.changeBody("WyborOkienekAdmin");
    }

    public void dodajSeans() {
        try {

            Integer ID = Integer.valueOf(tid.getText());
            String Date = t1.getText();
            String Wersja = t2.getText();
            String Typ = (t3.getText());
            Integer IDSali = Integer.valueOf(t4.getText());
            Integer IDFilm = Integer.valueOf(t5.getText());



            String query = "INSERT INTO `filmy` (`id`, `start`, `wersja`, `id_sali`, `id_filmu`) VALUES ('"+ID+"','"+Date+"','"+Wersja+"','"+Typ+"','"+IDSali +"','"+IDFilm+"')";
            this.main.stmt.execute(query);
            System.out.println("Pomyślnie dodano seans o ID: "+ ID);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}





