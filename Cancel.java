package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Cancel extends Add_Customer
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Cancel();
	}

	Cancel(){
		init();
	}

	private void init() {

		setTitle("Ticket Cancel");

		setVisible(true);
		setSize(1000,600);
		setLocation(450,200);

		/*ImageIcon img = loadImage();
		JLabel lab = new JLabel(img);
		add(lab);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/

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

		l1 = new Label("PNR No.");
		l1.setFont(f2);
		add(l1);
		gc.gridx = 0;
		gc.gridy = 4;
		gl.setConstraints(l1, gc);


		l2 = new Label("Password");
		add(l2);
		l2.setFont(f2);
		gc.gridx = 0;
		gc.gridy = 6;
		gl.setConstraints(l2, gc);


		tf1 = new TextField(20);
		add(tf1);
		gc.gridx = 1;
		gc.gridy = 4;
		gl.setConstraints(tf1, gc);

		tf2 = new TextField(20);
		add(tf2);
		gc.gridx = 1;
		gc.gridy = 6;
		gl.setConstraints(tf2, gc);
		tf2.setEchoChar('*');

		/*tf3 = new TextField(20);
		add(tf3);*/

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
					String s_pnr = tf1.getText();
					String s_password = tf2.getText();
					/*
					 DATABSE ENTRY EXIT YET TO BE DONE!!
					 */
					setVisible(false);
				}
			}
		});
	}
}
