package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	long random;
	JTextField jname,jfname,jemail,jads,jcity,jstate,jpcode;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser dateChooser;

	SignupOne(){
		setTitle("Details");
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) * 10L);
		JLabel formno = new JLabel("APPLICATION FORM NO. "+random);
		formno.setFont(new Font("Raleway", Font.BOLD, 35));
		formno.setBounds(170, 5, 700, 38);
		add(formno);
		
		JLabel pdetails = new JLabel("Page 1 : Personal Details");
		pdetails.setFont(new Font("Raleway", Font.BOLD, 20));
		pdetails.setBounds(320, 40, 500, 38);
		add(pdetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 100, 700, 38);
		add(name);
		
		jname = new JTextField();
		jname.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jname.setBounds(320, 100, 430, 38);
		add(jname);
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 150, 700, 38);
		add(fname);
		
		jfname = new JTextField();
		jfname.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jfname.setBounds(320, 150, 430, 38);
		add(jfname);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 200, 700, 38);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		dateChooser.setBounds(320, 200, 430, 38);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 250, 700, 38);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(320, 250, 60, 38);
		male.setBackground(Color.white);
		male.setFont(new Font("Raleway", Font.BOLD,15));
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 250, 100, 38);
		female.setBackground(Color.white);
		female.setFont(new Font("Raleway", Font.BOLD,15));
		add(female);
		
		ButtonGroup bgrp = new ButtonGroup();
		bgrp.add(male);
		bgrp.add(female);
		
		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 300, 700, 38);
		add(email);
		
		jemail = new JTextField();
		jemail.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jemail.setBounds(320, 300, 430, 38);
		add(jemail);
		
		JLabel mstatus = new JLabel("Marital Status:");
		mstatus.setFont(new Font("Raleway", Font.BOLD, 20));
		mstatus.setBounds(100, 350, 700, 38);
		add(mstatus);
		
		married = new JRadioButton("Married");
		married.setBounds(320, 350, 120, 38);
		married.setBackground(Color.white);
		married.setFont(new Font("Raleway", Font.BOLD,15));
		add(married);
		
	    unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 350, 100, 38);
		unmarried.setBackground(Color.white);
		unmarried.setFont(new Font("Raleway", Font.BOLD,15));
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(600, 350, 100, 38);
		other.setBackground(Color.white);
		other.setFont(new Font("Raleway", Font.BOLD,15));
		add(other);
		
		ButtonGroup grp = new ButtonGroup();
		grp.add(married);
		grp.add(unmarried);
		grp.add(other);
		
		JLabel ads = new JLabel("Address:");
		ads.setFont(new Font("Raleway", Font.BOLD, 20));
		ads.setBounds(100, 400, 700, 38);
		add(ads);
		
		jads = new JTextField();
		jads.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jads.setBounds(320, 400, 430, 38);
		add(jads);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 450, 700, 38);
		add(city);
		
		jcity = new JTextField();
		jcity.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jcity.setBounds(320, 450, 430, 38);
		add(jcity);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 500, 700, 38);
		add(state);
		
		jstate = new JTextField();
		jstate.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jstate.setBounds(320, 500, 430, 38);
		add(jstate);
		
		JLabel pcode = new JLabel("Pin Code:");
		pcode.setFont(new Font("Raleway", Font.BOLD, 20));
		pcode.setBounds(100, 550, 700, 38);
		add(pcode);
		
		jpcode = new JTextField();
		jpcode.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
		jpcode.setBounds(320, 550, 430, 38);
		add(jpcode);
		
		next = new JButton("NEXT");
		next.setFont(new Font("Raleway",Font.BOLD,20));
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(630,630,120,38);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(900,730);
		setLocation(250,10);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = ""+random;
		String name = jname.getText();
		String fname = jfname.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}
		String email = jemail.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}else if(other.isSelected()) {
			marital = "Other";
		}
		String address = jads.getText();
		String city = jcity.getText();
		String state = jstate.getText();
		String pincode = jpcode.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else {
				Conn c = new Conn();
				String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {

		new SignupOne();
	}
}
