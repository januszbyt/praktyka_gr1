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
        int[] idF = new int[11];
        String[] nazwaF = new String[47];
        String[] urlF = new String[47];
        int i = 0;
        int id;

        try {
            ResultSet rs = this.main.stmt.executeQuery("SELECT * from filmy ");
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

        //System.out.println(urlF[0]);

        for (int j = 0, k = 0; j < 6; j++)
            for (int l = 0; l < 8; l++, k++) {
                try {
                    System.out.println(urlF[k]);
                    if (urlF[k] != null) {
                        Image image = new Image(urlF[k], 100, 100, false, true);
                        button_grid.add(new ImageView(image), l, j);
                    } else if (nazwaF[k] != null) {
                        String url = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Brak_obrazka.svg/1024px-Brak_obrazka.svg.png";
                        Image image = new Image(url, 100, 100, false, true);
                        button_grid.add(new ImageView(image), l, j);

                    }
                    if (nazwaF[k] != null) {
                        Button btn = new Button(nazwaF[k]);
                        /*btn.setOnAction(new EventHandler<ActionEvent>() {


                                            public void handle(ActionEvent event) {
                                                id=idF[k];


                                            }
                                        }*/
                        button_grid.add(btn, l, j);
                    }

                } catch (Exception e) {
                }
            }

    }

}






