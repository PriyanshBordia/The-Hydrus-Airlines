package airline.reservation.system;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class pop_up extends Add_Customer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		pop_up(String str)
		{
			setVisible(true);
			setLocation(450,250);
			
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setSize(400,190);
			getContentPane().setLayout(null);
			
			JLabel lb1;
			Font f3 = new Font("Tahoma",Font.PLAIN,28);
			Font f4 = new Font("TimesRoman",Font.BOLD,20);
			JButton b1;
			
			lb1 = new JLabel("Fill "+ str);
			lb1.setFont(f3);
			lb1.setBounds(25, 30, 300, 27);
			add(lb1);
			
			b1 = new JButton("OK");
			b1.setFont(f4);
			b1.setBackground(Color.CYAN);
			add(b1);
			b1.setBounds(250, 100, 75, 27);
			
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent eve) {
					new MainScreen();
				}
			});
		}
}
