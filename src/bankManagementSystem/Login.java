package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	
	
	JButton login, clear, signup;
	JTextField cardfield;
	JPasswordField pinfield; 
	Login(){
	
		setTitle("Banking System");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(110, 10, 100, 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to Bank");
		text.setFont(new Font("Osward", Font.BOLD,58));
		text.setForeground(Color.black);
		text.setBounds(290, 40, 500, 50);
		add(text);
		
		JLabel cardno = new JLabel("Card.no: ");
		cardno.setFont(new Font("Osward", Font.BOLD,28));
		cardno.setForeground(Color.DARK_GRAY);
		cardno.setBounds(150, 190, 150, 40);
		add(cardno);
		
		cardfield = new JTextField();
		cardfield.setFont(new Font("Osward", Font.PLAIN,20));
		cardfield.setBackground(Color.LIGHT_GRAY);
		cardfield.setBounds(310, 190, 350, 40);
		add(cardfield);
		
		
		JLabel pin = new JLabel("Pin: ");
		pin.setFont(new Font("Osward", Font.BOLD,28));
		pin.setForeground(Color.DARK_GRAY);
		pin.setBounds(150, 260, 150, 40);
		add(pin);
		
		pinfield = new JPasswordField();
		pinfield.setFont(new Font("Osward", Font.PLAIN,20));
		pinfield.setBackground(Color.LIGHT_GRAY);
		pinfield.setBounds(310, 260, 350, 40);
		add(pinfield);
		
		login = new JButton("SIGN-IN");
		login.setBounds(310,350,150,40);
		login.setBackground(Color.yellow);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(510,350,150,40);
		clear.setBackground(Color.yellow);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN-UP");
		signup.setBounds(410,450,150,40);
		signup.setBackground(Color.yellow);
		signup.addActionListener(this);
		add(signup);
		
		
		getContentPane().setBackground(Color.WHITE);
		setSize(1000,600);
		setLocation(200,90);
		setVisible(true);
		
	}	
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource() == clear) {
				cardfield.setText("");
				pinfield.setText("");
			}
			else if(ae.getSource() == signup) {
				setVisible(false);                          // to close the current frame
				new SignupOne().setVisible(true);           // to display signup frame
			}
			else if(ae.getSource() == login) {
				
				String cardno = cardfield.getText();
				String pinno = pinfield.getText();
				
				Conn c = new Conn();
				String query = "select * from login where Card_Number ='"+cardno+"' and Pin_Number ='"+pinno+"'";
				try {
				ResultSet rs = c.s.executeQuery(query);      //it will return some value from db so store it in resultset
				if(rs.next()) {
					setVisible(false);
					new Transaction(pinno).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
				}
	
			}catch(Exception e) {
				System.out.println(e);
			}
			}
			
		}
	public static void main(String[] args)  {
  
		new Login();
	}
}
