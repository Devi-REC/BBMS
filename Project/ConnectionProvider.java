package Project;
import java.sql.*;
public class ConnectionProvider {
	public static Connection getCon(){
		try {
		Class.forName("con.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbms","root","devi");
		return con;
		}
		catch(Exception e) {
			return null;
		}
	
	}


}
