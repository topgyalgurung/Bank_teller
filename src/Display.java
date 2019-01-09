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
import java.awt.*;   //awt layouts
import java.awt.event.*;  //awt event classes and listener interfaces
import javax.swing.*;    //swing components and containers

public class Display extends JFrame implements ActionListener{
	  public static final int WIDTH= 400;     //size of JFrame
	  public static final int HEIGHT= 500;
	  
	  // make it private and use getter and setter method
	  private double balance;
	  private double withdraw;
	  private double deposit;
	  
	  public double excess=10000.0;
	  
	  public Display(double b,double w,double d){
		  balance=b;
		  withdraw=w;
		  deposit=d;
	  }
	  
	  private String suggest=null;
	  
	  private JTextArea theText;  // user can ask que in textarea.
	  
public Display(){
		   balance=1000.0;   
		   withdraw=0.0;
		   deposit=0.0;
		setSize(WIDTH,HEIGHT);
		WindowDestroyer listener=new WindowDestroyer();
		addWindowListener(listener);
		
		Container content=getContentPane();  //returns contentpane of applet
		content.setBackground(Color.YELLOW);
		
		//CREATE LABELS
		JLabel l1=new JLabel("Hello to Queens Bank");
		ImageIcon pic=new ImageIcon("200_s.gif");
		l1.setIcon(pic);
		
		// add labels
		content.setLayout(new FlowLayout());
		content.add(l1);
		
		JButton depositButton=new JButton("Deposit");
		content.add(depositButton);
		depositButton.addActionListener(this);
		
		JButton withdrawButton=new JButton("Withdraw");
		content.add(withdrawButton);
		withdrawButton.addActionListener(this);
		
		
		JButton balanceButton=new JButton("Balance");
		content.add(balanceButton);
		balanceButton.addActionListener(this);
		
		JButton suggestButton=new JButton("Submit Suggestions");
		suggestButton.addActionListener(this);
		content.add(suggestButton);
				
		
		theText=new JTextArea(5,25);   //5 lines and 25 char per line.
		theText.setText("");
		content.add(theText);
		
	} 
	//actionPerformed method
public void actionPerformed(ActionEvent e){
		Container content=getContentPane();
		
		if(e.getActionCommand().equals("Deposit")){
			content.setBackground(Color.GRAY);

			double answer=JOptionPane.showConfirmDialog(null,"Are you here to deposit?","Click it:",JOptionPane.YES_NO_OPTION);
			if(answer==JOptionPane.YES_OPTION){
				String newBank=JOptionPane.showInputDialog("Enter the amount: $");
			double putMoney=Double.parseDouble(newBank);
			//if (putMoney>excess)
				//throw new Exception("Exception: Too much money!");
			balance+=putMoney;
			JOptionPane.showMessageDialog(null,"Total Balance= $"+ balance );
				}
		}
		else if(e.getActionCommand().equals("Withdraw")){
			content.setBackground(Color.BLACK);
			
			double ans=JOptionPane.showConfirmDialog(null,"Are you here to withdraw?","Click it:",JOptionPane.YES_NO_OPTION);
			if(ans==JOptionPane.YES_OPTION){
				String out= JOptionPane.showInputDialog("Enter the amount: $");
				double takeOut=Double.parseDouble(out);
			    balance-=takeOut;
			
			    JOptionPane.showMessageDialog(null,"Withdrawn amount is: $"+balance);
			}
		}
		else if(e.getActionCommand().equals("Balance")){
			content.setBackground(Color.GREEN);
			JOptionPane.showMessageDialog(null,"Balance amount is: $ "+balance );
			
		}
		else{
			suggest=theText.getText();
            
			theText.setText("Thank you for your time.");
		}
		
	
	}
public static void main(String[] args) {
		Display i=new Display();
		i.setVisible(true);
	}
  }
  
		



	

