import javax.swing.JFrame;
import javax.swing.JPanel;
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
    
    private JLabel gameText;
    private JLabel overText;
    public GameOverScreen()
    {
        f = new JFrame("Snake - Game Over");
        f.setSize(600,600);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());
        
        setPanels();
        setButtons();
        
        gameText = new JLabel("Game");
        gameText.setFont(new Font("Magneto",Font.PLAIN,70));
        gameText.setForeground(Color.RED);
        overText = new JLabel("Over");
        overText.setFont(new Font("Magneto",Font.PLAIN,70));
        overText.setForeground(Color.GRAY);
        panel4.add(gameText);
        panel4.add(overText);
        
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
        panel5.setLayout(new GridLayout(0,2,0,0));
        panel5.setPreferredSize(new Dimension(600,200));
    }
    private void setButtons()
    {
        close = new JButton("Close");
        close.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);
        panel5.add(back);
        panel5.add(close);
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
        
    }
}
