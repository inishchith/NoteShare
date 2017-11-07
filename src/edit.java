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
import java.io.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.fife.ui.rsyntaxtextarea.*;
import org.fife.ui.rtextarea.*;



public class edit extends JFrame{
	RSyntaxTextArea area = new RSyntaxTextArea(30, 80);
	public JFileChooser fc = new JFileChooser();
	
	public String email_id ;
	public edit(String email ){
		this.email_id = email ;
		FileFilter txtFilter = new FileNameExtensionFilter("Plain Text","txt","c","cpp","py","md");
		fc.setFileFilter(txtFilter);
	      area.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
	      area.setCodeFoldingEnabled(true);
	      RTextScrollPane sp = new RTextScrollPane(area);
		
		add(sp);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu file = new JMenu("File");
		JMenu more = new JMenu("More");
		
		menuBar.add(file);
		
		file.add(Open);
		file.addSeparator();
		file.add(Save);
		file.addSeparator();
		file.add(Exit);
		
		menuBar.add(more);
		more.add(Share_email);
		more.addSeparator();
		more.add(Share_message);
		more.addSeparator();
		more.add(logout);
		more.addSeparator();
		more.add(About);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	// actions
	
	Action Open = new AbstractAction("Open File"){
		@Override
		public void actionPerformed(ActionEvent e){
			if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				openFile(fc.getSelectedFile().getAbsolutePath()); //  
			}
		}
	};
	
	Action Save = new AbstractAction("Save File"){
		@Override
		public void actionPerformed(ActionEvent e){
			saveFile();
		}
	};
	
	
	Action About = new AbstractAction("About"){
		@Override
		public void actionPerformed(ActionEvent e){
			// saveFile();
		}
	};
	
	Action logout = new AbstractAction("Logout"){
		@Override
		public void actionPerformed(ActionEvent e){
			setVisible(false);
			Main login_page = new Main();
			login_page.frame.setVisible(true);
		}
	};
	
	Action Share_email = new AbstractAction("Share via Email"){
		@Override
		public void actionPerformed(ActionEvent e){
			String reciepent = JOptionPane.showInputDialog("Enter reciepent :  ");
			String message = area.getText();
			String subject = email_id +" shared a note";
			mail_bot ml = new mail_bot(subject,message,reciepent);
			ml.send();
			//boolean isValid = Main.isValidEmailAddress(email_id);
			if(true){
				JOptionPane.showMessageDialog(null,"NoteShared With " +reciepent );
			}
			else{
				JOptionPane.showMessageDialog(null,"Invalid reciepent email_id");
			}
		}
	};
	
	Action Share_message = new AbstractAction("Share via SMS"){
		@Override
		public void actionPerformed(ActionEvent e){
			// Twilio
		}
	};
	
	Action Exit = new AbstractAction("Exit"){
		@Override
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	};
	
	public void openFile(String FileName){
		FileReader fr = null ;
		try{
			fr = new FileReader(FileName);
			area.read(fr,null);
			fr.close();
			setTitle(FileName);
			
		}
		catch(IOException e){
			e.printStackTrace(); // add OptionPane
		}
	}
	
	public void saveFile(){
		if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			FileWriter fw = null ;
			try{
				fw = new FileWriter(fc.getSelectedFile().getAbsolutePath()+".txt");
				area.write(fw);
				fw.close();
			}
			catch(IOException e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(this,"Cannot Save File");
			}
		}
	}
	
	public static void main(String args[]){
		new edit(null);
	}
}