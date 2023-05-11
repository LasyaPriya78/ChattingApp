package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;


public class Fast_Cash extends JFrame implements ActionListener {
	
	JButton a1, a2, a3, a4, a5, a6, a7, back;
	String pinno;
	
	public Fast_Cash(String pinno) {
		
		this.pinno = pinno;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 800);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,17));
		text.setBounds(167, 270, 700, 35);
		image.add(text);        // To get the text on the image
		
		a1 = new JButton("Rs 100");
		a1.setBounds(150, 371, 130, 25);
		a1.addActionListener(this);
		image.add(a1);
		
		a2 = new JButton("Rs 1000");
		a2.setBounds(150, 402, 130, 25);
		a2.addActionListener(this);
		image.add(a2);
		
		a3 = new JButton("Rs 5000");
		a3.setBounds(150, 432, 130, 25);
		a3.addActionListener(this);
		image.add(a3);
		
		a4 = new JButton("Rs 500");
		a4.setBounds(317, 371, 130, 25);
		a4.addActionListener(this);
		image.add(a4);
		
		a5 = new JButton("Rs 2000");
		a5.setBounds(317, 402, 130, 25);
		a5.addActionListener(this);
		image.add(a5);
		
		a6 = new JButton("Rs 10000");
		a6.setBounds(317, 432, 130, 25);
		a6.addActionListener(this);
		image.add(a6);
		
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

		try {
		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinno).setVisible(true);
		}else {
			  
			    
				String amount = ((JButton) ae.getSource()).getText().substring(3); //substring would remove Rs and space to return just 500
				//System.out.println(amount); 
				Conn c = new Conn();
				
				int balance = 0;	
			    ResultSet rs= c.s.executeQuery("select * from bank where Pin = '"+pinno+"' ");
			    while(rs.next()) {
				   if(rs.getString("Type").equals("Deposit")) {
					
				      balance += Integer.parseInt(rs.getString("Amount")); //rs returns a string so convert it to Int
			        } 
				   else {
				       balance -= Integer.parseInt(rs.getString("Amount"));
			 }
			}
			if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null, "Insufficient Balance");
				return;
			}else {
				Date date = new Date();
				String query = "insert into bank values('"+pinno+"','"+date+"','Withdrawal','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Amount Rs "+amount+ " is successfully withdrawn");
				setVisible(false);
				new Transaction(pinno).setVisible(true);
			}
		
		
		}
	} catch(Exception e) {
		System.out.println(e);
	}
	} 	
	public static void main(String[] args) throws Exception {
		
           new Fast_Cash(" ");
	}

}
