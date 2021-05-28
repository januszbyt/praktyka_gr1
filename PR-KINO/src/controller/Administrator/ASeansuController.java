package controller.Administrator;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;

public class ASeansuController {
    private MainController main;

    public void init(MainController main) {
        this.main = main;
    }

    public void powrotButton() {
        main.ViewController.changeBody("WyborOkienekAdmin");
    }
}





