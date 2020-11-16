package airline.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.ResultSet;

public class MainScreen extends JFrame implements ActionListener
{

	/**
	 *
	 */
	private static final long serialVersionUID2 = 1L;
	private static final Object ReservationDetails = null;
	private static final Object FlightDetails = null;
	private static final Object PassengerDetails = null;
	private static final Object SectorDetails = null;
	private static final Object Cancellation = null;
	private static final Object E_Ticket = null;

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
		L.setBounds(0 , 0 , 1980 , 990);
		add(L);

		JLabel L2 = new JLabel("HYDRUS AIRLINES WELCOMES YOU");
		L2.setForeground(Color.BLUE);
	    L2.setFont(new Font("Aerial", Font.PLAIN , 36));
		L2.setBounds(420, 60, 1000, 55);
		L.add(L2);

		JMenuBar M = new JMenuBar();
		setJMenuBar(M);
		JMenu M1 = new JMenu("Details");
		M1.setForeground(Color.BLACK);
		M.add(M1);

        JMenuItem FlightDetails = new JMenuItem("FLIGHT INFO");
        M1.add(FlightDetails);

        JMenuItem ReservationDetails = new JMenuItem("ADD CUSTOMER DETAILS");
        M1.add(ReservationDetails);

        JMenuItem PassengerDetails = new JMenuItem("JOURNEY DETAILS");
        M1.add(PassengerDetails);

        JMenuItem SectorDetails = new JMenuItem("PAYMENT DETAILS");
        M1.add(SectorDetails);

        JMenuItem Cancellation = new JMenuItem("CANCELLATION");
        M1.add(Cancellation);

        JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.BLACK);
        M.add(Ticket);

        JMenuItem E_Ticket = new JMenuItem("E-Ticket");
        Ticket.add(E_Ticket);

        FlightDetails.addActionListener(this);
        ReservationDetails.addActionListener(this);
        PassengerDetails.addActionListener(this);
        SectorDetails.addActionListener(this);
        Cancellation.addActionListener(this);
        E_Ticket.addActionListener(this);

        setSize(1950,1090);
    	setVisible(true);

	}

    	public void actionPerformed(ActionEvent a)
        {
        	if(a.getSource()==FlightDetails)
        	{
        		new Flight_Info();
        	}

        	if(a.getSource()==ReservationDetails)
        	{
        		try
        		{
                    new Add_Customer();
        		}
        		catch (Exception e)
        		{
                    e.printStackTrace();
        		}
        	}

        	if(a.getSource()==PassengerDetails)
        	{
        		try
        		{
                    new Journey_Details();
                }
        		catch (Exception e)
        		{
                    e.printStackTrace();
        		}
        	}
        	if(a.getSource()==Cancellation)
        	{
        		new Cancel();
        	}

        	if(a.getSource()==E_Ticket)
        	{
        		new E_Ticket();
        	}

        }
}
