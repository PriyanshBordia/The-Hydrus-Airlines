package airline.reservation.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		new login(); 
	}
	
	Label l1 , l2;
    Button b1 , b2;
    TextField t1 , t2;
    GridBagLayout gl;  
    GridBagConstraints gc; 
    Font f1 , f2;
    
    public login()
    {
    	super("Login"); 	
    	
    	setBackground(Color.white);
    	
    	//Setting the font!!
    	f1 = new Font("TimesRoman" , Font.BOLD , 20);
    	f2 = new Font("TimesRoman" , Font.BOLD , 15);
    	
    	//Grid Layout
    	gl = new GridBagLayout(); 
    	gc = new GridBagConstraints();
    	setLayout(gl);
    	
    	//Creating Label
    	l1 = new Label("Username : ");
    	l1.setFont(f1);
    	l2 = new Label("Password : ");
    	l2.setFont(f1);					
    	
    	//Creating Textfield for user
    	t1 = new TextField(15);
    	t2 = new TextField(15);
    	t2.setEchoChar('*');
    	
    	//Adding Buttons
    	b1 = new Button("Submit");
    	b1.setFont(f2);
    	b2 = new Button("Cancel");
    	b2.setFont(f2);
    	
    	//Specifying the positions of every labels , buttons etc.
    	gc.gridx = 0;
    	gc.gridy = 0;
    	gl.setConstraints(l1 , gc);
    	add(l1);
    	
    	gc.gridx = 2;
        gc.gridy = 0;
        gl.setConstraints(t1 , gc);
        add(t1);
		
        gc.gridx = 0;
        gc.gridy = 2;
        gl.setConstraints(l2 , gc);
        add(l2);

        gc.gridx = 2;
        gc.gridy = 2;
        gl.setConstraints(t2 , gc);
        add(t2);    
	
        gc.gridx=0;
        gc.gridy=8;
        gl.setConstraints(b1 , gc);
        add(b1);
        
        gc.gridx = 4;
    	gc.gridy = 8;
        gl.setConstraints(b2 , gc);
    	add(b2); 
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setVisible(true);
        setSize(400 , 250);
        setLocation(400 , 200);
           
    }
    
    
    // Method for defining the action created by buttons
    public void actionPerformed(ActionEvent a)
    {
    	if(a.getSource()==b1)
    	{
    		try
    		{
    			Connect_to_MySql C1 = new Connect_to_MySql();
    			String s1 = t1.getText();
    			String s2 = t2.getText();
    			String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
                ResultSet R = C1.S.executeQuery(str);  
                
                if(R.next())
                {
                    new MainScreen();
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null , "Invalid Username or Password used"); 
                    setVisible(false); 
                }
    		}
    		catch(Exception e)
    		{
    			System.out.println(e); 
    		}
    	}
    		
    	if(a.getSource()==b2)
    	{
    		System.exit(0);
    	}
    }
}
