package controller.Administrator;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import object.Admin_film;
import object.Admin_seans;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Date;

public class ASeansuController extends AFilmyController{
    private MainController main;

    public void init(MainController main) {
        this.main = main;
       this.PobierzDane();
       this.PobierzDane2();
    }

    @FXML public TextField tid;
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    //tabela seanse
    @FXML public TableView<Admin_seans> tableViewS;
    @FXML private TableColumn<Admin_seans, Integer> idColumn1;
    @FXML private TableColumn<Admin_seans, Date> startColumn;
    @FXML private TableColumn<Admin_seans, String> wersjaColumn;
    @FXML private TableColumn<Admin_seans, String> typColumn;
    @FXML private TableColumn<Admin_seans, Integer> id_saliColumn;
    @FXML private TableColumn<Admin_film, Integer> id_filmuColumn;
    ObservableList<Admin_seans> data = FXCollections.observableArrayList();

    //tabela filmy
    @FXML public TableView<Admin_film> tableView;
    @FXML private TableColumn<Admin_film, Integer> idColumn;
    @FXML private TableColumn<Admin_film, String> tytulColumn;
    @FXML private TableColumn<Admin_film, Integer> dlugosc;
    ObservableList<Admin_film> data1 = FXCollections.observableArrayList();




    public void powrotButton() {
        main.ViewController.changeBody("WyborOkienekAdmin");
    }

    @FXML public void initialize(){
        //tabela z seansami
        idColumn1.setCellValueFactory(new PropertyValueFactory<Admin_seans,Integer>("id"));
        startColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, Date>("start"));
        wersjaColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("wersja"));
        typColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("typ"));
        id_saliColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, Integer>("idsali"));
        id_filmuColumn.setCellValueFactory(new PropertyValueFactory<Admin_film, Integer>("idfilm"));

        // tabela z filmami
        idColumn.setCellValueFactory(new PropertyValueFactory<Admin_film,Integer>("id"));
        tytulColumn.setCellValueFactory(new PropertyValueFactory<Admin_film, String>("tytul"));
        dlugosc.setCellValueFactory(new PropertyValueFactory<Admin_film, Integer>("dlugosc"));


    }



    public void PobierzDane(){
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from seanse");
            while(rs.next()){
                data.add(new Admin_seans(rs.getInt("id"),rs.getString("start"),rs.getString("wersja"),rs.getString("typ"),rs.getInt("id_sali"),rs.getInt("id_filmu")));
            }
            tableViewS.setItems(data);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void PobierzDane2(){
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from filmy");
            while(rs.next()){
                data1.add(new Admin_film(rs.getInt("id"),rs.getString("tytul"),rs.getString("gatunek"),rs.getInt("dlugosc"),rs.getString("rezyser"),rs.getString("kraj"),rs.getString("opis"),rs.getInt("rokprodukcji"),rs.getString("typ")));
            }
            tableView.setItems(data1);

        }catch(Exception e){
            System.out.println(e);
        }
    }





    public void dodajSeans() {
        try {

            Integer ID = Integer.valueOf(tid.getText());
            String Date = t1.getText();
            String Wersja = t2.getText();
            String Typ = (t3.getText());
            Integer IDSali = Integer.valueOf(t4.getText());
            Integer IDFilm = Integer.valueOf(t5.getText());



            String query = "INSERT INTO `seanse` (`id`, `start`, `wersja`,`typ`, `id_sali`, `id_filmu`) VALUES ('"+ID+"','"+Date+"','"+Wersja+"','"+Typ+"','"+IDSali +"','"+IDFilm+"')";
            this.main.stmt.execute(query);
            odswiez();
            JOptionPane.showMessageDialog(null, "Pomyślnie dodano seans od ID: "+ ID);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void edytuj() {
            Integer id1= Integer.valueOf((tid.getText()));
            String Start = t1.getText();
            String Wersja = t2.getText();
            Integer Typ = Integer.valueOf(t3.getText());
            String IDSali = t4.getText();
            String IDFilmu = t5.getText();

            try {
                String query = "UPDATE `filmy` SET `start`= '"+Start+"', `wersja` = '"+Wersja+"', `typ` = '"+Typ+"', `id_sali` = '"+IDSali+"', `id_filmu` = '"+IDFilmu+"' WHERE `seanse`.`id`='"+id1+"'";
                this.main.stmt.execute(query);
                odswiez();
                JOptionPane.showMessageDialog(null, "Pomyślnie edytowano seans o ID: "+ id1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    public void wyczysc() {

        tid.clear();
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();
        t5.clear();
    }

    public void wyswietl() {

        if(tableViewS.getSelectionModel().getSelectedItem() != null) {
            tid.setText(String.valueOf(idColumn1.getCellData(tableViewS.getSelectionModel().getSelectedItem())));
            t1.setText(String.valueOf(startColumn.getCellData(tableViewS.getSelectionModel().getSelectedItem())));
            t2.setText(String.valueOf(wersjaColumn.getCellData(tableViewS.getSelectionModel().getSelectedItem())));
            t3.setText(typColumn.getCellData(tableViewS.getSelectionModel().getSelectedItem()));
            t4.setText(String.valueOf(id_saliColumn.getCellData(tableViewS.getSelectionModel().getSelectedItem())));
            t5.setText(String.valueOf(idColumn.getCellData(tableViewS.getSelectionModel().getSelectedItem().getId()+2))); // nie moze pobrac id filmu z innej klasy
        }

    }

    public void usunzBazy() {
            Integer Id = Integer.valueOf(tid.getText());
            try {
                String query = "DELETE FROM `seanse` WHERE `id`= '"+Id+"'";
                this.main.stmt.execute(query);
                odswiez();
                JOptionPane.showMessageDialog(null, "Pomyślnie usunięto seans o ID: "+Id);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public void odswiez(){
        data.clear();
        PobierzDane();
        }
}





