package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Printing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Printing();
	}

	Printing() {
		init();
	}

	private void init() {
		setTitle("FIND BOOKING");

		setVisible(true);
		setLocation(530, 280);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(400, 200);
		getContentPane().setLayout(null);
		// setForeground(Color.GRAY);
		// getContentPane().seTackground(Color.CYAN);

		Font f1, f2, f3, f4;
		JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
		JTextField tf1, tf2;
		JButton B;
		JTable T;
		JScrollPane pane;

		f1 = new Font("Tahoma", Font.PLAIN, 24);
		f2 = new Font("Tahoma", Font.BOLD, 16);
		f3 = new Font("TimesRoman", Font.PLAIN, 40);
		f4 = new Font("Tahoma", Font.PLAIN, 16);

		l2 = new JLabel("TICKET");
		l2.setFont(f3);
		l2.setBounds(120, 10, 150, 40);
		l2.setForeground(Color.BLUE);
		add(l2);

		l1 = new JLabel("Pnr no.");
		l1.setFont(f1);
		l1.setBounds(80, 70, 150, 30);
		// l1.setForeground(Color.GRAY);
		add(l1);

		tf1 = new JTextField();
		tf1.setBounds(200, 70, 120, 27);
		add(tf1);

		B = new JButton("Show");
		B.setBounds(150, 115, 100, 27);
		B.setForeground(Color.DARK_GRAY);

		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (a.getSource() == B) {
					try {
						String code = tf1.getText();
						int s = Integer.parseInt(code); 
						new E_Ticket(s); 				
					} catch (NullPointerException e) {
						System.out.println(e); 
					}
				}
			}
		});

		B.setFont(f2);
		add(B);

		/*
		 * T = new JTable(); T.setBackground(Color.WHITE); T.setBounds(90, 350, 850,
		 * 60);
		 * 
		 * pane = new JScrollPane(T); pane.setBounds(90,350,850,60);
		 * pane.setBackground(Color.WHITE); add(pane);
		 */

	}

}
