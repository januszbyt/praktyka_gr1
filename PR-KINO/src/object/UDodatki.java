package object;

import controller.Użytkownik.UWybor_dodatkowController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;



public class UDodatki {

    private int id;
    private String nazwa;
    private double cena;
    private int ilosc;
    private String typ;
    private String url;
    private Button button;
    private Button plus;
    private Button minus;
    private Label iloscLabel;
    private Label cena_label;
    public int ile = 0;
    private int x;
    private int y;
    private controller.Użytkownik.UWybor_dodatkowController controller;
    public UDodatki(int ID,String Nazwa,double Cena,int Ilosc,String Typ,
                    String Url,int x, int y,UWybor_dodatkowController a){
        this.controller = a;
        this.id=ID;
        this.nazwa=Nazwa;
        this.cena=Cena;
        this.ilosc=Ilosc;
        this.typ=Typ;
        this.url=Url;
        this.x = y;
        this.y = y;
        if(url != null) {
            Image image = new Image(url, 50, 50, false, true);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setX(x + 20);
            imageView.setY(y - 20);
            this.controller.anchor.getChildren().add(imageView);
        }
        Label napis = new Label();
        napis.setLayoutY(y+30);
        napis.setLayoutX(x);
        napis.setStyle("-fx-text-fill: white; -fx-font-size: 10px;");
        napis.setText(nazwa);
        this.controller.anchor.getChildren().add(napis);


        Button plusek = new Button();
        plusek.setLayoutY(y+50);
        plusek.setLayoutX(x + 0);
        plusek.setText("+");
        this.controller.anchor.getChildren().add(plusek);

        Button minusek = new Button();
        minusek.setLayoutY(y+50);
        minusek.setLayoutX(x + 60);
        minusek.setText("-");
        this.controller.anchor.getChildren().add(minusek);

        cena_label = new Label();
        cena_label.setLayoutY(y+60);
        cena_label.setLayoutX(x+40);
        cena_label.setStyle("-fx-text-fill: white; -fx-font-size: 10px;");
        cena_label.setText(cena+"zł");

        iloscLabel = new Label();
        iloscLabel.setLayoutY(y+50);
        iloscLabel.setLayoutX(x+40);
        iloscLabel.setStyle("-fx-text-fill: white; -fx-font-size: 10px;");
        iloscLabel.setText("0");
        this.controller.anchor.getChildren().add(iloscLabel);





        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                iloscLabel.setText(String.valueOf(++ile));
            }
        };
        plusek.setOnAction(event);



        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if(ile >= 1){
                iloscLabel.setText(String.valueOf(--ile));
                }
            }
        };
        minusek.setOnAction(event2);
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public String getTyp() {
        return typ;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
