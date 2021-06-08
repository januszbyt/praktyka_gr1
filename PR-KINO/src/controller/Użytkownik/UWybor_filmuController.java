package controller.Użytkownik;
import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
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
        int[] idF = new int[47];
        String[] nazwaF = new String[47];
        String[] urlF = new String[47];
        Double[] srednia = new Double[47];
        int i = 0;
        int id;

        try {
            ResultSet rs = this.main.stmt.executeQuery("SELECT *,filmy.id as aa, (select avg (ocena) from recencje where recencje.id_filmu= aa) as srednia from filmy order by srednia desc");
            while (rs.next()) {
                idF[i] = rs.getInt(1);
                nazwaF[i] = rs.getString(2);
                urlF[i] = rs.getString(10);
                srednia[i] = rs.getDouble(12);
               // System.out.println(idF[i] + nazwaF[i] + urlF[i]);
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(urlF[0]);

        for (int j = 0, k = 0; j < 6; j++)
            for (int l = 0; l < 6; l++, k++) {
                try {
                   // System.out.println(urlF[k]);
                    if (urlF[k]!=null){
                        Image image = new Image(urlF[k], 140, 185, false, true);
                        button_grid.add(new ImageView(image), l, j);

                    }
                    else if(nazwaF[k]!=null){
                        String url="https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Brak_obrazka.svg/1024px-Brak_obrazka.svg.png";
                        Image image = new Image(url, 100, 100, false, true);

                        button_grid.add(new ImageView(image), l, j);



                    }
                    if (nazwaF[k]!=null) {
                        Label lbl = new Label(Double.toString(srednia[k]));
                        Label lblN = new Label(nazwaF[k]);
                        Hyperlink btn = new Hyperlink();
                        btn.setMinSize(140, 190);
                        btn.setVisible(true);
                        GridPane.setHalignment(btn,HPos.LEFT);
                        GridPane.setHalignment(lbl,HPos.CENTER);
                        GridPane.setValignment(lbl, VPos.BOTTOM);
                        GridPane.setHalignment(lblN,HPos.CENTER);
                        GridPane.setValignment(lblN, VPos.TOP);
                        btn.setBorder(Border.EMPTY);
                        btn.setStyle("-fx-border-color: cf2c26 ;-fx-border-width: 6;-fx-border-radius: 3;");
                        lbl.setStyle("-fx-text-fill: #fdc837;-fx-font-size: 20px;-fx-background-color: rgba(0,0,0,0.24);");
                        lblN.setStyle("-fx-padding:6;-fx-text-fill: #fdc837;-fx-font-size: 20px;-fx-background-color: rgba(0,0,0,0.65);");
                        btn.setAlignment(Pos.CENTER_RIGHT);
                        lbl.setAlignment(Pos.CENTER_RIGHT);

                        /*btn.setOnAction(new EventHandler<ActionEvent>() {


                                            public void handle(ActionEvent event) {
                                                id=idF[k];


                                            }
                                        }*/
                        button_grid.add(lblN, l, j);
                        button_grid.add(lbl, l, j);
                        button_grid.add(btn, l, j);
                        int finalK = k;
                        btn.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println(idF[finalK]);

                                main.bilet.setIdFilm(idF[finalK]);
                                main.ViewController.changeBody("USeansu");


                            }
                        });
                    }


                } catch (Exception e) {
                }
            }
        //return id;
    }


        /*String url = "http://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/17167-home_default/obrazek-obrazki-19paz.jpg";
        Image image = new Image(url, 100, 100, false, true);
        button_grid.add(new ImageView(image),0,0);
        int indexX =0;
        int indexY =0;
        Button btn = new Button("Button_ ddkdkdddddddddddd0oo0ldl" + indexX);

        // btn.setStyle("-fx-graphic: url('http://83437-254797-raikfcquaxqncofqfm.stackpathdns.com/17167-home_default/obrazek-obrazki-19paz.jpg')");

        button_grid.add(btn, indexX,indexY);*/



   /* void addButton(){
        int index = 2;
        Button sound_button = new Button("Button_" + index);
        button_grid.add(sound_button, index,2);
    }*/
}