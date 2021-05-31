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
import object.Admin_film;
import object.Admin_seans;

import java.sql.ResultSet;

public class ASeansuController {
    private MainController main;

    public void init(MainController main) {
        this.main = main;
      //  this.PobierzDane();
    }

    @FXML public TextField tid;
    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;

    @FXML public TableView<Admin_seans> tableView;
    @FXML private TableColumn<Admin_seans, Integer> idColumn;
    @FXML private TableColumn<Admin_seans, String> dataColumn;
    @FXML private TableColumn<Admin_seans, String> wersjaColumn;
    @FXML private TableColumn<Admin_seans, String> typColumn;
    @FXML private TableColumn<Admin_seans, Integer> idsaliColumn;
    @FXML private TableColumn<Admin_seans, Integer> idfilmuColumn;
    ObservableList<Admin_film> data = FXCollections.observableArrayList();


    public void powrotButton() {
        main.ViewController.changeBody("WyborOkienekAdmin");
    }

    @FXML public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans,Integer>("id"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("data"));
        wersjaColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("wersja"));
        typColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("typ"));
        idsaliColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, Integer>("idsali"));
        idfilmuColumn.setCellValueFactory(new PropertyValueFactory<Admin_seans, Integer>("idfilmu"));
    }


    /*
    public void PobierzDane(){
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from seanse");
            while(rs.next()){
                data.add(new Admin_seans(rs.getInt("id"),rs.getString("data"),rs.getString("wersja"),rs.getString("typ"),rs.getInt("idsali"),rs.getInt("idfilmu")));
            }
            tableView.setItems(data);

        }catch(Exception e){
            System.out.println(e);
        }
    }

     */





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
            System.out.println("Pomyślnie dodano seans o ID: "+ ID);

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
                //odswiez();
                System.out.println("Pomyślnie edytowano seans o ID: "+ id1);
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
    }

    public void usunzBazy() {
            Integer Id = Integer.valueOf(tid.getText());
            try {
                String query = "DELETE FROM `seanse` WHERE `id`= '"+Id+"'";
                this.main.stmt.execute(query);
                //odswiez();
                System.out.println("Pomyślnie usunięto seans o ID: "+Id);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
}





