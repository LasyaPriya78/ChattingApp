package bankManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

	JButton back;
	String pinno;
	public BalanceEnquiry(String pinno) {
		this.pinno = pinno;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
	    Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3);
	    image.setBounds(0, 0, 800, 800);
	    add(image);	
	    
	    back = new JButton("BACK");
	    back.setBounds(317, 462, 130, 25);
	    back.addActionListener(this);
	    image.add(back);         
	    
	    Conn c = new Conn();
	    int balance = 0;
	    try {
	    	
	    	ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinno+"' ");
	    	while(rs.next()) {
	    		if(rs.getString("Type").equals("Deposit")) {
	    			balance += Integer.parseInt(rs.getString("Amount"));
	    		}else {
	    			balance -= Integer.parseInt(rs.getString("Amount"));
	    		}
	    }
	    	
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
	    
	    JLabel text = new JLabel("Your Current Account Balance is: Rs. " +balance);
	    text.setForeground(Color.white);
	    text.setBounds(150, 300, 700, 35);
	    image.add(text);
	    
		
	    setSize(800,800);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);	
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		new Transaction(pinno).setVisible(true);
	}
	public static void main(String[] args) {

		new BalanceEnquiry("");
	}

	

}
