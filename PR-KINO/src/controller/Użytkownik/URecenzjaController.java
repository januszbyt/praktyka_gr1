package controller.Użytkownik;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.controlsfx.control.Rating;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;


public class URecenzjaController {
    @FXML
    public TextField textRecenzja;
    @FXML
    public Rating rating;

    private MainController main;
    public void init(MainController main){
        this.main = main;
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
        int id = ThreadLocalRandom.current().nextInt();
        String id_uzytkownika_query = "SELECT MAX(id) FROM uzytkownicy";
        String id_filmu_query = "SELECT MAX(id)  FROM filmy";

        try {
            ResultSet rsU = this.main.stmt.executeQuery(id_uzytkownika_query);
            rsU.next();
            id_uzytkownika = rsU.getInt(1);

            ResultSet rsF = this.main.stmt.executeQuery(id_filmu_query);
            rsF.next();
            id_filmu = rsF.getInt(1);


            /* String query = "INSERT INTO `recencje` (`id`, `id_uzytkownika`, `id_filmu`, `ocena`, `opis`) VALUES ('" + id + "','" + id_uzytkownika + "','" + id_filmu + "','" + ocena + "','" + recenzja + "')";
*/
        System.out.println("User " + id_uzytkownika + "has inserted review " + id + "  to database: " + recenzja + " with rating: " + ocena + ", with ID filmu: " + id_filmu);

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        };

}
