package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.*;
import net.proteanit.sql.*;

public class All_Passenger extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable T;
	private JTextField text;
	
	public static void main(String[] args)
	{
		new All_Passenger();
	}
	
	All_Passenger()
	{
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Aerial", Font.PLAIN, 13));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860 , 523);
		setLayout(null);
		setVisible(true);
		
		JLabel L = new JLabel("FLIGHT CODE");
		L.setBounds(50, 100, 200, 30);
		add(L);
		
		JLabel FlightDetails = new JLabel("PASSENGER INFORMATION");
		FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		FlightDetails.setForeground(new Color(100, 149, 237));
		FlightDetails.setBounds(50, 20, 570, 35);				
		add(FlightDetails);
			
		JButton B = new JButton("SHOW");
		B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	    B.addActionListener(new ActionListener() 
	    {
		   public void actionPerformed(ActionEvent a) 
		    {
		    	if(a.getSource()==B)
		    	{
		    		String code = text.getText();
			        try 
			        {
				        Connect_to_MySql C = new Connect_to_MySql();
				        String str = "select * from passenger where fl_code = '" +code+"'";	       
				        ResultSet rs = C.S.executeQuery(str);
				        T.setModel(DbUtils.resultSetToTableModel(rs));  
			        }
			        catch(SQLException e)
			        {
			              e.printStackTrace();
			        }
		    	}
		    }
	    });

	    B.setBounds(220, 150, 120, 30);  
		add(B);
			
	    T = new JTable();
	    T.setBackground(Color.WHITE);
		T.setBounds(23, 250, 800, 300);
	        
	    JScrollPane pane = new JScrollPane(T);
		pane.setBounds(23, 250, 800, 300);
	    pane.setBackground(Color.WHITE);
	    add(pane); 
			
		text = new JTextField();
	    text.setBounds(220, 100, 200, 30);
		add(text); 
			
		
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900,650);
	    setVisible(true);
	    setLocation(150 , 20);
			
	}
}
