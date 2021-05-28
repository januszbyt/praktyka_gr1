package controller.Użytkownik;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.sql.ResultSet;

public class UWybor_dodatkowController<topBtn> {

    @FXML
    GridPane button_grid;


    private MainController main;

    public void init(MainController main) {
        this.main = main;
        this.initialize();
    }

    public void initialize() {
        int[] idF = new int[47];
        String[] nazwaF = new String[47];
        String[] urlF = new String[47];
        int i = 0;
        int id;

        try {
            ResultSet rs = this.main.stmt.executeQuery("SELECT *,from dodatki ");
            while (rs.next()) {
                idF[i] = rs.getInt("id");
                nazwaF[i] = rs.getString("Nazwa");
                urlF[i] = rs.getString("URL");
                System.out.println(idF[i] + nazwaF[i] + urlF[i]);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}






