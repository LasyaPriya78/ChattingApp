package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener{
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit, cancel;
	String formno;
	
	public SignupThree(String formno) {
		
		this.formno = formno;
		setTitle("Account Details");
		setLayout(null);
		
		JLabel details = new JLabel("Page 3 : Account Details");
		details.setFont(new Font("Raleway", Font.BOLD, 20));
		details.setBounds(270, 40, 500, 38);
		add(details);
		
		JLabel acctype = new JLabel("Account Type:");
		acctype.setFont(new Font("Raleway", Font.BOLD, 20));
		acctype.setBounds(100, 120, 700, 38);
		add(acctype);
		
		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 15));
		r1.setBackground(Color.white);
		r1.setBounds(100, 160, 200, 28);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 15));
		r2.setBackground(Color.white);
		r2.setBounds(350, 160, 300, 28);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 15));
		r3.setBackground(Color.white);
		r3.setBounds(100, 200, 200, 28);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 15));
		r4.setBackground(Color.white);
		r4.setBounds(350, 200, 300, 28);
		add(r4);
		
		ButtonGroup brgp = new ButtonGroup();
		brgp.add(r1);
		brgp.add(r2);
		brgp.add(r3);
		brgp.add(r4);
		
		JLabel cardnumber = new JLabel("Card Number:");
		cardnumber.setFont(new Font("Raleway", Font.BOLD, 20));
		cardnumber.setBounds(100, 300, 400, 38);
		add(cardnumber);
		
		JLabel num = new JLabel("XXXX-XXXX-XXXX-4189");
		num.setFont(new Font("Raleway", Font.BOLD, 20));
		num.setBounds(330, 300, 400, 38);
		add(num);
		
		JLabel statem = new JLabel("Your 16 Digit Card Number");
		statem.setFont(new Font("Raleway", Font.BOLD, 11));
		statem.setBounds(100, 338, 400, 18);
		add(statem);
		
		JLabel pinnumber = new JLabel("PIN:");
		pinnumber.setFont(new Font("Raleway", Font.BOLD, 20));
		pinnumber.setBounds(100, 380, 400, 38);
		add(pinnumber);
		
		JLabel pnum = new JLabel("XXXX");
		pnum.setFont(new Font("Raleway", Font.BOLD, 20));
		pnum.setBounds(330, 380, 400, 38);
		add(pnum);
		
		JLabel pstatem = new JLabel("Your 4 Digit Password");
		pstatem.setFont(new Font("Raleway", Font.BOLD, 11));
		pstatem.setBounds(100, 410, 400, 38);
		add(pstatem);
		
		JLabel services = new JLabel("Services Required:");
		services.setFont(new Font("Raleway", Font.BOLD, 20));
		services.setBounds(100, 470, 400, 38);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway", Font.BOLD, 15));
		c1.setBackground(Color.white);
		c1.setBounds(100, 520, 200, 28);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway", Font.BOLD, 15));
		c2.setBackground(Color.white);
		c2.setBounds(350, 520, 200, 28);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway", Font.BOLD, 15));
		c3.setBackground(Color.white);
		c3.setBounds(100, 560, 200, 28);
		add(c3);
		
		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setFont(new Font("Raleway", Font.BOLD, 15));
		c4.setBackground(Color.white);
		c4.setBounds(350, 560, 200, 28);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setFont(new Font("Raleway", Font.BOLD, 15));
		c5.setBackground(Color.white);
		c5.setBounds(100, 600, 200, 28);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway", Font.BOLD, 15));
		c6.setBackground(Color.white);
		c6.setBounds(350, 600, 200, 28);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above entered details are correct as per my knowledge");
		c7.setFont(new Font("Raleway", Font.BOLD, 11));
		c7.setBackground(Color.white);
		c7.setBounds(100, 650, 500, 28);
		add(c7);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Raleway", Font.BOLD, 15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setBounds(350, 690, 120, 35);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Raleway", Font.BOLD, 15));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(500, 690, 120, 35);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		setSize(800,820);
		setLocation(250,0);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == submit) {
			
			String accounttype = null;
			if(r1.isSelected()) {
				accounttype = "Saving Account";
			}else if (r2.isSelected()) {
				accounttype = "Fixed Deposit Account";
			}else if (r3.isSelected()) {
				accounttype = "Current Account";
			}else if(r4.isSelected()) {
				accounttype = "Recurring Deposit Account";
			}
		
		Random ran = new Random();
		String card_number = "" +  Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
		String pin_number = "" +  Math.abs((ran.nextLong() % 9000L) + 1000L);
		String service = "";
		if(c1.isSelected()) {
			service = service + " ATM Card";
		} else if(c2.isSelected()) {
			service = service + " Internet Banking";
		}else if(c3.isSelected()) {
			service = service + " Mobile Banking";
		}else if(c4.isSelected()) {
			service = service + " Email & SMS Alerts";
		}else if(c5.isSelected()) { 
			service = service + " Cheque Book";
		}else if(c6.isSelected()) {
			service = service + " E-Statement";
		}
		
		try {
			
			Conn c = new Conn();
			String query1 = "insert into signupthree values('"+formno+"', '"+accounttype+"', '"+card_number+"', '"+pin_number+"', '"+service+"')";
			String query2 = "insert into login values ('"+formno+"', '"+card_number+"', '"+pin_number+"')";
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			
			JOptionPane.showMessageDialog(null, "Your Card Number is: " +card_number + "\n Your Pin Number is: " +pin_number);
			setVisible(false);
			new Deposit(pin_number).setVisible(true);
			
		}catch(Exception e) {
			System.out.println(e);
		
		}}
		else if (ae.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	
	public static void main(String[] args) {

		new SignupThree("");
	}

}
