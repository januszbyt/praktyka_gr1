package controller.Użytkownik;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UWybor_miejscaController<Intreger> {
    private MainController main;
    public AnchorPane buttonsPanel;
    public Label test;
    public int a =0;
    public String wybraneMiejsce;
    public ComboBox znizki;
    public List<String> zajete_miejsca = new ArrayList<String>();
    public List<Button> przyciski = new ArrayList<Button>();
    public void init(MainController main) {
        this.main = main;
        ObservableList<String> data  = FXCollections.observableArrayList("Nauczyciel","Uczeń","Student","Senior"," < 12 lat");
        this.znizki.setItems(data);



        String sql1= "select id_miejsca from bilety where id_seansu = 2";
        try {
            ResultSet wynik = this.main.stmt.executeQuery(sql1);

            while(wynik.next()){
                this.zajete_miejsca.add(wynik.getString("id_miejsca"));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for(int x = 0;x < 10;x++){
            for(int y = 0;y < 10;y++){
                int numer =(y * 10) + x + 1;
                Button a = new Button(numer + "");
                a.setLayoutY(10 + (y * 40));
                a.setLayoutX(10 + (x * 40));
                a.setMinWidth(35);
                a.setMinHeight(35);
                przyciski.add(a);



                EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                        setZajete();
                        Button tmp = ((Button)e.getSource());
                        String text = tmp.getText();
                        tmp.setStyle("-fx-background-color: orange");
                        wybraneMiejsce=text;

                    }

                };
                a.setOnAction(event);
                this.buttonsPanel.getChildren().add(a);
            }
        }
        this.setZajete();


    }

    public void setZajete(){
        for(int i = 0; i < przyciski.size(); i++){
            if(zajete_miejsca.contains(i+"")){
                przyciski.get(i).setStyle("-fx-background-color: #8a1900");
                przyciski.get(i).setDisable(true);
            }   else {
                przyciski.get(i).setStyle("-fx-background-color: #028a00");

            }
        }
    }
    public void miejsce(){


    }


}
