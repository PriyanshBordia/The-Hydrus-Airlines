package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.ResultSet;

public class MainScreen extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	
	
	public static void main(String[] args)
	{
		new MainScreen();
	}
	
	public MainScreen()
	{
		super("AIRLINE RESERVATION SYSTEM");
		
		//Set the text color
		setForeground(Color.white);
		
		setLayout(null);    // For custom layout
		
		//Layout for image.
		JLabel L = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/airplane-fact.jpg")).getImage();
		L.setIcon(new ImageIcon(img)); 
		L.setBounds(0 , 0 , 1500 , 990); 
		add(L);
		
		JLabel L2 = new JLabel("HYDRUS AIRLINES WELCOMES YOU");
		L2.setForeground(Color.BLUE);
	    L2.setFont(new Font("Aerial", Font.PLAIN , 36));
		L2.setBounds(370, 60, 1000, 55); 
		L.add(L2);
	
		JMenuBar M = new JMenuBar();
		setJMenuBar(M);
		JMenu M1 = new JMenu("Details"); 
		M1.setForeground(Color.BLACK);
		M.add(M1);
		
        JMenuItem FlightDetails = new JMenuItem("FLIGHT INFO");
        M1.add(FlightDetails);
        
        JMenuItem ALL_FLI = new JMenuItem("ALL FLIGHT");
        M1.add(ALL_FLI);

        JMenuItem ALL_Pass = new JMenuItem("PASSENGER DETAILS");
        M1.add(ALL_Pass);
        
        JMenuItem ReservationDetails = new JMenuItem("BOOK TICKET"); 
        M1.add(ReservationDetails);
		
        JMenuItem Cancellation = new JMenuItem("CANCELLATION");
        M1.add(Cancellation);
		
        JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.BLACK);
        M.add(Ticket);
		
        JMenuItem eTicket = new JMenuItem("eTicket"); 
        Ticket.add(eTicket); 
        
        FlightDetails.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new Flight_Info();
            }
        });
        
        ALL_FLI.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new All_Flights();
            }
        });
        
        ALL_Pass.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new All_Passenger();
            }
        });
        
        ReservationDetails.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                    new Add_Customer();
            }
        });
		
        Cancellation.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new Cancel();
            }
        });
        
        eTicket.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                new Printing(); 
            }
        });
        
        setSize(1950,1090);
    	setVisible(true);
        
	}
}
		
	