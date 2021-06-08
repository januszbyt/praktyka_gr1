package controller.Użytkownik;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;



public class URecenzjaController {
    @FXML
    public TextField textRecenzja;
    @FXML
    public Rating rating;
    @FXML
    public Label film;


    private MainController main;

    String tytul_filmu=" ";

    public void init(MainController main){
        this.main = main;
        //String id_uzytkownika_query = "SELECT id from uzytkownicy where login = " + this.main.bilet.WypiszImie();


        String tytul_query = "SELECT tytul FROM filmy where id = " + this.main.bilet.getIdFilm();

        try {
            ResultSet rsU = this.main.stmt.executeQuery(tytul_query);
            rsU.next();
            tytul_filmu = rsU.getString(1);
            film.setText(tytul_filmu);

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    public void powrotButton(){
    main.ViewController.changeBody("WyborOkienekUzyt");
    };
    public void clear(){
        textRecenzja.clear();
    };
    public void dodajDoBazy(){
        int id_uzytkownika = 0;
        int id_filmu = 0;
        String recenzja = textRecenzja.getText();
        double ocena = rating.getRating();
        int id = ThreadLocalRandom.current().nextInt(1, 1001);

        try {

            id_uzytkownika = this.main.bilet.WypiszId();
            id_filmu = this.main.bilet.getIdFilm();

            String query = "INSERT INTO `recencje` (`id`, `id_uzytkownika`, `id_filmu`, `ocena`, `opis`) VALUES ('" + id + "','" + id_uzytkownika + "','" + id_filmu + "','" + ocena + "','" + recenzja + "')";
            this.main.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Użytkownik " + id_uzytkownika + " dodał recenzje: '" + recenzja + "' z oceną " + ocena + " o id " + id  + ", i tytulem filmu: " + tytul_filmu);
            textRecenzja.clear();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        };

}
