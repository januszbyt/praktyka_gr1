package controller.Logowanie;

import controller.MainController;
import javafx.fxml.FXML;
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
       /* if(HasloPotwierdzone!=Haslo){
            komunikat_rozne_hasla.setVisible(true);
            return;
        }
        else
        {
            komunikat_rozne_hasla.setVisible(false);
        }*/


         String SQL_Insert= "INSERT INTO `uzytkownicy` (`login`,`haslo`, `imie`, `nazwisko`, `pesel`, `email`, `potwierdzony_email`) VALUES ('"+Login+"', '"+Haslo+"', '"+Imie+"', '"+Nazwisko+"', '"+Pesel+"', '"+Adres_email+"', 'false' )";
         try{
            this.main.stmt.execute(SQL_Insert);
             SendEmail(Adres_email, "Potwierdzenie emaila", "ffdersgvrd");



        }
        catch(Exception E)
        {
            System.err.println(E);
        }



    }
    public void przejdz_dalej(){}



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
