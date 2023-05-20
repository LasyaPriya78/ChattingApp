package Chatting_Application;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*; // child package of util for displaying simple hr and min format

import javax.swing.*;
import javax.swing.border.*;  //it is the child package of swing package 
import java.net.*;
import java.io.*;

public class Client implements ActionListener{

	JTextField textbox;
	static JPanel p2;
	static Box vertical = Box.createVerticalBox();
	static DataOutputStream dout;
	static JFrame f = new JFrame();
	
	public Client() {
		
		f.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(7,94,84));
		p1.setLayout(null);
		p1.setBounds(0,0,450,70);
		f.add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("3.png"));
		Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel back = new JLabel(i3);		
		back.setBounds(5,20,25,25);
		p1.add(back);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("2.png"));
		Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel profile = new JLabel(i6);		
		profile.setBounds(40,10,50,50);
		p1.add(profile);
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("video.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i9 = new ImageIcon(i8);
		JLabel video = new JLabel(i9);		
		video.setBounds(300,20,30,30);
		p1.add(video);
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("phone.png"));
		Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon i12 = new ImageIcon(i11);
		JLabel phone = new JLabel(i12);		
		phone.setBounds(363,20,30,30);
		p1.add(phone);
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("3icon.png"));
		Image i14 = i13.getImage().getScaledInstance(12, 30, Image.SCALE_DEFAULT);
		ImageIcon i15 = new ImageIcon(i14);
		JLabel morevert = new JLabel(i15);		
		morevert.setBounds(420,20,12,30);
		p1.add(morevert);
		
		JLabel name = new JLabel("Bunny_bOy");
		name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		name.setForeground(Color.white);
		name.setBounds(110,15,200,20);
		p1.add(name);
		
		JLabel status = new JLabel("Online");
		status.setFont(new Font("SAN_SERIF",Font.BOLD,13));
		status.setForeground(Color.white);
		status.setBounds(110,38,100,20);
		p1.add(status);
		
		p2 = new JPanel();
		p2.setBounds(5,75,440,570);
		f.add(p2);
		
		textbox = new JTextField();
		textbox.setBounds(5,655,330,40);
		textbox.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		f.add(textbox);
		
		JButton send = new JButton("SEND");
		send.setBounds(340,655,105,40);
		send.setBackground(new Color(7,97,84));
		send.setForeground(Color.white);
		send.setFont(new Font("SEN_SERIF",Font.BOLD,16));
		send.addActionListener(this);
		f.add(send);
				
		f.setSize(450,700);
		f.setLocation(800,30);
		f.getContentPane().setBackground(Color.white);
		f.setUndecorated(true);
     	f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
      try { 
		String out = textbox.getText();
		p2.setLayout(new BorderLayout());
		
		JPanel p3 = FormatLabel(out);
		
		
		JPanel right = new JPanel(new BorderLayout());  //to print the text on to right side
		right.add(p3,BorderLayout.LINE_END);
		vertical.add(right);                            //to get text one after the other
		vertical.add(Box.createVerticalStrut(15));      //to have a gap of 15 between each message
		
		p2.add(vertical, BorderLayout.PAGE_START);      //to make vertical to start on starting of left side and we want text to be printed on the end of that line
		
		dout.writeUTF(out);
		
		textbox.setText("");       //to empty the text box after sending the msg
		f.repaint();
		f.invalidate();
		f.validate();
		
	}catch(Exception ae) {
		ae.printStackTrace();
	}
	}
	public static JPanel FormatLabel (String out) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel output = new JLabel("<html><p style=\"width = 150px\" border-radius : 10px>"+out+"</p></html>");
		output.setFont(new Font("Tahoma",Font.PLAIN,20));
		output.setBackground(new Color(220,248,198));
		output.setOpaque(true);
		output.setBorder(new EmptyBorder(15,15,15,50)); // to get the padding for the message
		
		
        panel.add(output);	
		
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));   //to display time under the msg y taking format of hh mm from sdf and current time from cal
        panel.add(time);
        
        
		return panel;
	}
	public static void main(String[] args) {
         new Client();
         try {
        	 Socket s = new Socket("127.0.0.1", 6001);
        	 DataInputStream din = new DataInputStream(s.getInputStream());
        	 dout = new DataOutputStream(s.getOutputStream());
        	 while(true) {
        		 p2.setLayout(new BorderLayout());
        		 String msg = din.readUTF();
        		 JPanel panel = FormatLabel(msg);
        		 JPanel left = new JPanel(new BorderLayout());
        		 left.add(panel, BorderLayout.LINE_START);
        		 vertical.add(left);
        		 vertical.add(Box.createVerticalStrut(15));
        		 p2.add(vertical, BorderLayout.PAGE_START);
        		 f.validate();
        	 }
        	 
         }catch(Exception e) {
        	 e.printStackTrace();
         }
         
	}
	

}
