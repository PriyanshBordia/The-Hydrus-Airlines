package airline.reservation.system;

import java.sql.*;

public class Connect_to_MySql
{
	Connection C;
	Statement S;
	public Connect_to_MySql()
	{
		try
		{
			//System.out.println(123);
			Class.forName("com.mysql.jdbc.Driver");
			C = DriverManager.getConnection("jdbc:mysql://project4" , "root" , " ");
			S = C.createStatement();
		}
		catch (Exception e)
		{
			//System.out.println(12345);
			System.out.println(e);
		}
	}
}
