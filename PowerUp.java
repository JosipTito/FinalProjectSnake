import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class PowerUp
{
	private int xCoord, yCoord, width, height;
	private Random rand;
	private Graphics g;

	public PowerUp(int xC, int yC, int size)
	{
		xCoord = xC;
		yCoord = yC;
		width = size;
		height = size;
		rand = new Random();
		// g = new Graphics();
	}

	public void drawPowerUps(Graphics g)
	{
			g.setColor(Color.YELLOW);
			g.fillOval(xCoord * width, yCoord * height, width, height);	
	}

	public int getXCoord()

	{

		return xCoord;

	}

	public void setXCoord(int xC)

	{

		xCoord = xC;

	}

	public void setYCoord(int yC)

	{

		yCoord = yC;

	}

	public int getYCoord()

	{

		return yCoord;

	}

}