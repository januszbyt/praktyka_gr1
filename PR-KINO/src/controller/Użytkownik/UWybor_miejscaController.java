package controller.Użytkownik;

import controller.MainController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class UWybor_miejscaController {
    private MainController main;
    public void init(MainController main){
        this.main = main;



    }


    final String user="praktyki@efennec.pl";//change accordingly
    final String password="zaq1@WSXcde3";//change accordingly
    public void SendEmail()
    {
            String to = "alfagruis@gmail.com";
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
                message.setSubject("Ping");
                message.setText("Hello, this is example of sending email  ");

                // Send message
                Transport.send(message);
                System.out.println("message sent successfully....");

            }catch (MessagingException mex) {mex.printStackTrace();}
        }
}

