package bankManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	JTextField pan_no,adhaar_no;
	JButton next;
	JRadioButton yes,no,eyes,eno;
	JComboBox vreligion, vcategory, vincome, veducation, voccupation;
	String formno;
		
	public SignupTwo(String formno) {
		
		    this.formno = formno;
			setTitle("Additional Details");
			setLayout(null);
			
			JLabel adetails = new JLabel("Page 2 : Additional Details");
			adetails.setFont(new Font("Raleway", Font.BOLD, 20));
			adetails.setBounds(320, 40, 500, 38);
			add(adetails);
			
			JLabel religion = new JLabel("Religion:");
			religion.setFont(new Font("Raleway", Font.BOLD, 20));
			religion.setBounds(100, 100, 700, 38);
			add(religion);
			
			String valrel[] = {"Hindu","Muslim","Sikh","Christian","Others"};
			vreligion = new JComboBox(valrel);
			vreligion.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			vreligion.setBackground(Color.white);
			vreligion.setBounds(380, 100, 430, 38);
			add(vreligion);
			
			JLabel category = new JLabel("Category:");
			category.setFont(new Font("Raleway", Font.BOLD, 20));
			category.setBounds(100, 150, 700, 38);
			add(category);
			
			String valcat[] = {"General","OBC","SC","ST","Others"};
			vcategory = new JComboBox(valcat);
			vcategory.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			vcategory.setBackground(Color.white);
			vcategory.setBounds(380, 150, 430, 38);
			add(vcategory);
			
			JLabel income = new JLabel("Income:");
			income.setFont(new Font("Raleway", Font.BOLD, 20));
			income.setBounds(100, 200, 700, 38);
			add(income);
			
			String valinc[] = {"Null","< 1,50,000","<2,50,000","< 5,00,000","upto 10,00,000"};
			vincome = new JComboBox(valinc);
			vincome.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			vincome.setBackground(Color.white);
			vincome.setBounds(380, 200, 430, 38);
			add(vincome);
			
			JLabel education = new JLabel("Eduational\n Qualification:");
			education.setFont(new Font("Raleway", Font.BOLD, 20));
			education.setBounds(100, 250, 700, 38);
			add(education);
			
			String valedq[] = {"Non Graduate","Graduate","Post Graduate","Doctrate","Others"};
			veducation = new JComboBox(valedq);
			veducation.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			veducation.setBackground(Color.white);
			veducation.setBounds(380, 250, 430, 38);
			add(veducation);
			
			JLabel occupation = new JLabel("Occupation:");
			occupation.setFont(new Font("Raleway", Font.BOLD, 20));
			occupation.setBounds(100, 300, 700, 38);
			add(occupation);
			
			String valocp[] = {"Salaried","Self Employed","Business","Student","Retired","Others"};
			voccupation = new JComboBox(valocp);
			voccupation.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			voccupation.setBackground(Color.white);
			voccupation.setBounds(380, 300, 430, 38);
			add(voccupation);
			
			JLabel pno = new JLabel("PAN Number:");
			pno.setFont(new Font("Raleway", Font.BOLD, 20));
			pno.setBounds(100, 350, 700, 38);
			add(pno);
			
			pan_no = new JTextField();
			pan_no.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			pan_no.setBounds(380, 350, 430, 38);
			add(pan_no);
			
			JLabel adno = new JLabel("Adhaar Number:");
			adno.setFont(new Font("Raleway", Font.BOLD, 20));
			adno.setBounds(100, 400, 700, 38);
			add(adno);
			
			adhaar_no = new JTextField();
			adhaar_no.setFont(new Font("Raleway",Font.LAYOUT_LEFT_TO_RIGHT,20));
			adhaar_no.setBounds(380, 400, 430, 38);
			add(adhaar_no);
			
			JLabel scitz = new JLabel("Senior Citizen:");
			scitz.setFont(new Font("Raleway", Font.BOLD, 20));
			scitz.setBounds(100, 450, 700, 38);
			add(scitz);
			
			yes = new JRadioButton("Yes");
			yes.setBounds(375, 450, 60, 38);
			yes.setBackground(Color.white);
			yes.setFont(new Font("Raleway", Font.BOLD,15));
			add(yes);
			
			no = new JRadioButton("No");
			no.setBounds(505, 450, 100, 38);
			no.setBackground(Color.white);
			no.setFont(new Font("Raleway", Font.BOLD,15));
			add(no);
			
			ButtonGroup bgrp = new ButtonGroup();
			bgrp.add(yes);
			bgrp.add(no);
			
			JLabel eacc = new JLabel("Existing Account:");
			eacc.setFont(new Font("Raleway", Font.BOLD, 20));
			eacc.setBounds(100, 500, 700, 38);
			add(eacc);
			
			eyes = new JRadioButton("Yes");
			eyes.setBounds(375, 500, 60, 38);
			eyes.setBackground(Color.white);
			eyes.setFont(new Font("Raleway", Font.BOLD,15));
			add(eyes);
			 
			eno = new JRadioButton("No");
			eno.setBounds(505, 500, 100, 38);
			eno.setBackground(Color.white);
			eno.setFont(new Font("Raleway", Font.BOLD,15));
			add(eno);
			
			ButtonGroup ebgrp = new ButtonGroup();
			ebgrp.add(eyes);
			ebgrp.add(eno);
			
			next = new JButton("NEXT");
			next.setFont(new Font("Raleway",Font.BOLD,20));
			next.setBackground(Color.black);
			next.setForeground(Color.white);
			next.setBounds(690,630,120,38);
			next.addActionListener(this);
			add(next);
			
			getContentPane().setBackground(Color.white);
			setSize(900,730);
			setLocation(250,10);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent ae) {
		   
			String religion = (String) vreligion.getSelectedItem();
			String category = (String) vcategory.getSelectedItem();
			String income = (String) vincome.getSelectedItem();
			String eduQualification = (String) veducation.getSelectedItem();
			String occupation = (String) voccupation.getSelectedItem();
			String pan_number = pan_no.getText();
			String adhaar_number = adhaar_no.getText();
			String senior_citz = null;
			if(yes.isSelected()) {
				senior_citz = "Yes";
			}else if(no.isSelected()) {
				senior_citz = "No";
			}
			String exist_account = null;
			if(eyes.isSelected()) {
				exist_account = "Yes";
			}
			else if(eno.isSelected()) {
				exist_account = "No";
			}
			try {
			Conn c = new Conn();
			String query = "insert into signuptwo values ('"+formno+"','"+religion+"','"+category+"','"+income+"','"+eduQualification+"','"+occupation+"','"+pan_number+"','"+adhaar_number+"','"+senior_citz+"','"+exist_account+"')";
			c.s.executeUpdate(query);
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			
			}catch (Exception e) {
				System.out.println(e);
			}
		
	}

	public static void main(String[] args) {

		new SignupTwo("");
	}

}
