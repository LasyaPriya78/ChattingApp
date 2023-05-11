package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{

	JButton deposit, fast_cash, pin_change, cash_withD, ministate, balenq, exit;
	String pinno;
	
	public Transaction(String pinno) {
		
		this.pinno = pinno;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 800);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,14));
		text.setBounds(190, 250, 700, 35);
		image.add(text);        // To get the text on the image
		
		deposit = new JButton("Deposit");
		deposit.setBounds(150, 371, 130, 25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		fast_cash = new JButton("Fast Cash");
		fast_cash.setBounds(150, 402, 130, 25);
		fast_cash.addActionListener(this);
		image.add(fast_cash);
		
		pin_change = new JButton("Pin Change");
		pin_change.setBounds(150, 432, 130, 25);
		pin_change.addActionListener(this);
		image.add(pin_change);
		
		cash_withD = new JButton("Cash Withdrawal");
		cash_withD.setBounds(317, 371, 130, 25);
		cash_withD.addActionListener(this);
		image.add(cash_withD);
		
		ministate = new JButton("Mini-Statement");
		ministate.setBounds(317, 402, 130, 25);
		ministate.addActionListener(this);
		image.add(ministate);
		
		balenq = new JButton("Balance Enquiry");
		balenq.setBounds(317, 432, 130, 25);
		balenq.addActionListener(this);
		image.add(balenq);
		
		exit = new JButton("Exit");
		exit.setBounds(317, 462, 130, 25);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(800,800);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == exit) {
			System.exit(0);
		}else if (ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinno).setVisible(true);
		}else if(ae.getSource() == cash_withD) {
			setVisible(false);
			new Withdrawal(pinno).setVisible(true);
		}else if(ae.getSource() == fast_cash) {
			setVisible(false);
			new Fast_Cash(pinno).setVisible(true);
		}else if(ae.getSource() == pin_change) {
			setVisible(false);
			new PinChange(pinno).setVisible(true);
		}else if(ae.getSource() == balenq) {
			setVisible(false);
			new BalanceEnquiry(pinno).setVisible(true);
		}else if(ae.getSource() == ministate) {
			new MiniStatement(pinno).setVisible(true);
		}
	}
	public static void main(String[] args) {

		
		new Transaction("");
	}
	

}
