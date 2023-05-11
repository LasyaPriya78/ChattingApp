package bankManagementSystem;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

	JButton change, back;
	JPasswordField npin, rpin;
	String pinno;
	public PinChange(String pinno) {
		
		this.pinno = pinno;
	    setLayout(null);
	
	     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
	     Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
	     ImageIcon i3 = new ImageIcon(i2);
	     JLabel image = new JLabel(i3);
	     image.setBounds(0, 0, 800, 800);
	     add(image);
	
	     JLabel text = new JLabel("CHANGE YOUR PIN");
	     text.setForeground(Color.white);
	     text.setFont(new Font("System",Font.BOLD,17));
	     text.setBounds(220, 255, 700, 35);
	     image.add(text);    
	     
	     JLabel pin = new JLabel("New PIN:");
	     pin.setForeground(Color.white);
	     pin.setFont(new Font("System",Font.BOLD,15));
	     pin.setBounds(150, 300, 700, 35);
	     image.add(pin);  
	     
	     JLabel repin = new JLabel("Re-Enter New PIN:");
	     repin.setForeground(Color.white); 
	     repin.setFont(new Font("System",Font.BOLD,15));
	     repin.setBounds(150, 345, 700, 35);
	     image.add(repin);  
	     
	     npin = new JPasswordField();
	     npin.setBounds(300, 305, 150, 25);
	     npin.setFont(new Font("System",Font.BOLD,15));
	     image.add(npin);
	     
	     rpin = new JPasswordField();
	     rpin.setBounds(300, 350, 150, 25);
	     rpin.setFont(new Font("System",Font.BOLD,15));
	     image.add(rpin);
	     
	     change = new JButton("CHANGE");
	     change.setBounds(317, 432, 130, 25);
	     change.addActionListener(this);
		 image.add(change);
			
		 back = new JButton("BACK");
		 back.setBounds(317, 462, 130, 25);
		 back.addActionListener(this);
		 image.add(back);     
	     
	
	     setSize(800,800);
	     setLocation(300,0);
	     setUndecorated(true);
	     setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}
		else if(ae.getSource() == change) {
			
			String new_pin = npin.getText();
			String re_pin = rpin.getText();
			
			if(new_pin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the new pin");
				return;
			}
			
			if(re_pin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter the new pin");
				return;
			}
			if(!new_pin.equals(re_pin)) {
				JOptionPane.showMessageDialog(null, "Entered pin does not exist");
				return;
			}
			try {
				
				Conn c = new Conn();
				String query1 = "update bank set Pin =  '"+re_pin+"' where Pin = '"+pinno+"'";
				String query2 = "update login set Pin_Number =  '"+re_pin+"' where Pin_Number = '"+pinno+"'";
				String query3 = "update signupthree set Pin_Number =  '"+re_pin+"' where Pin_Number = '"+pinno+"'";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
				setVisible(false);
				new Transaction(re_pin).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}
	public static void main(String[] args) {

		new PinChange("");
	}

	

}
