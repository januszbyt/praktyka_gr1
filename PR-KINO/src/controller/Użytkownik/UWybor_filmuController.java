package controller.Użytkownik;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.sql.ResultSet;

public class UWybor_filmuController<topBtn> {

    @FXML
    GridPane button_grid;


    private MainController main;
    public void init(MainController main){
        this.main = main;
        this.initialize();
    }
    public void initialize() {
        int[] idF1= new int[47];
        String[] nazwaF= new String[47];
        String[] urlF= new String[47];
        int i =0;

            try {
                ResultSet rs = this.main.stmt.executeQuery("SELECT *,filmy.id as aa, (select avg (ocena) from recencje where recencje.id_filmu= aa) as srednia from filmy order by srednia desc");
                while (rs.next()) {
                    idF1[i]= rs.getInt(1);
                    nazwaF[i]= rs.getString(2);
                    urlF[i]= rs.getString(10);
                    System.out.println(idF1[i]+ nazwaF[i]+urlF[i]);
                }
            }catch(Exception e){
                System.out.println(e);
            }

            for(int j=0,k=0;j<6;j++)
                for(int l=0;l<8;l++,k++)
                {
                    try {
                    System.out.println(urlF[k]);
                   String url =urlF[k];
                    Image image = new Image(url, 100, 100, false, true);
                    button_grid.add(new ImageView(image),j,l);
                    Button btn = new Button(nazwaF[k]);
                    button_grid.add(btn, j,l);
                    }catch (Exception e){}

                }
        /*String url = "http://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/17167-home_default/obrazek-obrazki-19paz.jpg";
        Image image = new Image(url, 100, 100, false, true);
        button_grid.add(new ImageView(image),0,0);
        int indexX =0;
        int indexY =0;
        Button btn = new Button("Button_ ddkdkdddddddddddd0oo0ldl" + indexX);

        // btn.setStyle("-fx-graphic: url('http://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/17167-home_default/obrazek-obrazki-19paz.jpg')");

        button_grid.add(btn, indexX,indexY);*/


    }
   /* void addButton(){
        int index = 2;
        Button sound_button = new Button("Button_" + index);
        button_grid.add(sound_button, index,2);
    }*/
}