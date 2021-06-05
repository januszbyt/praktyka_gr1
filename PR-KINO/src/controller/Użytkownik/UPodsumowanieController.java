package controller.Użytkownik;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.util.Date;


public class UPodsumowanieController {
    @FXML public Label wybrany_film;
    @FXML public Label godzina_startu;
    @FXML public  Label wybrana_sala;
    @FXML public AnchorPane wybrane_miejsca;
    @FXML public Label cena_za_bilet;
    public MainController main;
    public void init(MainController main) {
        this.main = main;
        String SQL1= "select tytul from filmy where id='"+main.bilet.getIdFilm()+"'";
        String SQL2 = "select * from seanse, sala where seanse.id='"+main.bilet.getIdseansu()+"' AND seanse.id_sali=sala.id";


        try{
            ResultSet rs1 = this.main.stmt.executeQuery(SQL1);
            rs1.next();
            String tytul = rs1.getString("tytul");

            ResultSet rs2 = this.main.stmt.executeQuery(SQL2);
            rs2.next();
            String start = rs2.getString("start");
            String sala = rs2.getString("nazwa");
            wybrany_film.setText(tytul);
            godzina_startu.setText(start);
            wybrana_sala.setText(sala);

            double suma_za_miejsca = 0;



             for ( int i=0; i<main.bilet.getWybraneMiejsca().size(); i++){
                 Label a = new Label();
                 a.setLayoutY(0 + (20 * i));
                 a.setLayoutX(0);
                 a.setText("Wybrane miejsce " + main.bilet.getWybraneMiejsca().get(i).numer+ " - " + main.bilet.getWybraneMiejsca().get(i).znizka);
                 wybrane_miejsca.getChildren().add(a);

                 suma_za_miejsca=suma_za_miejsca+(20-((20.0/100)* main.bilet.getWybraneMiejsca().get(i).zwroc_znizke()));
             }


            cena_za_bilet.setText(suma_za_miejsca+"");








        }
        catch (Exception e)
        {
    System.out.println(e);
        }

    }




}
