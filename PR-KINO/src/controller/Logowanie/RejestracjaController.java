package controller.Logowanie;

import controller.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class RejestracjaController {
    private MainController main;

    @FXML public TextField imie;
    @FXML public TextField nazwisko;
    @FXML public TextField pesel;
    @FXML public TextField adres_email;
    @FXML public TextField login;
    @FXML public PasswordField haslo;
    @FXML public PasswordField potwierdzonehaslo;
    @FXML public Label komunikat_rozne_hasla;
    @FXML public  Label prosze_czekac;
    @FXML public Button przejdz_dalej;



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
        System.out.println(HasloPotwierdzone+" "+Haslo);
        if(HasloPotwierdzone!=Haslo){
            komunikat_rozne_hasla.setVisible(true);
            return;
        }
        else
        {
            komunikat_rozne_hasla.setVisible(false);
        }


         String SQL_Insert= "INSERT INTO `uzytkownicy` (`login`,`haslo`, `imie`, `nazwisko`, `pesel`, `email`, `potwierdzony_email`) VALUES ('"+Login+"', '"+Haslo+"', '"+Imie+"', '"+Nazwisko+"', '"+Pesel+"', '"+Adres_email+"', 'false' )";
         try{
            this.main.stmt.execute(SQL_Insert);
             SendEmail(Adres_email, "Potwierdzenie emaila", "www.praktyki.efennec.pl?id="+Adres_email);



        }
        catch(Exception E)
        {
            System.err.println(E);
        }

prosze_czekac.setVisible(true);

    }
    public void przejdz_dalej(){
        przejdz_dalej.setVisible(true);
        main.ViewController.changeBody("UWybor_filmuController");
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
}
