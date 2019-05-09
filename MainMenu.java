import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
public class MainMenu implements ActionListener {
	private JFrame f;
	private JButton singlePlay;
	private JButton multiPlay;
	private JButton exit;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel title;
	public MainMenu()
	{
		f = new JFrame("Main Menu");
		f.setSize(800, 800);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 = new JPanel();
		panel1.setSize(800,300);
		panel1.setBackground(Color.BLACK);
		panel1.setLayout(new GridLayout(0,3,25,25));
		singlePlay = new JButton("Single-Player");
		singlePlay.addActionListener(this);
		singlePlay.setLayout(null);
		
		multiPlay = new JButton("Multi-Player");
		multiPlay.addActionListener(this);
		multiPlay.setLayout(null);
		
		exit = new JButton("Close");
		exit.addActionListener(this);
		exit.setLayout(null);
		
		panel1.add(singlePlay);
		panel1.add(multiPlay);
		panel1.add(exit);
		f.add(panel1);
		
		panel2 = new JPanel();
		panel2.setSize(800,400);
		panel2.setLayout(new GridLayout(1,1,0,0));
		panel2.setBackground(Color.DARK_GRAY);
		title = new JLabel("Snake With a Twist");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Magneto",Font.PLAIN,50));
		panel2.add(title,BorderLayout.CENTER);
		
		
		
		
		f.add(panel1);
		f.add(panel2);
		f.setVisible(true);
	}
  public void actionPerformed(ActionEvent ae) {
    String comStr = ae.getActionCommand();
   if(comStr.equals("Single-Player"))
   {
	   f.dispose();
	   new FrameSinglePlay();
   }
   else if(comStr.equals("Multi-Player"))
   {
	   f.dispose();
	   new FrameMultiPlayer();
   }
   else if(comStr.equals("Close"))
   {
	   f.dispose();
   }
   
   
  }
  public static void main(String args[]) 
  {
    new MainMenu();
  }
}
