import java.awt.color.*;

import java.awt.Color;

import java.awt.Graphics;



public class Apple

{

	private int xCoord, yCoord, width, height;

	

	public Apple(int xC, int yC, int size)

	{

		xCoord = xC;

		yCoord = yC;

		width = size;

		height = size;

	}

	

	public void drawApple(Graphics g)

	{

		g.setColor(Color.RED);

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