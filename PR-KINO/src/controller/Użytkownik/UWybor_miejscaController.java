package controller.Użytkownik;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import object.wybrane_miejsce;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UWybor_miejscaController<Intreger> {
    private MainController main;
    public AnchorPane buttonsPanel;
    public AnchorPane znizki;
    public Label ileMiejsc;
    public ScrollPane scrool;
    public int a =0;
    public List<wybrane_miejsce> wybraneMiejsca = new ArrayList<wybrane_miejsce>();
    public List<String> zajete_miejsca = new ArrayList<String>();
    private  ObservableList<String> data  = FXCollections.observableArrayList("Nauczyciel","Niepełnosprawny","Uczeń","Student","Senior","< 14 lat","< 2 lata","Grupa min 10 osób");
    public List<Button> przyciski = new ArrayList<Button>();
    public void init(MainController main) {
        this.main = main;
        scrool.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        //this.znizki.setItems(data);



        String sql1= "select * from bilety,zajete_miejsca where bilety.id = zajete_miejsca.id_biletu and id_seansu = "+ this.main.bilet.getIdseansu();
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
                int numer =(x * 10) + y + 1;
                final Button[] a = {new Button(numer + "")};
                a[0].setLayoutY(10 + (x * 40));
                a[0].setLayoutX(10 + (y * 40));
                a[0].setMinWidth(35);
                a[0].setMinHeight(35);
                przyciski.add(a[0]);
                EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                            setZajete();
                            Button tmp = ((Button)e.getSource());
                            String text = (Integer.parseInt(tmp.getText()) - 1) + "";
                                 boolean zna = false;
                                  for(int i = 0; i < wybraneMiejsca.size(); i++){
                                      if(wybraneMiejsca.get(i).numer.equals(text)){
                                          zna = true;
                                      }
                                  }
                            if(zna){
                                wybraneMiejsca.removeIf(n -> (n.numer.equals(text)));
                            } else {
                                wybrane_miejsce a = new wybrane_miejsce();
                                a.numer = text;
                                wybraneMiejsca.add(a);
                            }
                            setWybrane();
                            setznizki();
                    }
                };
                a[0].setOnAction(event);
                this.buttonsPanel.getChildren().add(a[0]);
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
    public void setWybrane(){
        for(int i = 0; i < wybraneMiejsca.size(); i++){
            przyciski.get(Integer.parseInt(wybraneMiejsca.get(i).numer)).setStyle("-fx-background-color: orange");
        }
    }


    public void setznizki(){
        znizki.getChildren().clear();
        ileMiejsc.setText(wybraneMiejsca.size()+"");
        for(int i = 0; i < wybraneMiejsca.size(); i++){
          Label text = new Label("Miejsce nr: "+(Integer.parseInt(wybraneMiejsca.get(i).numer )+ 1));
          text.setLayoutY(0 + (i * 40));
          text.setLayoutX(0);
          text.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
          ComboBox a = new ComboBox(data);
          a.setId(String.valueOf(Integer.parseInt(wybraneMiejsca.get(i).numer )));
          a.setLayoutY(0 + (i * 40));
          a.setValue("Wybierz");
          a.setLayoutX(160);
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    ComboBox tmp = ((ComboBox)e.getSource());
                    wybraneMiejsca.forEach((tab) -> {
                       if(tab.numer.equals(tmp.getId())){
                            tab.znizka = (String) tmp.getValue();
                            //System.out.println(tab.zwroc_znizke());
                       }
                    });
                }
            };
            a.setOnAction(event);
            wybraneMiejsca.forEach((tab) -> {
                       if(a.getId().equals(tab.numer) && tab.znizka != null){
                           a.setValue(tab.znizka);
                       }
            });
         znizki.getChildren().add(a);
         znizki.getChildren().add(text);

        }

    }

    public void dalej(){
        this.main.bilet.setWybraneMiejsca(this.wybraneMiejsca);
        this.main.ViewController.changeBody("UPodsumowanie");
      //  this.main.ViewController.changeBody("UWybor_dodatkow");
    }
}
