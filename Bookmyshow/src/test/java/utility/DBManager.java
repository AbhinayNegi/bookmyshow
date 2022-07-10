package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	String username = "root";
	String password = "gkv@123";
	String query = "select * from bookmyshow";
	ResultSet rs;
	Statement stmt;
	
	public DBManager(){
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema",username,password);
			stmt=conn.createStatement(); 
			
			rs=stmt.executeQuery(query);  
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getInt(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getMovieData() throws SQLException {
		String[] s = new String[2];
		
		rs=stmt.executeQuery("SELECT Movie_name FROM bookmyshow");  
		while(rs.next()) {
			s[0] = rs.getString(1);
		}
		
		rs=stmt.executeQuery("SELECT Tickets FROM bookmyshow");  
		while(rs.next()) {
			s[1] = Integer.toString(rs.getInt("Tickets"));
		}
		
		
		return s;
	}
}
