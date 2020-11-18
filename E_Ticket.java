package airline.reservation.system;

import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


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
		setBackground(Color.ORANGE);

		Font f1,f2,f3,f4,f5;
		JLabel l1,l2,l3,l4,l5,l6,l7,l0,l12,l11,l22,l122,l33,l44,l55,l66,l77,l8;
		JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
		JButton b1;

		f1 = new Font("TimesRoman",Font.PLAIN,36);
		f2 = new Font("Tahoma",Font.BOLD,20);
		f5 = new Font("Tahoma",Font.PLAIN,20);
		f3 = new Font("Tahoma",Font.PLAIN,30);
		f4 = new Font("TimesRoman",Font.BOLD,24);


		Connect_to_MySql C = new Connect_to_MySql();
	   	String str = "SELECT * FROM passenger WHERE p_code = (SELECT p_code FROM booking WHERE pnr_no = '"+PNR+"')";
	    ResultSet rs = C.S.executeQuery(str);

		String name = rs.getString(0).charAt(2);
		String age = rs.getString(0).charAt(3);
		String gender = rs.getString(0).charAt(4);
		String nationality = rs.getString(0).charAt(1);

		str = "SELECT * FROM flight WHERE f_code = (SELECT f_code FROM booking WHERE pnr_no = '"+PNR+"')";
	    rs = C.S.executeQuery(str);
		String f_code = rs.getString(0).charAt(0);
		String dst = rs.getString(0).charAt(3);
		String src = rs.getString(0).charAt(2);

		l0 = new JLabel("Hydrus Airlines");
		l0.setFont(f1);
		l0.setBounds(280, 20, 350, 40);
		l0.setForeground(Color.RED);
		add(l0);

		l1 = new JLabel("Source -:");
		l1.setFont(f2);
		l1.setBounds(50, 120, 100, 27);
		l1.setForeground(Color.DARK_GRAY);
		add(l1);

		l11 = new JLabel(src);
		l11.setFont(f5);
		l11.setBounds(160, 120, 150, 27);
		l11.setForeground(Color.ORANGE);
		add(l11);

		l2 = new JLabel("Destination -: ");
		l2.setFont(f2);
		l2.setBounds(440, 120, 150, 27);
		add(l2);

		l22 = new JLabel(dst);
		l22.setFont(f5);
		l22.setBounds(595, 120, 150, 27);
		l22.setForeground(Color.ORANGE);
		add(l22);

		l12 = new JLabel("Pnr no. -: ");
		l12.setFont(f2);
		l12.setBounds(50, 180, 150, 27);
		add(l12);

		l122 = new JLabel(String(PNR));
		l122.setFont(f5);
		l122.setBounds(160, 180, 150, 27);
		l122.setForeground(Color.ORANGE);
		add(l122);


		l3 = new JLabel("Flight no. -:");
		l3.setFont(f2);
		l3.setBounds(440, 180, 150, 27);
		add(l3);

		l33 = new JLabel(fl_code);
		l33.setFont(f5);
		l33.setBounds(575, 180, 150, 27);
		l33.setForeground(Color.ORANGE);
		add(l33);


		l4 = new JLabel("Name -:");
		l4.setFont(f2);
		l4.setBounds(50, 240, 150, 27);
		add(l4);

		l44 = new JLabel(name);
		l44.setFont(f5);
		l44.setBounds(145, 240, 150, 27);
		l44.setForeground(Color.ORANGE);
		add(l44);


		l5 = new JLabel("Age -:");
		l5.setFont(f2);
		l5.setBounds(440, 240, 150, 27);
		add(l5);

		l55 = new JLabel(age);
		l55.setFont(f5);
		l55.setBounds(520, 240, 150, 27);
		l55.setForeground(Color.ORANGE);
		add(l55);


		l6 = new JLabel("Gender -:");
		l6.setFont(f2);
		l6.setBounds(50, 300, 150, 27);
		add(l6);

		l66 = new JLabel(gender);
		l66.setFont(f5);
		l66.setBounds(158, 300, 150, 27);
		l66.setForeground(Color.ORANGE);
		add(l66);


		l7 = new JLabel("Nationality -:");
		l7.setFont(f2);
		l7.setBounds(440, 300, 150, 27);
		add(l7);

		l77 = new JLabel(nation);
		l77.setFont(f5);
		l77.setBounds(585, 300, 150, 27);
		l77.setForeground(Color.ORANGE);
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
		//b1.setBackground(Color.CYAN);
	}

//	public void paint(Graphics g) {
//	    g.setColor (Color.yellow);
//	    g.fillOval (600, 100, 100, 60);
//	 }
}
