package bank.management.system;

import java.sql.*;


public class Conn {

	Connection c;
	Statement s;
	
	public Conn() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "anuj@7275");
			s = c.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
