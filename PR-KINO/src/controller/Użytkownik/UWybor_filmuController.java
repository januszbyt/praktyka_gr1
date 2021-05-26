package controller.Użytkownik;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.*;
import java.sql.*;
import javafx.*;

public class UWybor_filmuController {

    @FXML
    GridPane button_grid;


    private MainController main;
    public void init(MainController main){
        this.main = main;
    }
    public int[] idF1= new int[47];
    public String[] nazwaF= new String[47];
    public String[] urlF= new String[47];
    public void initialize() {

        try {
            ResultSet rs = this.main.stmt.executeQuery("SELECT *,filmy.id as aa, (select avg (ocena) from recencje where recencje.id_filmu= aa) as srednia from filmy order by srednia desc");
            while (rs.next()) {
                int i =0;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


    String url = "http://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/17167-home_default/obrazek-obrazki-19paz.jpg";
    Image image = new Image(url, 100, 100, false, true);
        button_grid.add(new ImageView(image),0,0);
    int indexX =0;
    int indexY =0;
    int idF = 2;
    Button btn = new Button("Button_ ddkdkdddddddddddd0oo0ldl" + indexX);

    // btn.setStyle("-fx-graphic: url('http://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/17167-home_default/obrazek-obrazki-19paz.jpg')");

        button_grid.add(btn, indexX,indexY);


}
   /* void addButton(){
        int index = 2;
        Button sound_button = new Button("Button_" + index);
        button_grid.add(sound_button, index,2);
    }*/


