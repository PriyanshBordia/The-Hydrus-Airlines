package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Cancel extends JFrame
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static int num = 1001;

	public static void main(String[] args)
	{
		new Cancel();
	}

	Cancel()
	{
		init();
	}

	private void init() {

		setTitle("TICKET CANCELLATION");

		setVisible(true);
		setSize(500,250);
		setLocation(450,200);
		getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		Font f1,f2,f3,f4;
		//JLabel l1;
		JTextField tf1;
		JButton b1;

		f1 = new Font("Tahoma",Font.BOLD,16);
		f2 = new Font("Tahoma",Font.BOLD,24);
		f3 = new Font("Tahoma",Font.PLAIN,26);
		f4 = new Font("Tahoma",Font.PLAIN,22);


		JLabel l0 = new JLabel("CANCELLATION");
		l0.setFont(f3);
		l0.setBounds(130, 20, 300, 30);
		l0.setForeground(Color.BLACK);
		add(l0);

		JLabel l1 = new JLabel("PNR no.");
		l1.setFont(f4);
		l1.setBounds(110, 100, 200, 27);
		add(l1);

		tf1 = new JTextField();
		tf1.setBounds(220, 100, 150, 27);
		add(tf1);

		JButton B = new JButton("SUBMIT");
		B.setFont(new Font("Tahoma", Font.PLAIN, 20));
		B.setBounds(160, 150, 110, 27);
		//B.setBackground(Color.LIGHT_GRAY);
		//b1.setForeground(Color.BLUE);
		add(B);


		B.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				if(a.getSource()==B)
				{
					try 
					{
						String pnr = tf1.getText();
						int s = Integer.parseInt(pnr);
						
						Connect_to_MySql C1 = new Connect_to_MySql();

						String str = "INSERT INTO cancel (pnr_no) VALUES ('" +pnr+"')";
						C1.S.executeUpdate(str);
					
						str = "DELETE FROM booking WHERE pnr_no = '"+pnr+"'";
						C1.S.executeUpdate(str);	
					}
					
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					
					setVisible(false);
				}
			}
		});
	}
}