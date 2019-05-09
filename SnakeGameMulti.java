import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGameMultiPlay extends JPanel implements Runnable, KeyListener
{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 500, HEIGHT = 500;

	private Thread thread;
	private boolean running = false;

	private Body b;
	private ArrayList<Body> snakeBody;
	private Body2 b2;
	private ArrayList<Body2> snakeBody2;

	private Apple apple;
	private ArrayList<Apple> apples;

	private PowerUp poUp;
	private ArrayList<PowerUp> powerUp;

	private Random r;

	private int xCoord, yCoord, xCoord2, yCoord2;
	private int size = 5, size2 = 5;

	private boolean right = true, left = false, up = false, down = false;
	private boolean right2 = true, left2 = false, up2 = false, down2 = false;
	private boolean snake1Wins = false, snake2Wins = false;

	private double increment = 1;
	private double ticks = 0;

	public SnakeGameMultiPlay()
	{
		setFocusable(true);

		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		r = new Random();
		xCoord = r.nextInt(39);
		yCoord = r.nextInt(39);


		snakeBody = new ArrayList<Body>();
		snakeBody2 = new ArrayList<Body2>();
		apples = new ArrayList<Apple>();
		powerUp = new ArrayList<PowerUp>();
		start();
	}

	public void tick()
	{
		if (snakeBody.size() == 0)
		{
			b = new Body(50, 45, 10);
			snakeBody.add(b);
		}
		if(snakeBody2.size() == 0)
		{
			b2 = new Body2(50, 450, 10);
			snakeBody2.add(b2);
		}
		if (apples.size() == 0)
		{
			int xCoor = r.nextInt(48);
			int yCoor = r.nextInt(48);

			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}
		if (powerUp.size() == 0)
		{
			int xCoor = r.nextInt(48);
			int yCoor = r.nextInt(48);

			poUp = new PowerUp(xCoor, yCoor, 10);
			powerUp.add(poUp);
		}

			if (xCoord == apples.get(0).getXCoord() && yCoord == apples.get(0).getYCoord())
			{
				size+=2;
				apples.remove(0);
			}
		
			if (xCoord2 == apples.get(0).getXCoord() && yCoord2 == apples.get(0).getYCoord())
			{
				size2+=2;
				apples.remove(0);
			}

		for (int i = 0; i < powerUp.size(); i++)
		{
			// 0...1000 Inclusive
			int rand = r.nextInt(4);
			if (xCoord == powerUp.get(i).getXCoord() && yCoord == powerUp.get(i).getYCoord())
			{
				if (rand == 0 && size > 4) //Good powerUp, decreases your length by 4.
				{
					snakeBody.remove(3);
					snakeBody.remove(2);
					snakeBody.remove(1);
					snakeBody.remove(0);
					size -= 4;
					powerUp.remove(0);
					i++;
				}
				else if(rand == 1) // Bad powerUp, increases your length by 4.
				{
					size += 4;
					powerUp.remove(0);
					i++;
				}
			    /*else if(rand == 2) // Bad powerUp, increases speed by 20%
				{
					increment += .2;
					powerUp.remove(0);
					i++;
					
				}
				else if(rand == 3 && increment > .5) //Good powerUp, decreases speed by 20%
				{
					increment -= .2;
					powerUp.remove(0);
					i++;
				}*/
				
			}
		}
		
		for (int i = 0; i < powerUp.size(); i++)
		{
			// 0...1000 Inclusive
			int rand = r.nextInt(4);
			if (xCoord2 == powerUp.get(i).getXCoord() && yCoord2 == powerUp.get(i).getYCoord())
			{
				if (rand == 0 && size2 > 4) //Good powerUp, decreases your length by 4.
				{
					snakeBody2.remove(3);
					snakeBody2.remove(2);
					snakeBody2.remove(1);
					snakeBody2.remove(0);
					size2 -= 4;
					powerUp.remove(0);
					i++;
				}
				else if(rand == 1) // Bad powerUp, increases your length by 4.
				{
					size2 += 4;
					powerUp.remove(0);
					i++;
				}
			    /*else if(rand == 2) // Bad powerUp, increases speed by 20%
				{
					increment += .2;
					powerUp.remove(0);
					i++;
					
				}
				else if(rand == 3 && increment > .5) //Good powerUp, decreases speed by 20%
				{
					increment -= .2;
					powerUp.remove(0);
					i++;
				}
				*/
			}
		}

		for (int i = 0; i < snakeBody.size(); i++)
		{
			if (xCoord == snakeBody.get(i).getXCoord() && yCoord == snakeBody.get(i).getYCoord())
			{
				if (i != snakeBody.size() - 1)
				{
					snake2Wins = true;
					stop();
				}
			}
		}
		
		for(int i = 0; i < snakeBody.size(); i++)
		{
			if (xCoord2 == snakeBody.get(i).getXCoord() && yCoord2 == snakeBody.get(i).getYCoord())
			{
				if (i != snakeBody.size() - 1)
				{
					snake1Wins = true;
					stop();
				}
			}
		}
		
		for (int i = 0; i < snakeBody.size(); i++)
		{
			if (xCoord2 == snakeBody2.get(i).getXCoord() && yCoord2 == snakeBody2.get(i).getYCoord())
			{
				if (i != snakeBody2.size() - 1)
				{
					snake1Wins = true;
					stop();
				}
			}
		}
		
		for(int i = 0; i < snakeBody.size(); i++)
		{
			if (xCoord == snakeBody2.get(i).getXCoord() && yCoord == snakeBody2.get(i).getYCoord())
			{
				if (i != snakeBody2.size() - 1)
				{
					snake2Wins = true;
					stop();
				}
			}
		}
		
		if (xCoord < 0 || xCoord > 48 || yCoord < 0 || yCoord > 48)
		{
			snake2Wins = true;
			stop();
		}
		
		if (xCoord2 < 0 || xCoord2 > 48 || yCoord2 < 0 || yCoord2 > 48)
		{
			snake1Wins = true;
			stop();
		}

		ticks+= increment;

		if (ticks > 790999)
		{
		//First Snake (snakeBody)
			if (right)
				xCoord++;
			if (left)
				xCoord--;
			if (up)
				yCoord--;
			if (down)
				yCoord++;
			
		//Second Snake (snakeBody2)
			if(right2)
				xCoord2++;
			if(left2)
				xCoord2--;
			if(up2)
				yCoord2--;
			if(down2)
				yCoord2++;

			ticks = 0;
			
			//First Snake
			b = new Body(xCoord, yCoord, 10);
			snakeBody.add(b);
			//Second Snake
			b2 = new Body2(xCoord2, yCoord2, 10);
			snakeBody2.add(b2);

			if (snakeBody.size() > size)
			{
				snakeBody.remove(0);
			}
			if(snakeBody2.size() > size2) 
			{
				snakeBody2.remove(0);
			}
		}
	}

	public void paint(Graphics g)
	{
		g.clearRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (int i = 0; i < WIDTH / 10; i++)
		{
			g.drawLine(i * 10, 0, i * 10, HEIGHT);
		}
		for (int i = 0; i < HEIGHT / 10; i++)
		{
			g.drawLine(0, i * 10, WIDTH, i * 10);
		}

		for (int i = 0; i < snakeBody.size(); i++)
		{
			snakeBody.get(i).draw(g);
		}
		for(int i = 0; i < snakeBody2.size(); i++)
		{
			snakeBody2.get(i).draw(g);
		}
		for (int i = 0; i < apples.size(); i++)
		{
			apples.get(i).drawApple(g);
			
		}
		for (int i = 0; i < powerUp.size(); i++)
		{
			powerUp.get(i).drawPowerUps(g);
		}

	}

	public void start()
	{
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void stop()
	{
		running = false;

		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public boolean getRunning()
	{
		return running;
	}

	public void run()
	{
		while (running)
		{
			tick();
			repaint();
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		//First Snake (snakeBody)
		if ((key == KeyEvent.VK_RIGHT && !left))
		{
			up = false;
			down = false;
			right = true;
		}
		if (key == KeyEvent.VK_LEFT && !right)
		{
			up = false;
			down = false;
			left = true;
		}
		if (key == KeyEvent.VK_UP && !down)
		{
			left = false;
			right = false;
			up = true;
		}
		if (key == KeyEvent.VK_DOWN && !up)
		{
			left = false;
			right = false;
			down = true;
		}
		
		//Second Snake (snakeBody2)
		if(key == KeyEvent.VK_A && !right2)
		{
			up2 = false;
			down2 = false;
			left2 = true;
		}
		if(key == KeyEvent.VK_D && !left2)
		{
			up2 = false;
			down2 = false;
			right2 = true;
		}
		if(key == KeyEvent.VK_W && !down2)
		{
			left2 = false;
			right2 = false;
			up2 = true;
		}
		if(key == KeyEvent.VK_S && !up2)
		{
			left2 = false;
			right2 = false;
			down2 = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{

	}

	public void keyTyped(KeyEvent arg0)
	{

	}
}
