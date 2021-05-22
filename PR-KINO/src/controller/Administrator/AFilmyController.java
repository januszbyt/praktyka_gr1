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
import java.sql.RowId;
import java.sql.SQLException;

public class AFilmyController {
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextArea t6;
    @FXML public TextField t7;
    @FXML public TextField t8;
    @FXML public TextField tid;
    @FXML public TableView<Admin_film> tableView;
    @FXML private TableColumn<Admin_film, Integer> idColumn;
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
        idColumn.setCellValueFactory(new PropertyValueFactory<Admin_film,Integer>("id"));
        tytulColumn.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("tytul"));
        gatunekColumn.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("gatunek"));
        dlugosc.setCellValueFactory(new PropertyValueFactory<Admin_film, Integer>("dlugosc"));
        rezyser.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("rezyser"));
        kraj.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("kraj"));
        opis.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("opis"));
        rokprodukcji.setCellValueFactory(new PropertyValueFactory<Admin_film, Integer>("rokprodukcji"));
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
                data.add(new Admin_film(rs.getInt("id"),rs.getString("tytul"),rs.getString("gatunek"),rs.getInt("dlugosc"),rs.getString("rezyser"),rs.getString("kraj"),rs.getString("opis"),rs.getInt("rokprodukcji"),rs.getString("typ")));
            }
            tableView.setItems(data);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void wpiszDane() {
        AFilmyController af = new AFilmyController();
        /*
        System.out.println("INFORMACJE O FILMIE");
        System.out.println("ID: " + tid.getText());
        System.out.println("Tytul: " + t1.getText());
        System.out.println("Gatunek: " + t2.getText());
        System.out.println("Dlugosc filmu: " + t3.getText());
        System.out.println("Rezyser: " + t4.getText());
        System.out.println("Kraj: " + t5.getText());
        System.out.println("Opis: " + t6.getText());
        System.out.println("Rok produkcji: " + t7.getText());
        System.out.println("Typ: " + t8.getText());
        System.out.println("");
        */

        //Integer s = idColumn.getCellData(0); //ustawia textbox id na 1 wiersz idcolumn
        //String s1= tytulColumn.getCellData(0);
        //tid.setText(s.toString()); // wyswietla id 1 filmu
        //t1.setText(s1); // wyswietla tytul 1 filmu;

        //dziala ale czyta 1 rekord do przodu zamiast id=1 czyta id=2 choc kliknieto 1
            if(tableView.getSelectionModel().getSelectedItem() != null) {
                tid.setText(String.valueOf(idColumn.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1)));
                t1.setText(tytulColumn.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1));
                t2.setText(gatunekColumn.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1));
                t3.setText(String.valueOf(dlugosc.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1)));
                t4.setText(rezyser.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1));
                t5.setText(kraj.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1));
                t6.setText(opis.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1));
                t7.setText(String.valueOf(rokprodukcji.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1)));
                t8.setText(typ.getCellData(tableView.getSelectionModel().getSelectedItem().getId()-1));
            }

    }



    public void wyczyscPola(){
        tid.clear();
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
            Integer ID = Integer.valueOf(tid.getText());
            String Tytul = t1.getText();
            String Gatunek = t2.getText();
            Integer Dlugosc_filmu = Integer.valueOf(t3.getText());
            String Rezyser = t4.getText();
            String Kraj = t5.getText();
            String Opis = t6.getText();
            Integer Rok_produkcji = Integer.valueOf(t7.getText());
            String Typ = t8.getText();

            String query = "INSERT INTO `filmy` (`id`, `tytul`, `gatunek`, `dlugosc`, `rezyser`, `kraj`,`opis`,`rokprodukcji`,`typ`) VALUES ('"+ID+"','"+Tytul+"','"+Gatunek+"','"+Dlugosc_filmu+"','"+Rezyser+"','"+Kraj+"','"+Opis+"','"+Rok_produkcji+"','"+Typ+"')";
            this.main.stmt.execute(query);
            System.out.println("Pomyślnie dodano film o ID: "+ ID);
        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public void usunZBazy() {
        Integer Id = Integer.valueOf(tid.getText());
        try {
            String query = "DELETE FROM `filmy` WHERE `id`= '"+Id+"'";
            this.main.stmt.execute(query);
            System.out.println("Pomyślnie usunięto film o ID: "+Id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void odswiez(){

    }
}

