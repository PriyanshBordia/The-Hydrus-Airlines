package airline.reservation.system;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Add_Customer extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static int Pnr = 1001;

	public static void main(String[] args) {
		Add_Customer A = new Add_Customer();
		//A.init();
	}

	Add_Customer(){
		init();
	}

	public String generate_pnr(String P , String F)
	{
		return P+F;
	}

	private void init()
	{
		setTitle("ADD CUSTOMER");

		setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("F://pic1.png")));
        setLayout(new FlowLayout());


		setVisible(true);
		setLocation(280 , 60);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(800,560);
		getContentPane().setLayout(null);

		Font f1,f2,f3,f4;
		JLabel l1,l2,l3,l4,l5,l6,l7,l0,l12;
		JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
		JRadioButton rb1,rb2;
		JButton b1;

		f1 = new Font("Tahoma",Font.BOLD,30);
		f2 = new Font("Tahoma",Font.PLAIN,20);
		f3 = new Font("Tahoma",Font.BOLD,100);
		f4 = new Font("TimesRoman",Font.BOLD,24);

		l0 = new JLabel("CUSTOMER DETAILS");
		l0.setFont(f1);
		l0.setBounds(230, 20, 350, 40);
		l0.setForeground(Color.BLUE);
		add(l0);

		l1 = new JLabel("Passport no.");
		l1.setFont(f2);
		l1.setBounds(60, 120, 150, 27);
		add(l1);

		tf1 = new JTextField();
		tf1.setBounds(200, 120, 150, 30);
		add(tf1);

		l2 = new JLabel("Name");
		l2.setFont(f2);
		l2.setBounds(460, 160, 150, 27);
		add(l2);

		tf2 = new JTextField();
		tf2.setBounds(550, 160, 150, 30);
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

		l3 = new JLabel("Age");
		l3.setFont(f2);
		l3.setBounds(460, 240, 150, 27);
		add(l3);

		tf3 = new JTextField();
		tf3.setBounds(550, 240, 150, 30);
		add(tf3);

		l4 = new JLabel("Nationality");
		l4.setFont(f2);
		l4.setBounds(60, 280, 150, 27);
		add(l4);

		tf4 = new JTextField();
		tf4.setBounds(200, 280, 150, 30);
		add(tf4);

		l5 = new JLabel("Phone no");
		l5.setFont(f2);
		l5.setBounds(460, 320, 150, 27);
		add(l5);

		tf5 = new JTextField();
		tf5.setBounds(550, 320, 150, 30);
		add(tf5);

		l6 = new JLabel("Flight Code");
		l6.setFont(f2);
		l6.setBounds(60, 360, 150, 27);
		add(l6);

		tf6 = new JTextField();
		tf6.setBounds(200, 360, 150, 30);
		add(tf6);


		/*setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\airline.reservation.system\\pic1.png"));
        add(background);
        background.setLayout(new FlowLayout());*/





		b1 = new JButton("Submit");
		b1.setBounds(340, 460, 150, 30);
		b1.setFont(f4);
		add(b1);
		//b1.setBackground(Color.CYAN);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				if(a.getSource()==b1)
				{
					String gender = " ";
					if(rb1.isSelected()) {
						gender = "Male";
					}
					else if(rb2.isSelected()) {
						gender = "Female";
					}
					/*else if(rb1.isSelected() && rb2.isSelected()) {
						new pop_up("Gender");
					}*/
					String passport = tf1.getText();
					String name = tf2.getText();
					String age = tf3.getText();
					String nationality =  tf4.getText();
					String P_number = tf5.getText();
					String fl_code = tf6.getText();
					int PNR = 0;
					//String pnr = generate_pnr(passport , fl_code);
					try {
						Connect_to_MySql C1 = new Connect_to_MySql();
						String str = "INSERT INTO passenger (passport_no , name , gender , age , nationality , ph_no) VALUES ('" +passport+"' ,  '" +name+"' , '" +gender+"' ,  '" +age+"' , '" +nationality+"' , '" +P_number+"')";
						C1.S.executeUpdate(str);

						str = "SELECT p_code FROM passenger where passport_no =  '"+passport+"' and name = '"+name+"'";
						ResultSet rs = C1.S.executeQuery(str);
						int p_code = rs.getString(0).charAt(0);

						str = "INSERT INTO booking (f_code , p_code ,) VALUES ('"+fl_code+"' , '"+p_code+"')";
						C1.S.executeQuery(str);

						str = "SELECT pnr_no FROM booking where f_code =  '"+fl_code+"' and p_code = '"+p_code+"'";
						ResultSet rs1 = C1.S.executeQuery(str);

						PNR = rs1.getString(0).charAt(0);
					}
					catch(Exception e) {
						System.out.println(e);
					}

					finally {
						JOptionPane.showMessageDialog(null , "INSERTION DONE");
	                    setVisible(false);
	                    new E_Ticket(PNR);
					}
				}

			}
		});

	}
}
