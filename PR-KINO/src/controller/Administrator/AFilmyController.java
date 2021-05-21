package controller.Administrator;


import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import object.Admin_film;

import java.sql.ResultSet;

public class AFilmyController {
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextArea t6;
    @FXML public TextField t7;
    @FXML public TextField t8;
    @FXML public TableView<Admin_film> tableView;
    @FXML private TableColumn<Admin_film, String> tytulColumn;
    @FXML private TableColumn<Admin_film, String> gatunekColumn;
    @FXML private TableColumn<Admin_film, Integer> dlugosc;
    @FXML private TableColumn<Admin_film, String> rezyser;
    @FXML private TableColumn<Admin_film, String> kraj;
    @FXML private TableColumn<Admin_film, String> opis;
    @FXML private TableColumn<Admin_film, Integer> rokprodukcji;
    @FXML private TableColumn<Admin_film, String> typ;
    ObservableList<Admin_film> data = FXCollections.observableArrayList();



    @FXML public void initialize(){
        tytulColumn.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("tytul"));
        gatunekColumn.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("gatunek"));
        dlugosc.setCellValueFactory(new PropertyValueFactory<Admin_film, Integer>("dlugosc"));
        rezyser.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("rezyser"));
        kraj.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("kraj"));
        opis.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("opis"));
        //rokprodukcji.setCellValueFactory(new PropertyValueFactory<Admin_film, Integer>("rokprodukcji"));
        typ.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("typ"));

    }

    private MainController main;
    public void init(MainController main){
        this.main = main;
        this.PobierzDane();
    }

    public void PobierzDane(){
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from filmy");
            while(rs.next()){
                data.add(new Admin_film(rs.getString("tytul"),rs.getString("gatunek"),rs.getInt("dlugosc"),rs.getString("rezyser"),rs.getString("kraj"),rs.getString("opis"),5555,rs.getString("typ")));
            }
            tableView.setItems(data);
        }catch(Exception e){
            System.out.println(e);
        }
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
        /*try {
           int rs = this.main.stmt.executeUpdate("INSERT INTO `filmy` (`id`, `tytul`, `gatunek`, `dlugosc`, `rezyser`, `kraj`,`opis`,`rokprodukcji`,`typ`) VALUES (NULL, 'TEST', 'testowy', 'komedia', '150','paczino','polska','krotki opis','1999','2d')");

        } catch (Exception e) {
            System.out.println(e);
        }*/
    }

    public void usunZBazy() {

    }
}

