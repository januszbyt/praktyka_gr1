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
import object.Uzytkownicy;

import java.sql.ResultSet;

public class AUżytkownicyController {

    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextField t6;
    @FXML public TextField tid;
    @FXML public TableView<Uzytkownicy> tableView;
    @FXML private TableColumn<Uzytkownicy, Integer> idColumn;
    @FXML private TableColumn<Uzytkownicy, String> loginColumn;
    @FXML private TableColumn<Uzytkownicy, String> hasloColumn;
    @FXML private TableColumn<Uzytkownicy, String> imieColumn;
    @FXML private TableColumn<Uzytkownicy, String> nazwiskoColumn;
    @FXML private TableColumn<Uzytkownicy, String> peselColumn;
    @FXML private TableColumn<Uzytkownicy, String> emailColumn;
    ObservableList<Uzytkownicy> data = FXCollections.observableArrayList();

    @FXML public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy,Integer>("id"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy, String>("login"));
        hasloColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy, String>("haslo"));
        imieColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy, String>("imie"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy, String>("nazwisko"));
        peselColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy, String>("pesel"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Uzytkownicy, String>("email"));
    }


    private MainController main;
    public void init(MainController main){
        this.main = main;
        this.PobierzDane();
    }

    public void PobierzDane(){
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from uzytkownicy");
            while(rs.next()){
                data.add(new Uzytkownicy(rs.getInt("id"),rs.getString("login"),rs.getString("haslo"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("pesel"),rs.getString("email")));
            }
            tableView.setItems(data);

        }catch(Exception e){
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
        t6.clear();
    }

    public void dodajDoBazy() {
    }

    public void usunZBazy() {
    }

    public void wyswietlDane() {
    }
}
