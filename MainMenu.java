import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainMenu extends GridLayout {
	private JFrame f;
	private JPanel p;
	private JLabel l;
	private JButton singlePlayer;
	private JButton multiPlayer;
	private JButton exit;
	public MainMenu()
	{
		f = new JFrame("Main Menu");
		setFrame();
        p = new JPanel();
        setPanel();
        
        singlePlayer = new JButton("Single-Player");
        multiPlayer = new JButton("Mutli-Player");
        exit = new JButton("Exit");
        setButtons();
        
        
        
        f.setVisible(true);
	}
	private void setPanel()
	{
		p.setBackground(Color.DARK_GRAY);
		p.setSize(500,500);
		p.setVisible(true);
		f.add(p);
	}
	private void setButtons()
	{
		singlePlayer.setSize(200,100);
		singlePlayer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				f.add(singlePlayer, new FrameSinglePlay());
			}
		});
		exit.setSize(100,50);
		exit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				f.add(exit, JFrame.EXIT_ON_CLOSE);
			}
		});
		singlePlayer.setVisible(true);
		exit.setVisible(true);
		
	}
	private void setFrame()
	{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setTitle("Snake");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
	}
}
