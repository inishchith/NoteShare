import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.Color;


public class Main {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		
		
		btnNewButton.setBounds(53, 138, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(92, 68, 134, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"One Time Password Sent To " + textField.getText());
				String s = textField.getText();
				frame.dispose();
				mail ml = new mail();
				ml.send(s);
				CenterPage lg = new CenterPage();
				lg.setVisible(true);
			}
		});
		
		JLabel label = new JLabel("");
		Image main_logo = new ImageIcon(this.getClass().getResource("/calendar.png")).getImage();
		label.setIcon(new ImageIcon(main_logo));
		label.setBounds(307, 50, 152, 153);
		frame.getContentPane().add(label);
		
		lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setBounds(19, 74, 61, 16);
		frame.getContentPane().add(lblNewLabel);
	}
}


// sms field 

class mail{
	
	public void send(String s){
		
    final String myaddr="kondadiprem@gmail.com";
    final String mypass="nishchal";
    String destaddr=s;

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
        String msgtext="This is the mail from Java Program";
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("kjsce@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destaddr));
        message.setSubject("Mail Using Java Program. Reply Me ");
        message.setText(msgtext);

        //Transport.send(message);

        System.out.println("-------->Done<---------");
        JOptionPane.showMessageDialog(null,"Enter Hash Bitch");
        
        // generated hash 
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}	
}

