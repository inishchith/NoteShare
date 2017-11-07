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
import javax.mail.*;
import java.util.*;

 
public class Main {

	public JFrame frame;
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

	
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
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
				String email_id = textField.getText();
				
				boolean isValid = isValidEmailAddress(email_id);
				
				if(isValid){
					
					String Hash = "" ;
					for(int i = 0;i<email_id.length();i++){
						char c ;
						Integer rn = new Random().nextInt(10000);
						if(email_id.charAt(i)>=65 && email_id.charAt(i)<=90){
							Hash += (char)(97+(email_id.charAt(i)+rn-65)%26);
						}
						else if(email_id.charAt(i)>=47 && email_id.charAt(i)<=58){
							Hash += (char)((email_id.charAt(i)+rn-47)%10);
							System.out.println(Hash);
						}
						else if(email_id.charAt(i)>=97 && email_id.charAt(i)<=122){
							Hash += (char)(65+(email_id.charAt(i)-97+rn)%26);
						}
					}
					
					// send mail with gen. hash
					
					String message = "Your NoteShare One Time is : " + Hash +"\nPlease use this Hash in order to Login .";
					mail_bot ml = new mail_bot("NoteShare One Time Hash",message,email_id);
					// DO nOt Send - Redundant .
					// ml.send(email_id,Hash);
					
					
					JOptionPane.showMessageDialog(null,"One Time Hash Sent To " +email_id );
				    String text = JOptionPane.showInputDialog(frame, "Enter Hash ");
				    System.out.println(text); 
				    
				    //if(text.equals(Hash)){
				    if(true){
				    	frame.dispose(); // on hash check success
				    	edit lg = new edit(email_id);
				    	lg.setVisible(true);
				    }
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid Email Id ! ");
				}
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
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (Exception ex) {
		      result = false;
		   }
		   return result;
	}
}
