import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class CenterPage extends JFrame {
	
	public JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CenterPage center_page = new CenterPage();
					center_page.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null ;
	public JPanel contentPane;
	
	
	public CenterPage() {
		initialize();
	}
	
	
	public void initialize(){
		con = DBSQL.dbCon();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 438, 266);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("About", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnStartNotepad = new JButton("Start NotePad");
		btnStartNotepad.setBounds(148, 185, 117, 29);
		panel_2.add(btnStartNotepad);
		
		btnStartNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				edit edit_page = new edit();
				edit_page.setVisible(true);
				// edit_page.setVisible(true);
			}
		});
		
		
	}
}
