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
					String pnr = tf1.getText();
					Connect_to_MySql C1 = new Connect_to_MySql();

					String str = "SELECT * FROM booking WHERE pnr_no = ('" +pnr+"')";
					boolean check =  C1.S.executeQuery();

					if (check == true)
					{
						// check if true

						str = "DELETE FROM booking WHERE pnr_no = ('" +pnr+"')";
						check =  C1.S.executeUpdate();

						str = "INSERT INTO cancel (pnr_no) VALUES ('" +pnr+"')";
						C1.S.executeUpdate();
						
						try {
							C1.S.executeUpdate(str);
						}

						catch (SQLException e) {
							e.printStackTrace();
						}
					}

					setVisible(false);
				}
			}
		});
	}
}











































/*public class Cancel extends Add_Customer
{


	private static final long serialVersionUID = 1L;
	public static int num = 1001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cancel();
	}

	Cancel(){
		init();
	}

	private void init() {

		setTitle("TICKET Cancel");

		setVisible(true);
		setSize(1000,600);
		setLocation(450,200);

		ImageIcon img = loadImage();
		JLabel lab = new JLabel(img);
		add(lab);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

		Font f1,f2,f3,f4;
		Label l1,l2,le,le2;
		TextField tf1,tf2;
		Button b1;
		GridBagLayout gl = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		setLayout(gl);



		f1 = new Font("Tahoma",Font.BOLD,50);
		f2 = new Font("Tahoma",Font.PLAIN,34);
		f3 = new Font("TimesRoman",Font.BOLD,120);
		f4 = new Font("Tahoma",Font.PLAIN,28);


		JLabel l0 = new JLabel("Cancel");
		add(l0);
		l0.setFont(f1);
		l0.setVerticalTextPosition(JLabel.TOP);
		//l0.setHorizontalTextPosition(JLabel.CENTER);
		gc.gridx = 1;
		gc.gridy = 0;
		gl.setConstraints(l0, gc);
		//l0.setBounds(420, 60, 1000, 55);

		le = new Label(" ");
		add(le);
		le.setFont(f3);
		gc.gridx = 0;
		gc.gridy = 2;
		gl.setConstraints(le, gc);

		l1 = new Label("PNR no.");
		l1.setFont(f2);
		add(l1);
		gc.gridx = 0;
		gc.gridy = 4;
		gl.setConstraints(l1, gc);


		tf1 = new TextField(20);
		add(tf1);
		gc.gridx = 1;
		gc.gridy = 4;
		gl.setConstraints(tf1, gc);




		le2 = new Label(" ");
		add(le2);
		le2.setFont(f4);
		gc.gridx = 0;
		gc.gridy = 2;
		gl.setConstraints(le2, gc);



		b1 = new Button("Submit");
		add(b1);
		b1.setFont(f4);
		b1.setBackground(Color.CYAN);
		gc.gridx = 1;
		gc.gridy = 8;
		gl.setConstraints(b1, gc);

		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				if(a.getSource()==b1)
				{
					String pnr = tf1.getText();
					int cancellation_no = num; num++;
					Connect_to_MySql C1 = new Connect_to_MySql();
					String str = "INSERT INTO cancel (pnr_no , cancellation_no) VALUES ('" +pnr+"' ,  '" +cancellation_no+"')";
					try {
						C1.S.executeUpdate(str);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					setVisible(false);
				}
			}
		});
	}
}





*/
