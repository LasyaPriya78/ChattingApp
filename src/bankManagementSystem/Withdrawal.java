package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener{

	JButton withdraw, back;
	JTextField amount;
	String pinno;
	
	public Withdrawal(String pinno)  {
		
		this.pinno = pinno;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 800);
		add(image);
		
		JLabel text = new JLabel("Enter the amount of money you want to withdraw:");
		text.setFont(new Font("System", Font.BOLD,11));
		text.setBounds(150, 270,500,28 );
		text.setForeground(Color.white);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD,15));
		amount.setBounds(150, 320,300,28 );
		amount.setForeground(Color.black);
		image.add(amount);
		
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(317, 432, 130, 25);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
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
			new Transaction("pinno").setVisible(true);
		}else if (ae.getSource() == withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}else {
				
				try {
				Conn c = new Conn();
				String query = "insert into bank values('"+pinno+"','"+date+"','Withdrawal','"+number+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Your amount "+number+ " successfully withdrawn");
				setVisible(false);
                new Transaction(pinno).setVisible(true);
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	public static void main(String[] args) {

		new Withdrawal("");
	}
}

	
