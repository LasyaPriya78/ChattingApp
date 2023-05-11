package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {

	JButton exit;
	public MiniStatement(String pinno) {

		setTitle("Mini_Statement");
		setLayout(null);
		
		JLabel text = new JLabel("Indian Bank");
		text.setBounds(150, 20, 200, 28);
		text.setFont(new Font("Raleway", Font.BOLD, 15));
		add(text);
		
		JLabel mini = new JLabel();
		mini.setBounds(25, 150, 500, 200);
		add(mini);
		
		JLabel card = new JLabel();
		card.setBounds(25, 80, 300, 28);
		//card.setForeground(Color.black);
		add(card);
		
		JLabel bal = new JLabel();
		bal.setBounds(25,400,300,28);
		add(bal);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from login where Pin_Number = '"+pinno+"'");
			while(rs.next()) {
				card.setText("Card Number: " +rs.getString("Card_Number").substring(0,4) + "XXXXXXXX" + rs.getString("Card_Number").substring(12));
			}
		}catch(Exception e) {
			System.out.println(e);
			}
		
		
		try {
			Conn c = new Conn();
			int balance = 0;
			ResultSet rs = c.s.executeQuery("select * from bank where Pin = '"+pinno+"'");
			while(rs.next()) {
				
				   mini.setText(mini.getText() + "<html>" +rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+ "<br><br><html>" );
	    		   if(rs.getString("Type").equals("Deposit")) {
	    			   balance += Integer.parseInt(rs.getString("Amount"));
	    		   }else {
	    			   balance -= Integer.parseInt(rs.getString("Amount"));
	    		   }
	       }
			
	    bal.setText("Your Current Account Balance is: Rs. " +balance);
			
	    
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		exit = new JButton("Exit");
		exit.setBounds(25, 550, 100, 28);
		exit.addActionListener(this);
		add(exit);
		
		setSize(400,650);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
	}
	
    @Override
	public void actionPerformed(ActionEvent e) {

		setVisible(false);
		//new Transaction(pinno).setVisible(true);
	}

	public static void main(String[] args) {

		new MiniStatement("");
	}

	
}
