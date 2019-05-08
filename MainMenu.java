import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
public class MainMenu implements ActionListener {
	private JFrame f;
	private JButton singlePlay;
	private JPanel panel;
	public MainMenu()
	{
		f = new JFrame("Snake");
		f.setSize(500, 500);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		panel.setSize(200,300);
		panel.setAlignmentX(200);
		panel.setAlignmentY(200);
		panel.setBackground(Color.BLACK);
		singlePlay = new JButton("Single-Player");
		singlePlay.setSize(200,100);
		singlePlay.addActionListener(this);
		
		panel.add(singlePlay,BorderLayout.CENTER);
		f.add(panel,BorderLayout.CENTER);
		
		
		
		f.setVisible(true);
	}
  public void actionPerformed(ActionEvent ae) {
    String comStr = ae.getActionCommand();
   if(comStr.equals("Single-Player"))
   {
	   new FrameSinglePlay();
   }
   else if(comStr.equals("Multi-Player"))
   {
	   //new FrameMultiPlay();
   }
   
  }
  public static void main(String args[]) 
  {
    new MainMenu();
  }
}
