
package controller.Użytkownik;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import object.UDodatki;
import object.wybrane_miejsce;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UWybor_dodatkowController<topBtn> {

    private MainController main;
    @FXML    public ScrollPane scroll;
    @FXML    public AnchorPane anchor;
    public List<UDodatki> dodatki = new ArrayList<UDodatki>();
    public void init(MainController mainController)
    {
        main = mainController;
        this.a();
    }
    public void a() {
        try {
            ResultSet rs = main.stmt.executeQuery("SELECT id,nazwa,cena,ilosc,typ,url from dodatki ");
            int x = 0,y = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String nazwa = rs.getString("nazwa");
                int ilosc = rs.getInt("ilosc");
                double cena = rs.getDouble("cena");
                String typ = rs.getString("typ");
                String url = rs.getString("url");
                UDodatki uDodatki = new UDodatki(id, nazwa, cena, ilosc, typ, url,0 + (190 * x),0 + (120 * y),this);
                dodatki.add(uDodatki);
                x++;
                if(x > 4){
                    x = 0;
                    y++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void dalej(){
        this.main.bilet.dodatki = dodatki;
        this.main.ViewController.changeBody("UPodsumowanie");
    }
}
