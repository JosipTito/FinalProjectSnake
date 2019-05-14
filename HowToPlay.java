import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
public class HowToPlay implements ActionListener
{
	private JFrame f;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	
	private JTextArea desc;
	
	private JButton back;
	
	private String description;
	private String appleStr;
	private String powerStr;
	private String descriptionMulti;
	
	public HowToPlay()
	{
		f = new JFrame("Main Menu");
		f.setSize(700, 700);
		f.setLayout(new BorderLayout());
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setPanels();
		setLabels();
		setButton();
		f.add(p1,BorderLayout.NORTH);
		f.add(p2,BorderLayout.WEST);
		f.add(p3,BorderLayout.EAST);
		f.add(p4,BorderLayout.CENTER);
		f.add(p5,BorderLayout.SOUTH);
		f.setVisible(true);
	}
	private void setPanels()
	{
		p1 = new JPanel();
		p1.setBackground(Color.BLACK);
		p2 = new JPanel();
		p2.setBackground(Color.BLACK);
		p3 = new JPanel();
		p3.setBackground(Color.BLACK);
		p4 = new JPanel();
		p4.setBackground(Color.BLACK);
		p5 = new JPanel(new GridLayout(1,1,0,0));
		p5.setBackground(Color.BLACK);
		p5.setPreferredSize(new Dimension(200,200));
	}
	private void setLabels()
	{
		description = "You are this snake, and "
				+ "you are trying to get these red things which are apples."
				+ "\nYou do not want to run into yourself or into the borders "
				+ "\nor it is game over, and we all know you don't want "
				+ "\nyour fantastic game of snake to end."
				+ "Apples are what you want to get. Apples are your points, and"
				+ "\nevery time you eat one, you gain two blocks to your snake."
				+ "\nA power-up is the yellow ball. You should eat these as they shrink "
				+ "\nyou, grow you, speed you up, or slow you down."
				+ "\nThese are not apples, and can help or hurt you."
				+ "\n\nIn Multi-Player, you have a green snake and a blue snake."
				+ "\nThe green snake is controlled by the arrow keys on your keyboard, and"
				+ "\nthe blue snake is controlled by WASD keys. It is basically a fight to"
				+ "\n the death and the surviving snake wins. You can either have an extremely fast game"
				+ "\n or the game can be long by collecting lots of apples and power-ups.";
		
		desc = new JTextArea(description);
		desc.setEditable(false);
		desc.setFont(new Font("San Serif",Font.PLAIN,15));
		desc.setForeground(Color.WHITE);
		desc.setBackground(Color.BLACK);
		
		p4.add(desc);
	}
	private void setButton()
	{
		back = new JButton("Back");
		back.addActionListener(this);
		back.setLayout(null);
		back.setFont(new Font("Serif",Font.PLAIN,70));
		p5.add(back);
	}
	public void actionPerformed(ActionEvent ae)
	{
		f.dispose();
		new MainMenu();
	}
}
