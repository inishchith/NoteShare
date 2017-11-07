import java.sql.*;
import javax.swing.*;


public class DBSQL {
	Connection con = null ; 
	
	public static Connection dbCon(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Nishchith/eclipse-workspace/learn.sqlite");
			// JOptionPane.showMessageDialog(null,"Connection Successful ");
			return conn; 
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null ;
		}
	}
}
