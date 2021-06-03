package controller.Użytkownik;

import controller.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import object.Admin_film;
import object.Admin_seans;

import java.sql.ResultSet;

public class UWybur_seansuController {
    private MainController main;

    @FXML
    public TableView<Admin_seans> tableViewSeans;
    @FXML private TableColumn<Admin_seans, String> startCol;
    @FXML private TableColumn<Admin_seans, String> wersjaCol;
    @FXML private TableColumn<Admin_seans, String> typCol;

    ObservableList<Admin_seans> data = FXCollections.observableArrayList();


    @FXML public void initialize(){
        startCol.setCellValueFactory(new PropertyValueFactory<Admin_seans,String>("start"));
        wersjaCol.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("wersja"));
        typCol.setCellValueFactory(new PropertyValueFactory<Admin_seans, String>("typ"));
    }
//tak
    public void PobierzDane(){
        Integer id = this.main.bilet.getIdFilm();
        try{
            ResultSet rs=  this.main.stmt.executeQuery("select * from seanse where `id`= id");
            while(rs.next()){
                data.add(new Admin_seans(rs.getInt("id"),rs.getString("start"),rs.getString("wersja"),rs.getString("typ"),rs.getInt("id_sali"),rs.getInt("id_filmu")));
            }
            tableViewSeans.setItems(data);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void init(MainController main) {
        this.main = main;
        this.PobierzDane();
    }


    public void wybierzSeans() {

        if(tableViewSeans.getSelectionModel().getSelectedItem() != null) {
            startCol.getCellData(tableViewSeans.getSelectionModel().getSelectedItem());
            wersjaCol.getCellData(tableViewSeans.getSelectionModel().getSelectedItem());
            typCol.getCellData(tableViewSeans.getSelectionModel().getSelectedItem());
        }
        this.main.bilet.setIdseansu( id seansu );
        this.main.ViewController.changeBody("nazwa kolejnego panelu");

    }
}
