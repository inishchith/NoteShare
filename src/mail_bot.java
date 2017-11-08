import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import java.util.*;


public class mail_bot {
	String subject;
	String message_text;
	String email_id ;
	
	mail_bot(String subject,String message,String id){
		this.subject = subject ;
		this.message_text = message ;
		this.email_id = id ;
	}
	
	public void send(){
    final String myaddr="sharenotepad@gmail.com"; // email 
    final String mypass=""; // pass
    String destaddr =  email_id;

    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myaddr,mypass);
                }
            });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("kjsce@gmail.com")); // create a  temp here
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destaddr));
        message.setSubject(subject);
        message.setText(message_text);

        Transport.send(message);    
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}	
}


