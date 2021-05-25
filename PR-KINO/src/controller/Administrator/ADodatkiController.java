package controller.Administrator;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import object.Admin_dodatki;
import object.Admin_film;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class ADodatkiController {


    @FXML
    public TextField t1;
    @FXML
    public TextField t2;
    @FXML
    public TextField t3;
    @FXML
    public TextField t4;
    @FXML
    public TextField t5;

    @FXML
    public TextField tid;
    @FXML
    private TableColumn<Admin_dodatki, Integer> idColumn;
    @FXML
    public TableView<Admin_dodatki> tableView;
    @FXML
    private TableColumn<Admin_dodatki, String> nazwaColumn;
    @FXML
    private TableColumn<Admin_dodatki, String> typColumn;
    @FXML
    private TableColumn<Admin_dodatki, Integer> cena;
    @FXML
    private TableColumn<Admin_dodatki, Integer> ilosc;

    ObservableList<Admin_dodatki> data = FXCollections.observableArrayList();

    @FXML public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki,Integer>("id"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, String>("nazwa"));
        typColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, String>("typ"));
        cena.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, Integer>("cena"));
        ilosc.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, Integer>("ilosc"));

    }

    public void wpiszDane() {
        /*
        ADodatkiController af = new ADodatkiController();
        System.out.println("INFORMACJE O DODATKU");
        System.out.println("Nazwa: " + t1.getText());
        System.out.println("Typ: " + t2.getText());
        System.out.println("Cena: " + t3.getText());
        System.out.println("Ilość: " + t4.getText()); */
        //{
         //   ADodatkiController af2 = new ADodatkiController();

        //}
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            tid.setText(String.valueOf(idColumn.getCellData(tableView.getSelectionModel().getSelectedItem().getId() - 1)));
            t1.setText(nazwaColumn.getCellData(tableView.getSelectionModel().getSelectedItem().getId() - 1));
            t2.setText(typColumn.getCellData(tableView.getSelectionModel().getSelectedItem().getId() - 1));
            t3.setText(String.valueOf(cena.getCellData(tableView.getSelectionModel().getSelectedItem().getId() - 1)));
            t4.setText(String.valueOf(ilosc.getCellData(tableView.getSelectionModel().getSelectedItem().getId() - 1)));
        }

    }

    public void wyczyscPola() {


        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();

    }

    private MainController main;

    public void init(MainController main) {
        this.main = main;

        this.main = main;
        this.PobierzDane();
    }
    public void PobierzDane(){
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from dodatki");
            while(rs.next()){
                data.add(new Admin_dodatki(rs.getInt("id"),rs.getString("nazwa"),rs.getString("typ"),rs.getInt("cena"),rs.getInt("ilosc")));
            }
            tableView.setItems(data);
            System.out.println("INFORMACJE O DODATdKU");
        }catch(Exception e){
            System.out.println(e);
        }
    }






    public void dodajDoBazy() {


        try {
            String nazwa = t1.getText();
            String typ = t2.getText();
            Integer cena = Integer.valueOf(t3.getText());
            Integer ilosc = Integer.valueOf(t4.getText());

            int rs = this.main.stmt.executeUpdate("INSERT INTO `dodatki` ( `id`,`nazwa`, `typ` , `cena`, `ilosc`) VALUES ( NULL ,'" + nazwa + "', '" + typ + "','" + cena + "', '" + ilosc + "')");
            System.out.println("Pomyślnie dodano Dodatek  ");
        } catch (Exception e) {
            System.out.println(e);
        }




    }
        public void usunZBazy()
    {


            try {
                String delete = t5.getText();
                String query = "DELETE FROM `dodatki` WHERE `nazwa`= '"+delete+"'";
                this.main.stmt.execute(query);
                System.out.println("Pomyślnie usunięto Dodatek o nazwie: "+delete);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }



