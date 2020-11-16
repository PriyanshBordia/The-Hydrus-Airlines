package airline.reservation.system;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;

public class Add_Customer extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Add_Customer A = new Add_Customer();
		A.init();
	}

	Add_Customer(){
		//init();
	}

	private void init()
	{
		setTitle("ADD CUSTOMER");

		setVisible(true);
		setLocation(60,60);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(800,600);
		getContentPane().setLayout(null);

		Font f1,f2,f3,f4;
		JLabel l1,l2,l3,l4,l5,l6,l7,l0,l12;
		JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
		JRadioButton rb1,rb2;
		JButton b1;

		f1 = new Font("Tahoma",Font.BOLD,46);
		f2 = new Font("Tahoma",Font.BOLD,20);
		f3 = new Font("Tahoma",Font.BOLD,100);
		f4 = new Font("TimesRoman",Font.BOLD,24);

		l0 = new JLabel("ADD CUSTOMER");
		l0.setFont(f1);
		l0.setBounds(200, 20, 350, 50);
		add(l0);

		l1 = new JLabel("Passport No.");
		l1.setFont(f2);
		l1.setBounds(60, 120, 150, 27);
		add(l1);

		tf1 = new JTextField();
		tf1.setBounds(200, 120, 150, 30);
		add(tf1);

		l2 = new JLabel("Pnr No.");
		l2.setFont(f2);
		l2.setBounds(60, 160, 150, 27);
		add(l2);

		tf2 = new JTextField();
		tf2.setBounds(200, 160, 150, 30);
		add(tf2);

		l12 = new JLabel("Gender");
		l12.setFont(f2);
		l12.setBounds(60, 200, 150, 27);
		add(l12);

		rb1 = new JRadioButton("Male");
		rb1.setBounds(190, 200, 80, 30);
		add(rb1);

		rb2 = new JRadioButton("Female");
		rb2.setBounds(280, 200, 80, 30);
		add(rb2);

		l3 = new JLabel("Name");
		l3.setFont(f2);
		l3.setBounds(60, 240, 150, 27);
		add(l3);

		tf3 = new JTextField();
		tf3.setBounds(200, 240, 150, 30);
		add(tf3);

		l4 = new JLabel("Nationality");
		l4.setFont(f2);
		l4.setBounds(60, 280, 150, 27);
		add(l4);

		tf4 = new JTextField();
		tf4.setBounds(200, 280, 150, 30);
		add(tf4);

		l5 = new JLabel("Ph No.");
		l5.setFont(f2);
		l5.setBounds(60, 320, 150, 27);
		add(l5);

		tf5 = new JTextField();
		tf5.setBounds(200, 320, 150, 30);
		add(tf5);

		l6 = new JLabel("Flight Code");
		l6.setFont(f2);
		l6.setBounds(60, 360, 150, 27);
		add(l6);

		tf6 = new JTextField();
		tf6.setBounds(200, 360, 150, 30);
		add(tf6);

		b1 = new JButton("Submit");
		b1.setBounds(130, 460, 150, 30);
		b1.setFont(f4);
		add(b1);
		b1.setBackground(Color.CYAN);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				if(a.getSource()==b1)
				{
					String gender;
					if(rb1.isSelected()) {
						gender = "Male";
					}
					else if(rb2.isSelected()) {
						gender = "Female";
					}
					else if(rb1.isSelected() && rb2.isSelected()) {
						new pop_up("Gender");
					}
					String passport = tf1.getText();
					String pnr = tf2.getText();
					String name = tf3.getText();
					String nationality =  tf4.getText();
					String fl_code = tf5.getText();
					String P_number = tf6.getText();

					try {
						Connect_to_MySql C1 = new Connect_to_MySql();
						String str = "INSERT INTO passenger (pnr_no , nationality , name , gender , ph_no , passport_no , fl_code) VALUES ('" +pnr+"' , '" +nationality+"' , '" +name+"' , '" +P_number+"' , '" +passport+"' , '" +fl_code+"')";
						C1.S.executeUpdate(str);
					}catch(Exception e) {
						System.out.println(e);
					}finally {
						System.out.println("INSERTION DONE");
					}
				}

			}
		});

	}
}
