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

    @FXML
    public TextField t1;
    @FXML
    public TextField t2;
    @FXML
    public TextField t3;
    @FXML
    public TextField t4;
    @FXML
    public TableView<Admin_dodatki> tableView;
    @FXML
    public TextField t5;
    @FXML public TextField tid;
    @FXML
    private TableColumn<Admin_dodatki, String> idColumn;
    @FXML
    private TableColumn<Admin_dodatki, String> nazwaColumn;
    @FXML
    private TableColumn<Admin_dodatki, String> typColumn;
    @FXML
    private TableColumn<Admin_dodatki, Double> cenaColumn;
    @FXML
    private TableColumn<Admin_dodatki, Integer> iloscColumn;
    ObservableList<Admin_dodatki> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki,String>("Id"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, String>("Nazwa"));
        typColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, String>("Typ"));
        cenaColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, Double>("Cena"));
        iloscColumn.setCellValueFactory(new PropertyValueFactory<Admin_dodatki, Integer>("Ilosc"));
        t1.setPromptText("Wpisz nazwę dodatku");
        t2.setPromptText("Wpisz typ dodatku");
        t3.setPromptText("Wpisz cene dodatku");
        t4.setPromptText("Wpisz ilość dodatku");
        t5.setPromptText("Wpisz nazwę dodatku");

    }





    public void wpiszDane() {
        if(tableView.getSelectionModel().getSelectedItem() != null) {
            tid.setText(String.valueOf(idColumn.getCellData(tableView.getSelectionModel().getSelectedItem())));
            t1.setText(nazwaColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t2.setText(typColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t3.setText(String.valueOf(Double.valueOf(cenaColumn.getCellData(tableView.getSelectionModel().getSelectedItem()))));
            t4.setText(String.valueOf(iloscColumn.getCellData(tableView.getSelectionModel().getSelectedItem())));
        ADodatkiController af = new ADodatkiController();
        System.out.println("INFORMACJE O DODATKU");
        System.out.println("Nazwa: " + t1.getText());
        System.out.println("Typ: " + t2.getText());
        System.out.println("Cena: " + t3.getText());
        System.out.println("Ilość: " + t4.getText());
        }
    }

    public void wyczyscPola() {
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();

    }
    public void exit() {
        main.ViewController.changeBody("WyborOkienekAdmin");
    }

    public void init(MainController main) {
        this.main = main;
        this.PobierzDane();
    }

    public void PobierzDane() {
        try {
            ResultSet rs = this.main.stmt.executeQuery("select * from dodatki");
            while (rs.next()) {
                data.add(new Admin_dodatki(rs.getInt("Id"), rs.getString("Nazwa"), rs.getString("Typ"), rs.getDouble("Cena"), rs.getInt("Ilosc")));
            }
            tableView.setItems(data);

        } catch (Exception e) {
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
            String nazwa = t1.getText();
            String typ = t2.getText();
            Double cena = Double.valueOf(t3.getText());
            Integer ilosc = Integer.valueOf(t4.getText());

            int rs = this.main.stmt.executeUpdate("INSERT INTO `dodatki` ( `id`,`nazwa`, `typ` , `cena`, `ilosc`) VALUES ( NULL ,'" + nazwa + "', '" + typ + "','" + cena + "', '" + ilosc + "')");
            System.out.println("Pomyślnie dodano Dodatek  ");
            odswiez();`
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void usunZBazy() {


        try {
            String delete = t5.getText();
            String query = "DELETE FROM `dodatki` WHERE `nazwa`= '" + delete + "'";
            this.main.stmt.execute(query);
            System.out.println("Pomyślnie usunięto dodatek o nazwie: " + delete);
            odswiez();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void edytujDane() {
        String nazwa = t1.getText();
        String typ = t2.getText();
        Double cena = Double.valueOf(t3.getText());
        Integer ilosc = Integer.valueOf(t4.getText());
        Integer id1= Integer.valueOf((tid.getText()));
        try {
            String query = "UPDATE `dodatki` SET `nazwa` = '"+nazwa+"', `cena` = '"+cena+"', `ilosc` = '"+ilosc+"', `typ` = '"+typ+"' WHERE `dodatki`.`id`='"+id1+"'";
            System.out.println(query);
            this.main.stmt.execute(query);
            System.out.println("Pomyślnie edytowano film o ID: " + id1);
            odswiez();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void odswiez(){
        data.clear();
        PobierzDane();

    }

}