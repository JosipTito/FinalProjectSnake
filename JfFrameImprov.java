import  javax.swing.JFrame;
import javax.swing.JPanel;
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
		frame.setSize(800, 800);
		top = new JPanel();
		bottom = new JPanel();
		left = new JPanel();
		right = new JPanel();
		frame.add(side1);
		frame.add(side2);
		frame.add(side3);
		frame.add(side4);
		
	}
	public void makeBorder(){
		top.setBackground(Color.BLACK);
		bottom.setBackground(Color.BLACK);
		left.setBackground(Color.BLACK);
		right.setBackground(Color.BLACK);
		top.setSize(800,150);
		bottom.setSize(800,150);
		left.setSize(150,800);
		right.setSize(150,800);
		
	}
	public void display()
	{
		frame.setVisible(true);
	}
	public static void main(String[]args){
		/*JFrame j = new JFrame("Snake");
		j.setDefaultCloseOperation(EXIT_ON_CLOSE);
		j.setSize(800, 700);
		j.setVisible(true);
		JPanel p1 = new JPanel();
		p1.setSize(800, 150);
		p1.setBackground(new Color(100,100,255));
		j.add(p1);
		JButton b1 = new JButton("Easy");
		b1.setSize(400,700);
		b1.setBackground(Color.LIGHT_GRAY);*/
		JfFrameImprov t = new JfFrameImprov("Snake");
		
	}
	
}
