import  javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

public class JfFrameImprov extends JFrame{
	
	private JFrame frame;
	private JPanel top;
	private JPanel bottom;
	private JPanel left;
	private JPanel right;
	public JfFrameImprov(String title){
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		top = new JPanel();
		bottom = new JPanel();
		left = new JPanel();
		right = new JPanel();
		
		
	}
	public void makeBorder(){
		top.setBackground(Color.red);
		bottom.setBackground(Color.red);
		left.setBackground(Color.red);
		right.setBackground(Color.red);
		top.setSize(800,150);
		bottom.setSize(800,150);
		left.setSize(150,800);
		right.setSize(150,800);
		frame.add(top,BorderLayout.NORTH);
		frame.add(bottom,BorderLayout.SOUTH);
		frame.add(left,BorderLayout.WEST);
		frame.add(right,BorderLayout.EAST);
	}
	public void createButton()
	{
		JButton startGame = new JButton("Start");
		startGame.setSize(100,50);
	}
	public void display()
	{
		frame.setVisible(true);
	}
	public static void main(String[]args){
		JfFrameImprov t = new JfFrameImprov("Snake");
		t.makeBorder();
		t.createButton();
		t.display();
	}
	
}
