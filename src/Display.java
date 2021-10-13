/*
mport javax.swing.JFrame; //or use JApplet://import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
*/
//Topgyal Gurung
//MAC 190-5425
//Project 
//Created by Topgyal Gurung on DEC 1, 2016.
//Copyright © 2016 Topgyal Gurung. All rights reserved

import java.awt.*; //awt layouts
import java.awt.event.*; //awt event classes and listener interfaces
import javax.swing.*; //swing components and containers
import javax.swing.border.Border;

import java.sql.*;

public class Display extends JFrame implements ActionListener {

	public static final int WIDTH = 420; // size of JFrame
	public static final int HEIGHT = 420;

	// make it private and use getter and setter method
	private double balance;
	private double withdraw;
	private double deposit;

	public double excess = 10000.0;

	public Display(double b, double w, double d) {
		balance = b;
		withdraw = w;
		deposit = d;
	}
	private String suggest = null;
	private JTextArea theText; // user can ask que in textarea.
	
	JMenuBar menuBar;
	JMenu file;
	JMenu edit;
	JMenu search;
	JMenu help;
	
	JMenuItem loadItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	

	public Display() {
		balance = 0.0;
		withdraw = 0.0;
		deposit = 0.0;
		WindowDestroyer listener = new WindowDestroyer();
		addWindowListener(listener);
		
		JMenuBar menuBar=new JMenuBar();
		this.setJMenuBar(menuBar);
		
		file=new JMenu("Home");
		edit=new JMenu("Sign in");
		search=new JMenu("Search");
		help=new JMenu("Help");
		
		// for File
		loadItem=new JMenuItem("Load");
		saveItem=new JMenuItem("Save");
		exitItem=new JMenuItem("Exit");
		loadItem.addActionListener(this);
		file.add(loadItem);
		file.add(saveItem);
		file.add(exitItem);
		
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(search);
		menuBar.add(help);
		
		setSize(WIDTH, HEIGHT);
		setTitle("Topgyal Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// pack();
		// setResizable(false);

		ImageIcon pic = new ImageIcon("download.jpeg");
		// ImageIcon p=new ImageIcon("download.jpeg");


		Container content = getContentPane(); // returns contentpane of applet
		content.setBackground(Color.WHITE);
		// getContentPane();
		// setBackground(Color.WHITE); // THIS WORKS TOO

		Border border1 = BorderFactory.createLineBorder(Color.green, 3);

		// CREATE LABELS
		JLabel l1 = new JLabel("Hello to Topgyal Bank");
		l1.setIcon(pic);
		l1.setHorizontalTextPosition(JLabel.CENTER);
		l1.setVerticalTextPosition(JLabel.TOP);
		l1.setOpaque(true);
		l1.setBorder(border1);
		l1.setHorizontalAlignment(JLabel.CENTER);

		// l1.setIcon(p);

		// add labels
		content.setLayout(new FlowLayout());
		content.add(l1);

		JButton depositButton = new JButton("Deposit");
		content.add(depositButton);
		depositButton.addActionListener(this);

		JButton withdrawButton = new JButton("Withdraw");
		content.add(withdrawButton);
		withdrawButton.addActionListener(this);

		JButton balanceButton = new JButton("Total Balance");
		content.add(balanceButton);
		balanceButton.addActionListener(this);

		JButton suggestButton = new JButton("Submit Suggestions");
		suggestButton.addActionListener(this);
		content.add(suggestButton);

		theText = new JTextArea(5, 25); // 5 lines and 25 char per line.
		theText.setText("");
		content.add(theText);

	}

	// actionPerformed method
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO: Create DATABASE connection and fetch records
		if(e.getSource()==loadItem) {
			System.out.println("You loaded a file");
		}
		if(e.getSource()==saveItem) {
			System.out.println("You saved a file");
		}
		if(e.getSource()==loadItem) {
			System.exit(0);
		}
		
		Container content = getContentPane();

		if (e.getActionCommand().equals("Deposit")) {
			content.setBackground(Color.GRAY);

			double answer = JOptionPane.showConfirmDialog(null, "Are you here to deposit?", "Click it:",
					JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				String newBank = JOptionPane.showInputDialog("Enter the amount: $");
				double putMoney = Double.parseDouble(newBank);
				// if (putMoney>excess)
				// throw new Exception("Exception: Too much money!");
				balance += putMoney;
				JOptionPane.showMessageDialog(null, "Total Balance= $" + balance);
			}
		} else if (e.getActionCommand().equals("Withdraw")) {
			content.setBackground(Color.GRAY);

			double ans = JOptionPane.showConfirmDialog(null, "Are you here to withdraw?", "Click it:",
					JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION) {
				String out = JOptionPane.showInputDialog("Enter the amount: $");
				double takeOut = Double.parseDouble(out);
				balance -= takeOut;

				JOptionPane.showMessageDialog(null, "Withdrawn amount is: " + takeOut);
				JOptionPane.showMessageDialog(null, "Total remaining amount is: $" + balance);
			}
		} else if (e.getActionCommand().equals("Balance")) {
			content.setBackground(Color.GRAY);
			JOptionPane.showMessageDialog(null, "Balance amount is: $ " + balance);

		} else {
			suggest = theText.getText();

			theText.setText("Thank you for your time.");
		}

	}

	public static void main(String[] args) throws Exception {

		Display i = new Display();
		i.setVisible(true);

		//jdbc connection test example

		String url="jdbc:mysql://localhost:3306/bank";  //bank is db name
		String user="root";
		String password=""; //add password 
		String query="SELECT name FROM customer WHERE id=1";

		Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver is deprecated. use com.mysql.cj.jdbc.Driver
		Connection con=DriverManager.getConnection(url, user, password);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		//will take pointer to next record
		rs.next();  //if not included error: before start of result set java sqlexception

		String name=rs.getString("name");
		System.out.println(name);

		st.close();
		con.close();
	}

}
