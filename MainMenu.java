import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.AbstractAction;
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
        //Making the JFrame
        f = new JFrame("Main Menu");
        f.setSize(800, 800);
        f.setLayout(new GridLayout(5,0,0,0));
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Making the "Non-empty" JPanels
        panel1 = new JPanel();
        panel1.setSize(800,300);
        panel1.setBackground(Color.BLACK);
        panel1.setLayout(new GridLayout(0,3,0,0));
        
        //Making "Single-Player" JButton.
        singlePlay = new JButton("Single-Player");
        singlePlay.addActionListener(this);
        singlePlay.setLayout(null);
        
        //Making "Multi-Player" JButton.
        multiPlay = new JButton("Multi-Player");
        multiPlay.addActionListener(this);
        multiPlay.setLayout(null);
        //Making "Close" JButton.
        exit = new JButton("Close");
        exit.addActionListener(this);
        exit.setLayout(null);
        
        //Adding buttons to panel1
        panel1.add(singlePlay);
        panel1.add(multiPlay);
        panel1.add(exit);
        f.add(panel1);
        //Making second non-empty panel
        panel2 = new JPanel();
        panel2.setSize(800,400);
        panel2.setLayout(new GridLayout(3,1,0,0));
        panel2.setBackground(Color.BLACK);
        title = new JLabel("Snake With a Twist");
        title.setForeground(Color.WHITE);
        
        title.setFont(new Font("Magneto",Font.PLAIN,70));
        panel2.add(title);

        //Adding  Panels to the JFrame to display
        f.add(panel1);
        
        //Creating and adding Empty panels
        JPanel empty1, empty2,empty3,empty4;
        empty1 = new JPanel();
        empty1.setBackground(Color.BLACK);
        empty2 = new JPanel();
        empty2.setBackground(Color.BLACK);
        empty3 = new JPanel();
        empty3.setBackground(Color.BLACK);
        
        f.add(empty1);
        f.add(panel2);
        f.add(empty2);
        f.add(empty3);
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
	   System.exit(0);
   
   
   
  }
  public static void main(String args[]) 
  {
    new MainMenu();
  }
}
