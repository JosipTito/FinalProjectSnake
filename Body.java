import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;

public class Body
{
	private int xCoord, yCoord, width, height;
	
	public Body(int xC, int yC, int size)
	{
		xCoord = xC;
		yCoord = yC;
		width = size;
		height = size;
	}
	
	public void draw(Graphics g) 
	{
		g.setColor(Color.GREEN);
		g.fillRect(xCoord * width, yCoord * height, width, height);
		g.setColor(Color.GREEN);
		g.fillRect(xCoord * width + 1, yCoord * height + 1, width - 2, height - 2);
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
