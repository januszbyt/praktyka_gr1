package controller.Administrator;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import object.Admin_dodatki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ADodatkiController {

    public static Connection con;
    public static Statement stmt;
    private MainController main;

    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TableView<Admin_dodatki> tableView;
    @FXML private TableColumn<Admin_dodatki, String> nazwaColumn;
    @FXML private TableColumn<Admin_dodatki, String> typColumn;
    @FXML private TableColumn<Admin_dodatki, Double> cenaColumn;
    @FXML private TableColumn<Admin_dodatki, Integer> iloscColumn;
    ObservableList<Admin_dodatki> data = FXCollections.observableArrayList();

    @FXML public void initialize(){
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, String>("Nazwa"));
        typColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, String>("Typ"));
        cenaColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, Double>("Cena"));
        iloscColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, Integer>("Ilosc"));
    }

    public void wpiszDane() {
        ADodatkiController af = new ADodatkiController();
        System.out.println("INFORMACJE O DODATKU");
        System.out.println("Nazwa: " + t1.getText());
        System.out.println("Typ: " + t2.getText());
        System.out.println("Cena: " + t3.getText());
        System.out.println("Ilość: " + t4.getText());
        {
            ADodatkiController af2 = new ADodatkiController();

        }

    }

    public void wyczyscPola() {
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();

    }

    public void init(MainController main) {
        this.main = main;
        this.PobierzDane();
    }
        public void PobierzDane(){
            try{
                ResultSet rs=  this.main.stmt.executeQuery("select * from dodatki");
                while(rs.next()){
                    data.add(new Admin_dodatki(rs.getInt(1),rs.getString("Nazwa"),rs.getString("Typ"),rs.getDouble("Cena"),rs.getInt("Ilosc")));
                }
                tableView.setItems(data);

            }catch(Exception e){
                System.out.println(e);
            }
        }




    /*
    public void Dodatki( String nazwa,String typ,int cena,String ilosc)
    {
        this.nazwa=nazwa;
        this.typ=typ;
        this.cena=cena;
        this.ilosc=ilosc;

    }

     */


    public void dodajDoBazy() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11412360", "sql11412360", "MLKI6a5Yh3");
            stmt = con.createStatement();
            int rs = this.main.stmt.executeUpdate("INSERT INTO `dodatki` ( `nazwa`, `typ` , `cena`, `ilosc`) VALUES ( 't1', 't2', 't3', 't4')");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
