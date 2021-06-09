package controller.Użytkownik;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;



public class URecenzjaController {
    @FXML
    public TextField textRecenzja;
    @FXML
    public Rating rating;
    @FXML
    public Label film;

    @FXML
    public ComboBox<String> comboBox;
    final ObservableList options = FXCollections.observableArrayList();
    private MainController main;

    String tytul_filmu=" ";

    public void init(MainController main){
        this.main = main;
        String film_query = "SELECT tytul FROM filmy";
        String selected_text = " ";

        try {

            ResultSet rs = this.main.stmt.executeQuery(film_query);
            while (rs.next()){
                options.add(rs.getString("tytul"));
            }
            comboBox.setItems(options);

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
        String recenzja = textRecenzja.getText();
        double ocena = rating.getRating();
        String id_query = "SELECT MAX(id) from recencje";
        //z ComboBox
        String id_filmu_query = "SELECT id FROM filmy WHERE tytul = '" + comboBox.getValue() + "'";
        System.out.println(comboBox.getValue());


        try {
            ResultSet rs = this.main.stmt.executeQuery(id_query);
            rs.next();
            int id = rs.getInt(1)+1;

            id_uzytkownika = this.main.bilet.WypiszId();

            ResultSet rsF = this.main.stmt.executeQuery(id_filmu_query);
            rsF.next();
            int id_filmu = rsF.getInt(1);
            System.out.println(id_filmu);

            String query = "INSERT INTO `recencje` (`id`, `id_uzytkownika`, `id_filmu`, `ocena`, `opis`) VALUES ('" + id + "','" + id_uzytkownika + "','" + id_filmu + "','" + ocena + "','" + recenzja + "')";
            this.main.stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Użytkownik " + id_uzytkownika + " dodał recenzje: '" + recenzja + "' z oceną " + ocena + " o id " + id  + ", i tytulem filmu: " + comboBox.getValue());
            textRecenzja.clear();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        };

}
