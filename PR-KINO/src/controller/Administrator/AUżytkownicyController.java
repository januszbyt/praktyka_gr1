package controller.Administrator;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import object.Admin_film;
import object.Uzytkownicy;

public class AUżytkownicyController {

    @FXML public TextField t1;
    @FXML public TextField t2;
    @FXML public TextField t3;
    @FXML public TextField t4;
    @FXML public TextField t5;
    @FXML public TextField t6;
    @FXML public TextField tid;
    @FXML public TableView<Uzytkownicy> tableView;

    /*private Integer id;
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String email;*/
    @FXML private TableColumn<Uzytkownicy, Integer> idColumn;
    @FXML private TableColumn<Uzytkownicy, String> loginColumn;
    @FXML private TableColumn<Uzytkownicy, String> hasloColumn;
    @FXML private TableColumn<Uzytkownicy, String> imieColumn;
    @FXML private TableColumn<Uzytkownicy, String> nazwiskoColumn;
    @FXML private TableColumn<Uzytkownicy, String> peselColumn;
    @FXML private TableColumn<Uzytkownicy, String> emailColumn;

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
    }
    
}
