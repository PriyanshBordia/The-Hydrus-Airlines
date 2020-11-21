package airline.reservation.system;

import java.sql.*;

public class Connect_to_MySql
{
	Connection C;
	Statement S;
	Connect_to_MySql()
	{
			try
			{
				Class.forName("com.mysql.jdbc.Driver"); 
				C = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/airline_database?characterEncoding=latin1" , "root" , "itsmylife"); 	 
				S = C.createStatement(); 
				//new login();
			}
			catch (Exception e)
			{
				//System.out.println(12345);
				System.out.println(e);			
			}
	}
}
