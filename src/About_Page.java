import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;


public class About_Page extends JFrame {

	public JFrame frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_Page about = new About_Page();
					about.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public About_Page() {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 438, 266);
		getContentPane().add(tabbedPane);
		
		JPanel About = new JPanel();
		tabbedPane.addTab("About", null, About, null);
		About.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(161, 111, 117, 29);
		About.add(btnNewButton);
		frame = new JFrame();
		//frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
