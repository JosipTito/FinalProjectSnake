import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameOverScreen implements ActionListener
{
    private JFrame f;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
   
    private JButton close;
    private JButton back;
    private JButton tryAgain1;
    private JButton tryAgain2;
    
    private JLabel gameText;
    private JLabel overText;
    private JLabel winnerText;
    private JTextArea stats;
    public GameOverScreen(int appleCount, int size, int i)
    {
        f = new JFrame("Snake - Game Over");
        f.setSize(600,600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());
        
        setPanels();
        setButtons1();
        
        
        gameText = new JLabel("Game");
        gameText.setFont(new Font("San Serif",Font.BOLD,70));
        gameText.setForeground(Color.RED);
        gameText.setHorizontalTextPosition(SwingConstants.CENTER);
        overText = new JLabel("Over");
        overText.setFont(new Font("San Serif",Font.BOLD,70));
        overText.setForeground(Color.GRAY);
        panel4.add(gameText);
        panel4.add(overText);
        setStats(appleCount,size,i);
        f.add(panel1,BorderLayout.NORTH);
        f.add(panel2,BorderLayout.EAST);
        f.add(panel3,BorderLayout.WEST);
        f.add(panel4,BorderLayout.CENTER);
        f.add(panel5,BorderLayout.SOUTH);
        
        f.setVisible(true);
    }
    public GameOverScreen(String winner)
    {
        f = new JFrame("Snake - Game Over");
        f.setSize(600,600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());
        
        setPanels();
        setButtons2();
        gameText = new JLabel("Game");
        gameText.setFont(new Font("San Serif",Font.BOLD,70));
        gameText.setForeground(Color.RED);
        
        overText = new JLabel("Over");
        overText.setFont(new Font("San Serif",Font.BOLD,70));
        overText.setForeground(Color.GRAY);
        panel4.add(gameText);
        panel4.add(overText);
        determineWinnerText(winner);
        f.add(panel1,BorderLayout.NORTH);
        f.add(panel2,BorderLayout.EAST);
        f.add(panel3,BorderLayout.WEST);
        f.add(panel4,BorderLayout.CENTER);
        f.add(panel5,BorderLayout.SOUTH);
        
        f.setVisible(true);
    }
    private void setPanels()
    {
        panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);
        panel4 = new JPanel();
        panel4.setBackground(Color.BLACK);
        panel4.setLayout(new GridLayout(4,0,0,0));
        panel5 = new JPanel();
        panel5.setBackground(Color.BLACK);
        panel5.setLayout(new GridLayout(0,3,0,0));
        panel5.setPreferredSize(new Dimension(600,100));
    }
    private void setButtons1()
    {
        close = new JButton("Close");
        close.addActionListener(this);
        close.setFont(new Font("Serif",Font.PLAIN,25));
        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Serif",Font.PLAIN,25));
        panel5.add(back);
        tryAgain1 = new JButton("Play Again!");
        tryAgain1.addActionListener(this);
        tryAgain1.setFont(new Font("Serif",Font.PLAIN,25));
        panel5.add(tryAgain1);
        panel5.add(close);
    }
    private void setButtons2()
    {
        close = new JButton("Close");
        close.addActionListener(this);
        close.setFont(new Font("Serif",Font.PLAIN,25));
        back = new JButton("Back");
        back.addActionListener(this);
        back.setFont(new Font("Serif",Font.PLAIN,25));
        panel5.add(back);
        tryAgain2 = new JButton("Play Again!!");
        tryAgain2.addActionListener(this);
        tryAgain2.setFont(new Font("Serif",Font.PLAIN,25));
        panel5.add(tryAgain2);
        panel5.add(close);
    }
    private void determineWinnerText(String winner)
    {
    	winnerText = new JLabel(winner);
    	if(winner.contains("Green"))
    		winnerText.setForeground(Color.GREEN);
    	else if(winner.contains("Blue"))
    		winnerText.setForeground(Color.CYAN);
    	else
    		winnerText.setForeground(Color.WHITE);
    	winnerText.setFont(new Font("San Serif",Font.BOLD,30));
    	panel4.add(winnerText);
    }
    private void setStats(int ac, int l, int p)
    {
    	
    	stats = new JTextArea("Apples Eaten: "+ac +	
    						  "\nLength    : "+l +
    						  "\nSpeed     : "+p+"%");
    	stats.setFont(new Font("Type Writer",Font.PLAIN,25));
    	stats.setBackground(Color.BLACK);
    	stats.setForeground(Color.GREEN);
    	stats.setEditable(false);
    	panel4.add(stats);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Back"))
        {
            f.dispose();
            new MainMenu();
        }
        else if(ae.getActionCommand().equals("Close"))
            System.exit(0);
        else if(ae.getActionCommand().equals("Play Again!"))
        {
        	f.dispose();
        	new FrameSinglePlay();
        }
        else if(ae.getActionCommand().equals("Play Again!!"))
        {
        	f.dispose();
        	new FrameMultiPlayer();
        }
    }
}
