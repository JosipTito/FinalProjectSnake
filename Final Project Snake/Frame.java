import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Frame 
{
	static GraphicsConfiguration gc;
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Snake Revamp", gc);
		frame.setSize(1500, 1000);
		frame.setVisible(true);
	}
}
