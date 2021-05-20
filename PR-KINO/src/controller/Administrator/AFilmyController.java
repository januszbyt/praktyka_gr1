package controller.Administrator;


import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.control.TableColumn;
import object.Admin_film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AFilmyController {
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextArea t6;
    @FXML public TextField t7;
    @FXML public TextField t8;
    @FXML public TableView tableView;
    @FXML public void initialize(){

        final ObservableList<Admin_film> data = FXCollections.observableArrayList();



        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from filmy");
            int i = 0;
            while(rs.next()){
                data.add(new Admin_film(rs.getString("tytul"),rs.getString("gatunek"),rs.getInt("dlugosc"),rs.getString("rezyser"),rs.getString("kraj"),rs.getString("opis"),rs.getInt("rok_produkcji"),rs.getString("typ")));
                 i++;

            }
            tableView.setItems(data);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static Connection con;
    public static Statement stmt;
    private MainController main;
    public void init(MainController main){

        this.main = main;
    }

    public void wpiszDane() {
        AFilmyController af = new AFilmyController();
        System.out.println("INFORMACJE O FILMIE");
        System.out.println("Tytul: " + t1.getText());
        System.out.println("Gatunek: " + t2.getText());
        System.out.println("Dlugosc filmu: " + t3.getText());
        System.out.println("Rezyser: " + t4.getText());
        System.out.println("Kraj: " + t5.getText());
        System.out.println("Opis: " + t6.getText());
        System.out.println("Rok produkcji: " + t7.getText());
        System.out.println("Typ: " + t8.getText());
        System.out.println("");


    }




    public void wyczyscPola(){
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
        t6.clear();
        t7.clear();
        t8.clear();

    }

    public void dodajDoBazy() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11412360", "sql11412360", "MLKI6a5Yh3");
            stmt = con.createStatement();
            int rs = this.main.stmt.executeUpdate("INSERT INTO `filmy` (`id`, `tytul`, `gatunek`, `dlugosc`, `rezyser`, `kraj`,`opis`,`rok_produkcji`,`typ`) VALUES (NULL, 'TEST', 'testowy', 'komedia', '150','paczino','polska','krotki opis','1999','2d',NULL)");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void usunZBazy() {

    }
}

