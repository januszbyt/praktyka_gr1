package controller.Administrator;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ADodatkiController {

    private MainController main;

    @FXML
    public TextField t1;
    @FXML
    public TextField t2;
    @FXML
    public TextField t3;
    @FXML
    public TextField t4;
    public static Connection con;
    public static Statement stmt;
    public void wpiszDane() {
        ADodatkiController af = new ADodatkiController();
        System.out.println("INFORMACJE O DODATKU");
        System.out.println("Nazwa: " + t1.getText());
        System.out.println("Typ: " + t2.getText());
        System.out.println("Cena: " + t3.getText());
        System.out.println("Ilość: " + t4.getText());
        {
            ADodatkiController af2 = new ADodatkiController();

        }

    }

    public void wyczyscPola() {
        t1.clear();
        t2.clear();
        t3.clear();
        t4.clear();

    }

    public void init(MainController main) {
        this.main = main;

        try {


        }
        catch (Exception e) {
            System.out.println(e);
        }


    }


    public void dodajDoBazy() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11412360", "sql11412360", "MLKI6a5Yh3");
            stmt = con.createStatement();
            int rs = this.main.stmt.executeUpdate("INSERT INTO `dodatki` (`id`, `nazwa`, `cena`, `ilosc`, `typ`) VALUES (NULL, 'TEST', '8.0', '10', 'cas')");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
