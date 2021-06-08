
package controller.Użytkownik;
import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import object.UDodatki;
import object.wybrane_miejsce;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UWybor_dodatkowController<topBtn> {

    private MainController main;
    @FXML private Label suma;
   // @FXML    public ScrollPane scroll;
    @FXML    public AnchorPane anchor;
    public List<UDodatki> dodatki = new ArrayList<UDodatki>();
    public void init(MainController mainController)
    {
        main = mainController;
        this.a();
    }
    public void a() {
            String PESEL = this.main.bilet.WypiszPesel();
            int birthDay =  Integer.parseInt(PESEL.charAt(4) +""+ PESEL.charAt(5) + "");
            int birthYear =   Integer.parseInt(PESEL.charAt(0) +""+ PESEL.charAt(1)+ "");
            int birthMonth =   Integer.parseInt(PESEL.charAt(2)  +""+ PESEL.charAt(3)+ "");
             if (birthMonth <= 12) {
                 birthYear += 1900;
             }
            else if (birthMonth <= 32) {
                birthYear += 2000;
                birthMonth -= 20;
            } else if (birthMonth <= 52) {
                birthYear += 2100;
                birthMonth -= 40;
            } else if (birthMonth <= 72) {
                birthYear += 2200;
                birthMonth -= 60;
            } else if (birthMonth <= 92) {
                birthYear += 1800;
                birthMonth -= 80;
            }



    int rok = Calendar.getInstance().get(Calendar.YEAR) - birthYear;
System.out.println(rok);
        try {
            ResultSet rs = main.stmt.executeQuery("SELECT id,nazwa,cena,ilosc,typ,url,pelnoletni from dodatki ");
            int x = 0,y = 0;
            while (rs.next()) {
                System.out.println(rs.getString("nazwa") +"   " +(rok >= 18));
                if(rs.getInt("pelnoletni") == 0 || (rs.getInt("pelnoletni") == 1 && rok >= 18)){
                int id = rs.getInt("id");
                String nazwa = rs.getString("nazwa");
                int ilosc = rs.getInt("ilosc");
                double cena = rs.getDouble("cena");
                String typ = rs.getString("typ");
                String url = rs.getString("url");
                UDodatki uDodatki = new UDodatki(id, nazwa, cena, ilosc, typ, url,0 + (190 * x),50 + (170 * y),this);
                dodatki.add(uDodatki);
                x++;
                if(x > 4){
                    x = 0;
                    y++;
                }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void obliczSume(){
        double suma_za_dodatki = 0;
        for (int i = 0; i <dodatki.size(); i++)
        {
            if(dodatki.get(i).ile!=0){
                suma_za_dodatki = suma_za_dodatki + (dodatki.get(i).getCena()*dodatki.get(i).ile);
            }
        }
        this.suma.setText(suma_za_dodatki+"zł");
    }
    public void dalej(){
        this.main.bilet.dodatki = dodatki;
        this.main.ViewController.changeBody("UPodsumowanie");
    }
}
