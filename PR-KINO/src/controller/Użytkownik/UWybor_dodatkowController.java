package controller.Użytkownik;

import controller.MainController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import object.UDodatki;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class UWybor_dodatkowController<topBtn> {

    @FXML
    private ComboBox przekaskiComboBox;

    @FXML
    private ComboBox napojeComboBox;

    @FXML
    private TextField przekaskiIlosc;

    @FXML
    private TextField napojeIlosc;

    @FXML
    private TextField przekaskiCena;

    @FXML
    private TextField napojeCena;

    @FXML
    private Button przekaskiAddButton;

    @FXML
    private Button przekaskiSubstractButton;

    @FXML
    private Button napojeAddButton;

    @FXML
    private Button napojeSubstractButton;

    @FXML
    private TextField razemCena;

    private Statement stmt;

    List<UDodatki> dodatki = new ArrayList<>();
    UDodatki wybranaPrzekaska;
    UDodatki wybranyNapoj;

    public void init(MainController mainController) {
        stmt = mainController.stmt;
        this.initialize();
    }

    public void initialize() {
        przekaskiComboBox.getItems().add("- - -");
        napojeComboBox.getItems().add("- - -");

        try {
            ResultSet rs = stmt.executeQuery("SELECT id,nazwa,cena,ilosc,typ,url from dodatki ");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nazwa = rs.getString("nazwa");
                int ilosc = rs.getInt("ilosc");
                double cena= rs.getDouble("cena");
                String typ = rs.getString("typ");
                String url = rs.getString("url");

                UDodatki uDodatki = new UDodatki(id,nazwa,cena,ilosc,typ,url);
                dodatki.add(uDodatki);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for(UDodatki uDodatki : dodatki){
            if(uDodatki.getTyp().equals("Przekaski")){
                przekaskiComboBox.getItems().add(uDodatki.getNazwa());
            }
            if(uDodatki.getTyp().equals("Napoje")) {
                napojeComboBox.getItems().add(uDodatki.getNazwa());
            }
        }
    }
    @FXML
    private void przekaskiComboBoxAction() {
        if(przekaskiComboBox.getSelectionModel().getSelectedItem().equals("- - -")) {
            przekaskiIlosc.setText("");
            przekaskiCena.setText("");
            przekaskiAddButton.setDisable(true);
            przekaskiSubstractButton.setDisable(true);
            if(napojeIlosc.getText().length()==0){
                razemCena.setText(" ");
            }
            else {
                razemCena.setText(Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
        }
        else {
            for(UDodatki przekaska : dodatki){
                if( przekaska.getNazwa().equals(przekaskiComboBox.getSelectionModel().getSelectedItem())){
                    wybranaPrzekaska = przekaska;
                    break;
                }
            }
            przekaskiIlosc.setText("0");
            przekaskiCena.setText("0 zł");
            przekaskiAddButton.setDisable(false);
            przekaskiSubstractButton.setDisable(false);
        }
    }

    @FXML
    private void napojeComboBoxAction() {
        if(napojeComboBox.getSelectionModel().getSelectedItem().equals("- - -")) {
            napojeIlosc.setText("");
            napojeCena.setText("");
            napojeAddButton.setDisable(true);
            napojeSubstractButton.setDisable(true);
            if(przekaskiIlosc.getText().length()==0){
                razemCena.setText(" ");
            }
            else {
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + " zł");
            }
        }
        else {
            for(UDodatki napoj : dodatki){
                if( napoj.getNazwa().equals(napojeComboBox.getSelectionModel().getSelectedItem())){
                    wybranyNapoj = napoj;
                    break;
                }
            }
            napojeIlosc.setText("0");
            napojeCena.setText("0 zł");
            napojeAddButton.setDisable(false);
            napojeSubstractButton.setDisable(false);


        }
    }

    @FXML
    private void przekaskiAddButtonAction(){
        if(Integer.parseInt(przekaskiIlosc.getText()) >= wybranaPrzekaska.getIlosc()){

        }else {
            int ilosc = Integer.parseInt(przekaskiIlosc.getText())+1;
            przekaskiIlosc.setText(String.valueOf(ilosc));
            double cena = Math.round((ilosc*wybranaPrzekaska.getCena()) * 100.0) / 100.0;
            przekaskiCena.setText(cena + " zł");
            if(napojeIlosc.getText().length()==0){
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + " zł");
            }
            else {
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
        }
    }

    @FXML
    private void przekaskiSubstractButtonAction(){
        if(Integer.parseInt(przekaskiIlosc.getText()) == 0){

        }else {
            int ilosc = Integer.parseInt(przekaskiIlosc.getText())-1;
            przekaskiIlosc.setText(String.valueOf(ilosc));
            double cena = Math.round((ilosc*wybranaPrzekaska.getCena()) * 100.0) / 100.0;
            przekaskiCena.setText(cena + " zł");

            if(napojeIlosc.getText().length()==0){
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + " zł");
            }
            else {
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
        }
    }
    @FXML
    private void napojeAddButtonAction(){
        if(Integer.parseInt(napojeIlosc.getText()) >= wybranyNapoj.getIlosc()){

        }else {
            int ilosc = Integer.parseInt(napojeIlosc.getText())+1;
            napojeIlosc.setText(String.valueOf(ilosc));
            double cena = Math.round((ilosc*wybranyNapoj.getCena()) * 100.0) / 100.0;
            napojeCena.setText(cena + " zł");

            if(przekaskiIlosc.getText().length()==0){
                razemCena.setText(Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
            else {
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
        }
    }
    @FXML
    private void napojeSubstractButtonAction(){
        if(Integer.parseInt(napojeIlosc.getText()) == 0){

        }else {
            int ilosc = Integer.parseInt(napojeIlosc.getText())-1;
            napojeIlosc.setText(String.valueOf(ilosc));
            double cena = Math.round((ilosc*wybranyNapoj.getCena()) * 100.0) / 100.0;
            napojeCena.setText(cena + " zł");

            if(przekaskiIlosc.getText().length()==0){
                razemCena.setText(Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
            else {
                razemCena.setText(Double.parseDouble(przekaskiCena.getText().split(" ")[0]) + Double.parseDouble(napojeCena.getText().split(" ")[0]) + " zł");
            }
        }
    }

    @FXML
    private void dalejButtonAction(){
        if(wybranyNapoj.getNazwa().contains("Piwo") && Integer.parseInt(napojeIlosc.getText())>0){

            Dialog dialog = new Dialog<>();
            dialog.setTitle("Weryfikacja wieku");

            // Set the button types.

            dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20, 150, 10, 10));

            TextField dzien = new TextField();
            dzien.setPrefColumnCount(2);
            dzien.setPromptText("DD");

            TextField miesiac = new TextField();
            miesiac.setPromptText("MM");
            miesiac.setPrefColumnCount(2);

            TextField rok = new TextField();
            rok.setPromptText("YYYY");
            rok.setPrefColumnCount(4);

            gridPane.add(new Label("Dzień:"), 0, 0);
            gridPane.add(new Label("Miesiąc:"), 1, 0);
            gridPane.add(new Label("Rok:"), 2, 0);
            gridPane.add(dzien, 0, 1);
            gridPane.add(miesiac, 1, 1);
            gridPane.add(rok, 2, 1);

            dialog.getDialogPane().setContent(gridPane);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == ButtonType.OK) {
                    int d = 0,m = 0,y = 0;
                    try{
                        d = Integer.parseInt(dzien.getText());
                        m = Integer.parseInt(miesiac.getText());
                        y = Integer.parseInt(rok.getText());
                    }catch (NumberFormatException e){
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Wpisz poprawną datę urodzenia",  ButtonType.OK);
                        alert.showAndWait();
                    }

                    int aktualnyRok  = Calendar.getInstance().get(Calendar.YEAR);
                    if((d>0 && d<31) && (m>0 && m <=12) && (y>0 && y<aktualnyRok)){
                        LocalDate data_urodzenia =  LocalDate.of(y, d, m);
                        LocalDate data_aktualna = LocalDate.now();
                        long wiek = ChronoUnit.YEARS.between(data_urodzenia, data_aktualna);
                        if(wiek<18){
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Jesteś za młody aby kupić piwo!",  ButtonType.OK);
                            alert.showAndWait();
                        }
                        else {
                            //Przejdź do podsumowania
                        }
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Wpisz poprawną datę urodzenia",  ButtonType.OK);
                        alert.showAndWait();
                    }

                }
                return null;
            });

            Optional result = dialog.showAndWait();


        }
    }
}
