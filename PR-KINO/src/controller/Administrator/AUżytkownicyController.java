package controller.Administrator;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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


    public void usunZBazy() {
            Integer Id = Integer.valueOf(tid.getText());
            try {
                String query = "DELETE FROM `uzytkownicy` WHERE `id`= '"+Id+"'";
                this.main.stmt.execute(query);
                System.out.println("Pomyślnie usunięto uzytkownika o ID: "+Id);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    public void wyswietlDane() {

            if(tableView.getSelectionModel().getSelectedItem() != null){
            tid.setText(String.valueOf((idColumn.getCellData(tableView.getSelectionModel().getSelectedItem()))));
            t1.setText(loginColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t2.setText(hasloColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t3.setText(imieColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t4.setText(nazwiskoColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t5.setText(peselColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
            t6.setText(emailColumn.getCellData(tableView.getSelectionModel().getSelectedItem()));
        }
    }
    public void edytujDane() {
        Integer id1= Integer.valueOf((tid.getText()));
        String Login = t1.getText();
        String Haslo = t2.getText();
        String Imie = (t3.getText());
        String Nazwisko = t4.getText();
        String Pesel = t5.getText();
        String Email = t6.getText();

        try {
            String query = "UPDATE `uzytkownicy` SET `login`= '"+Login+"', `haslo` = '"+Haslo+"', `imie` = '"+Imie+"', `nazwisko` = '"+Nazwisko+"', `pesel` = '"+Pesel+"', `email`= '"+Email+"' WHERE `uzytkownicy`.`id`='"+id1+"'";
            this.main.stmt.execute(query);

            System.out.println("Pomyślnie edytowano użytkownika o ID: "+ id1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}