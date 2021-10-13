package test;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ImageIcon image =new ImageIcon("download.jpeg");
		
		JLabel label=new JLabel();
		label.setText("Welcome to Topgyal Bank");
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		//label.setForeground());
		
		
		
		
		JFrame frame=new JFrame();
		frame.setSize(420,420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(label);


	}

}
