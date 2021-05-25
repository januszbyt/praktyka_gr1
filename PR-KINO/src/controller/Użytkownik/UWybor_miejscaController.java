package controller.Użytkownik;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class UWybor_miejscaController<Intreger> {
    private MainController main;
    public AnchorPane buttonsPanel;
    public Label test;
    public int a =0;
    public void init(MainController main) {
        this.main = main;


        for(int x = 0;x < 10;x++){
            for(int y = 0;y < 10;y++){
                Button a = new Button(((x * 10) + y + 1) + "");
                a.setLayoutX(10 + (x * 40));
                a.setMinWidth(35);
                a.setMinHeight(35);
                a.setLayoutY(10 + (y * 40));
                EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e)
                    {
                       System.out.println(e);
                    }
                };
                a.setOnAction(event);
                this.buttonsPanel.getChildren().add(a);
            }
        }



    }


    public void miejsce(){


    }


}
