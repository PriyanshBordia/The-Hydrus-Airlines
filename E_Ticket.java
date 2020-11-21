package airline.reservation.system;

import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class E_Ticket extends JFrame {

	private static final long serialVersionUID = 1L;

	E_Ticket(int PNR)
	{
		init(PNR);
	}
	
	private void init(int PNR)
	{

		setTitle("Printing Ticket");

		setVisible(true);
		setLocation(370,100);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(780,560);
		getContentPane().setLayout(null);
		setBackground(Color.GRAY);

		Font f1,f2,f3,f4,f5;
		JLabel l1,l2,l3,l4,l5,l6,l7,l0,l12,l11,l22,l122,l33,l44,l55,l66,l77,l8;
		JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
		JButton b1;

		f1 = new Font("TimesRoman",Font.PLAIN,36);
		f2 = new Font("Tahoma",Font.BOLD,20);
		f5 = new Font("Tahoma",Font.PLAIN,20);
		f3 = new Font("Tahoma",Font.PLAIN,30);
		f4 = new Font("TimesRoman",Font.BOLD,24);

		String name = null ;
		String f_code = null ;
		String dst = null ;
		String src = null ;
		String age = null ;
		String gender = null ;
		String nationality = null ;
		
	    
		try 
		{
			Connect_to_MySql C = new Connect_to_MySql();
		   	String str = "SELECT * FROM passenger WHERE p_code = (SELECT p_code FROM booking WHERE pnr_no = '"+PNR+"')";
			ResultSet rs = C.S.executeQuery(str);
			rs.next();
			name = rs.getString("name");
			age = rs.getString("age");
			gender = rs.getString("gender");
			nationality = rs.getString("nationality");

			str = "SELECT * FROM flight WHERE f_code = (SELECT f_code FROM booking WHERE pnr_no = '"+PNR+"')";
		    rs = C.S.executeQuery(str);
		    rs.next(); 
			f_code = rs.getString("f_code");
			dst = rs.getString("dst");
			src = rs.getString("src");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			//System.out.println("ssss"); 
			e.printStackTrace();
		}
	 
		l0 = new JLabel("Hydrus Airlines");
		l0.setFont(f1);
		l0.setBounds(280, 20, 350, 40);
		l0.setForeground(Color.BLUE);
		add(l0);

		l1 = new JLabel("Source -:");
		l1.setFont(f2);
		l1.setBounds(50, 120, 100, 27);
		l1.setForeground(Color.BLACK);
		add(l1);

		l11 = new JLabel(src);
		l11.setFont(f5);
		l11.setBounds(160, 120, 150, 27);
		l11.setForeground(Color.GRAY);
		add(l11);

		l2 = new JLabel("Destination -: ");
		l2.setFont(f2);
		l2.setBounds(440, 120, 150, 27);
		l2.setForeground(Color.BLACK);
		add(l2);

		l22 = new JLabel(dst);
		l22.setFont(f5);
		l22.setBounds(595, 120, 150, 27);
		l22.setForeground(Color.GRAY);
		add(l22);

		l12 = new JLabel("Pnr no. -: ");
		l12.setFont(f2);
		l12.setBounds(50, 180, 150, 27);
		l12.setForeground(Color.BLACK);
		add(l12);

		String s = String.valueOf(PNR);
		
		l122 = new JLabel(s); 
		l122.setFont(f5);
		l122.setBounds(160, 180, 150, 27);
		l122.setForeground(Color.GRAY);
		add(l122);


		l3 = new JLabel("Flight no. -:");
		l3.setFont(f2);
		l3.setBounds(440, 180, 150, 27);
		l3.setForeground(Color.BLACK);
		add(l3);

		l33 = new JLabel(f_code);
		l33.setFont(f5);
		l33.setBounds(575, 180, 150, 27);
		l33.setForeground(Color.GRAY);
		add(l33);


		l4 = new JLabel("Name -:");
		l4.setFont(f2);
		l4.setBounds(50, 240, 150, 27);
		l4.setForeground(Color.BLACK);
		add(l4);

		l44 = new JLabel(name);
		l44.setFont(f5);
		l44.setBounds(145, 240, 300, 27);
		l44.setForeground(Color.GRAY); 
		add(l44);


		l5 = new JLabel("Age -:");
		l5.setFont(f2);
		l5.setBounds(440, 240, 150, 27);
		l5.setForeground(Color.BLACK);
		add(l5);

		l55 = new JLabel(age);
		l55.setFont(f5);
		l55.setBounds(520, 240, 150, 27);
		l55.setForeground(Color.GRAY);
		add(l55);


		l6 = new JLabel("Gender -:");
		l6.setFont(f2);
		l6.setBounds(50, 300, 150, 27);
		l6.setForeground(Color.BLACK);
		add(l6);

		l66 = new JLabel(gender);
		l66.setFont(f5);
		l66.setBounds(158, 300, 150, 27);
		l66.setForeground(Color.GRAY);
		add(l66);


		l7 = new JLabel("Nationality -:");
		l7.setFont(f2);
		l7.setBounds(440, 300, 150, 27);
		l7.setForeground(Color.BLACK);
		add(l7);

		l77 = new JLabel(nationality);
		l77.setFont(f5);
		l77.setBounds(585, 300, 150, 27);
		l77.setForeground(Color.GRAY);
		add(l77);

		l8 = new JLabel("Thanks For Choosing Us !!");
		l8.setFont(f3);
		l8.setBounds(190, 380, 500, 36);
		l8.setForeground(Color.BLUE);
		add(l8);

		b1 = new JButton("Print");
		b1.setBounds(270, 460, 150, 30);
		b1.setFont(f4);
		add(b1);
		
		b1.addActionListener(new ActionListener() 
	    {
		   public void actionPerformed(ActionEvent a) 
		    {
		    	if(a.getSource()==b1)
		    	{
		    		setVisible(false);
		    		System.exit(0); 
		    	}
		    }
	    });
		
		//b1.setBackground(Color.CYAN);
	}

//	public void paint(Graphics g) {
//	    g.setColor (Color.yellow);
//	    g.fillOval (600, 100, 100, 60);
//	 }
}