package controller.Logowanie;

import controller.MainController;
import controller.ViewController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Pattern;


public class RejestracjaController {
    private MainController main;

    @FXML public TextField imie;
    @FXML public TextField nazwisko;
    @FXML public TextField pesel;
    @FXML public TextField adres_email;
    @FXML public TextField login;
    @FXML public Label label_imie;
    @FXML public Label label_nazwisko;
    @FXML public Label label_pesel;
    @FXML public Label label_email;
    @FXML public Label label_login;
    @FXML public Label label_haslo;
    @FXML public Label label_potwierdz_haslo;
    @FXML public PasswordField haslo;
    @FXML public PasswordField potwierdzonehaslo;
    @FXML public Label komunikat_rozne_hasla;
    @FXML public  Label prosze_czekac;
    @FXML public Label sprawdz_poczte;
    @FXML public Button przejdz_dalej;
    @FXML public Button button_zarejestruj;
    @FXML public Label popraw_dane;
    @FXML public Label wymagania;
    Timeline timeline;


    @FXML public void initialize(){
        imie.setPromptText("Wpisz swoje imię");
        nazwisko.setPromptText("Wpisz swoje nazwisko");
        pesel.setPromptText("Wpisz swój pesel");
     adres_email.setPromptText("Wpisz swój adres-email");
     login.setPromptText("Wpisz swój login");
     haslo.setPromptText("Wpisz swoje nowe hasło ");
     potwierdzonehaslo.setPromptText("Potwierdz swoje hasło");

    }
    public void init(MainController main) {
        this.main = main;
    }
    public void zarejestruj(){
        String Imie=imie.getText();
        String Nazwisko=nazwisko.getText();
        String Pesel=pesel.getText();
        String Adres_email= adres_email.getText();
        String Login = login.getText();
        String Haslo = haslo.getText();
        String HasloPotwierdzone = potwierdzonehaslo.getText();
      try {
            if (HasloPotwierdzone.equals(Haslo) == false) {
                komunikat_rozne_hasla.setVisible(true);
                popraw_dane.setVisible(true);
            } else {
                komunikat_rozne_hasla.setVisible(false);
            }
        } catch(Exception a){}
        popraw_dane.setVisible(false);
        Pattern imieP = Pattern.compile("[A-Za-zÓóŻżĄąĘęŚśĆćŃń]{2,40}");
        if(imieP.matcher(Imie).matches() == false){
            popraw_dane.setVisible(true);
            label_imie.setTextFill(Paint.valueOf("red"));
        }
        else
        {
            label_imie.setTextFill(Paint.valueOf("white"));
        }

        Pattern nazwiskoP = Pattern.compile("[A-Za-zÓóŻżĄąĘęŚśĆćŃń]{2,40}");
        if(nazwiskoP.matcher(Nazwisko).matches() == false){
            popraw_dane.setVisible(true);
            label_nazwisko.setTextFill(Paint.valueOf("red"));
        }
        else
        {
            label_nazwisko.setTextFill(Paint.valueOf("white"));
        }

        Pattern peselP = Pattern.compile("[0-9]{11}");
        if(peselP.matcher(Pesel).matches() == false){
            popraw_dane.setVisible(true);
            label_pesel.setTextFill(Paint.valueOf("red"));
        }
        else
        {
            label_pesel.setTextFill(Paint.valueOf("white"));
        }

        Pattern adresP = Pattern.compile("[A-Za-zĄąĘęŻżÓóŚśĆćŃń/.]{2,40}@[A-Za-zĄąĘęŻżÓóŚśĆćŃń0-9]{1,}\\.[A-Za-zĄąĘęŻżÓóŚśĆćŃń0-9]{1,}");
        if(adresP.matcher(Adres_email).matches() == false){
            popraw_dane.setVisible(true);
            label_email.setTextFill(Paint.valueOf("red"));
        }
        else
        {
            label_email.setTextFill(Paint.valueOf("white"));
        }

        Pattern loginP = Pattern.compile("[A-Za-zÓóŻżĄąĘęŚśĆćŃń0-9/_/-]{2,40}");
        if(loginP.matcher(Login).matches() == false){
            popraw_dane.setVisible(true);
            label_login.setTextFill(Paint.valueOf("red"));
        }
        else
        {
            label_login.setTextFill(Paint.valueOf("white"));
        }

        Pattern hasloP = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\-\\=])(?=.*[A-Z])(?!.*\\s).{8,}");
        if(hasloP.matcher(Haslo).matches() == false){
            popraw_dane.setVisible(true);
            label_haslo.setTextFill(Paint.valueOf("red"));
        }
        else
        {
            label_haslo.setTextFill(Paint.valueOf("white"));
        }

        Pattern haslo_potwierdzoneP = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\_\\+\\-\\=])(?=.*[A-Z])(?!.*\\s).{8,}");
        if(haslo_potwierdzoneP.matcher(HasloPotwierdzone).matches() == false){
            popraw_dane.setVisible(true);
            label_potwierdz_haslo.setTextFill(Paint.valueOf("red"));
    }
        else
    {
        label_potwierdz_haslo.setTextFill(Paint.valueOf("white"));
    }

        if(popraw_dane.isVisible()) {
            return;
        }
         String SQL_Insert= "INSERT INTO `uzytkownicy` (`login`,`haslo`, `imie`, `nazwisko`, `pesel`, `email`, `potwierdzony_email`) VALUES ('"+Login+"', '"+Haslo+"', '"+Imie+"', '"+Nazwisko+"', '"+Pesel+"', '"+Adres_email+"', 'false' )";
         try{
            this.main.stmt.execute(SQL_Insert);
            button_zarejestruj.setDisable(true);
            SendEmail(Adres_email, "Potwierdzenie emaila", "www.praktyki.efennec.pl?id="+Adres_email);

        }
        catch(Exception E)
        {
            System.err.println(E);
        }

        prosze_czekac.setVisible(true);
         sprawdz_poczte.setVisible(true);
    wymagania.setVisible(false);

        KeyFrame rotate = new KeyFrame(
                Duration.seconds(2),
                event -> {

                    String SGL_zap= "select potwierdzony_email from uzytkownicy where login='" + Login + "' and haslo='" + Haslo + "'";
                    try {
                        ResultSet wynik = this.main.stmt.executeQuery(SGL_zap);
                        wynik.next();
                        String dostep = wynik.getString("potwierdzony_email");

                        if(dostep.equals("true")){
                            przejdz_dalej.setDisable(false);

                            sprawdz_poczte.setVisible(false);
                            prosze_czekac.setVisible(false);
                            timeline.stop();
                        }

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                }
        );
        timeline = new Timeline(
                rotate
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();




    }
    public void przejdz_dalej(){
        przejdz_dalej.setVisible(true);
        main.ViewController.changeBody("WyborOkienekUzyt");
    }
    public void reset(){
        main.ViewController.changeBody("Rejestracja");
    }
    public  void powrot(){
        main.ViewController.changeBody("Logowanie");
    }



    final String user     = "praktyki@efennec.pl";
    final String password = "zaq1@WSXcde3";
    public void SendEmail(String DoKogo,String tytul, String tresc)
    {
        String to = DoKogo;
        String from = "praktyki@efennec.pl";
        String host = "ssl0.ovh.net";
        Properties props = new Properties();
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(tytul);
            message.setText(tresc);

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");
            //Wyslalo


        }catch (MessagingException mex) {mex.printStackTrace();}
    }

    public void wimie(){
        wymagania.setText("Wymagania: same litery");
    }
    public void wnazwisko(){
        wymagania.setText("Wymagania: same litery");
    }
    public void wpesel(){
        wymagania.setText("Wymagania: 11 cyfr");
    }
    public void wemail(){
        wymagania.setText("Wymagania: poprawna składnia adresu");
    }
    public void wlogin(){
        wymagania.setText("Wymagania: litery i cyfry i znaki: _ -");
    }
    public void whaslo(){
        wymagania.setText("Wymagania: minimum: 8 znaków,jedna mała i  duża litera, znak specjalny, liczba; ");
    }
    public void whaslopotwierdzone(){
        wymagania.setText("");
    }

}
