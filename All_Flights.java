package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.*;
import net.proteanit.sql.*;



public class All_Flights extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable T;
	private JTextField text;
	
	public static void main(String[] args)
	{
		new All_Flights();
	}
	
	All_Flights()
	{
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Aerial", Font.PLAIN, 13));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,523);
		setLayout(null);
		setVisible(true);
		
		JLabel L = new JLabel("Departure");
		L.setBounds(220, 100, 200, 30);
		add(L);
		
		JLabel L1 = new JLabel("Arrival");
		L1.setBounds(220, 140, 200, 30);
		add(L1);
		
		JTextField text2 = new JTextField();
		text2.setBounds(370, 140, 200, 30);
		add(text2);
		
		JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
		FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		FlightDetails.setForeground(new Color(100, 149, 237));
		FlightDetails.setBounds(230, 20, 570, 35);
		add(FlightDetails);
			
		JButton B = new JButton("SHOW");
		B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		 B.addActionListener(new ActionListener() 
		    {
			    public void actionPerformed(ActionEvent a) 
			    {
			    	if(a.getSource()==B)
			    	{
			    		String depart = text.getText();
			    		String arr = text2.getText();
				        try 
				        {
				        Connect_to_MySql C = new Connect_to_MySql();
				        String str = "select f_code , f_name , src , dst from flight where src = '"+depart+"' and dst = '"+arr+"'"; 	      
				        ResultSet rs = C.S.executeQuery(str); 
				        //ResultSet rs1 = C.S.executeQuery(); 
				        T.setModel(DbUtils.resultSetToTableModel(rs)); 
				        }
				        catch(SQLException e)
				        {
				                    e.printStackTrace();
				        }
			    	}
			    }
		    });

	    B.setBounds(270, 190, 120, 30);
		add(B);
			
	    T = new JTable();
	    T.setBackground(Color.WHITE);
		T.setBounds(23, 290, 800, 300);
	        
	    JScrollPane pane = new JScrollPane(T);
		pane.setBounds(23, 290, 800, 300);
	    pane.setBackground(Color.WHITE);
	    add(pane); 
			
		text = new JTextField();
	    text.setBounds(370, 100, 200, 30);
		add(text); 
			
		/*JLabel FlightCode = new JLabel("FLIGHT CODE");
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    FlightCode.setBounds(23, 260, 126, 14);
		add(FlightCode);
			
		JLabel FlightName = new JLabel("FLIGHT NAME");
	    FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		FlightName.setBounds(145, 260, 120, 14);
		add(FlightName);
			
		JLabel Source = new JLabel("SOURCE");
		Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Source.setBounds(275, 260, 104, 14);
		add(Source);
			
		JLabel Destination = new JLabel("DESTINATION");
		Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Destination.setBounds(367, 260, 120, 14);
		add(Destination);
			
			
		JLabel Capacity = new JLabel("CAPACITY");
		Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Capacity.setBounds(497, 260, 111, 14);
		add(Capacity);*/
		
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(863,700);
	    setVisible(true);
	    setLocation(170 , 20);
			
	}
}































//public class All_Flights extends JFrame
//{
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;
	private JTable T;
	private JTextField text;
	
	public static void main(String[] args)
	{
		new All_Flights();
	}
	
	All_Flights()
	{
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Aerial", Font.PLAIN, 13));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,523);
		setLayout(null);
		setVisible(true);
		
		JLabel L = new JLabel("Departure");
		L.setBounds(50, 100, 200, 30);
		add(L);
		
		JLabel L1 = new JLabel("Arrival");
		L1.setBounds(50, 140, 200, 30);
		add(L1);
		
		JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
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
		    		String depart = text.getText();
		    		String arr = text.getText();
			        try 
			        {
			        Connect_to_MySql C = new Connect_to_MySql();
			        String str = "select f_code , f_name , src , dst from flight where src = '"+depart+"' and dst = "+arr+"'";	      
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
		add(text); */
			
		/*JLabel FlightCode = new JLabel("FLIGHT CODE");
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    FlightCode.setBounds(23, 220, 126, 14);
		add(FlightCode);
			
		JLabel FlightName = new JLabel("FLIGHT NAME");
	    FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		FlightName.setBounds(145, 220, 120, 14);
		add(FlightName);
			
		JLabel Source = new JLabel("SOURCE");
		Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Source.setBounds(275, 220, 104, 14);
		add(Source);
			
		JLabel Destination = new JLabel("DESTINATION");
		Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Destination.setBounds(367, 220, 120, 14);
		add(Destination);
			
			
		JLabel Capacity = new JLabel("CAPACITY");
		Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Capacity.setBounds(497, 220, 111, 14);
		add(Capacity);*/
		/*
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(900,650);
	    setVisible(true);
	    setLocation(400,200);
			
	}
}*/
