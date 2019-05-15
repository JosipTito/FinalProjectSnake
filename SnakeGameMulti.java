import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGameMulti extends JPanel implements Runnable, KeyListener
{

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 520, HEIGHT = 560;

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

	public SnakeGameMulti()
	{
		setFocusable(true);

		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		r = new Random();
		xCoord = r.nextInt(30) + 3;
		yCoord = r.nextInt(30) + 3;
		
		xCoord2 = r.nextInt(30) + 3;
		yCoord2 = r.nextInt(30) + 3;


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
			int xCoor = r.nextInt(46) + 3;
			int yCoor = r.nextInt(46) + 3;

			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}
		if (powerUp.size() == 0)
		{
			int xCoor = r.nextInt(46) + 3;
			int yCoor = r.nextInt(46) + 3;

			poUp = new PowerUp(xCoor, yCoor, 10);
			powerUp.add(poUp);
		}

		if (xCoord == apples.get(0).getXCoord() && yCoord == apples.get(0).getYCoord())
		{
			size+=2;
			apples.remove(0);
		}
		else if (xCoord2 == apples.get(0).getXCoord() && yCoord2 == apples.get(0).getYCoord())
		{
			size2+=2;
			apples.remove(0);
		}

		for (int i = 0; i < powerUp.size(); i++)
		{
			// 0...1000 Inclusive
			int rand = r.nextInt(2);
			if (xCoord == powerUp.get(i).getXCoord() && yCoord == powerUp.get(i).getYCoord())
			{
				if(rand == 1) // Bad powerUp, increases your length by 4.
				{
					size += 4;
					powerUp.remove(0);
					i++;
				}
				
			}
		}
		
		for (int i = 0; i < powerUp.size(); i++)
		{
			// 0...1000 Inclusive
			int rand = r.nextInt(2);
			if (xCoord2 == powerUp.get(i).getXCoord() && yCoord2 == powerUp.get(i).getYCoord())
			{
				if(rand == 1) // Bad powerUp, increases your length by 4.
				{
					size2 += 4;
					powerUp.remove(0);
					i++;
				}
			}
		}

		//If snake1 hits itself
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
		
		//If snake2 hits snake1
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
		
		//If snake2 hits itself
		for (int i = 0; i < snakeBody2.size(); i++)
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
		
		//If snake1 hits snake2
		for(int i = 0; i < snakeBody2.size(); i++)
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
		
		if (xCoord < 3 || xCoord > 48 || yCoord < 3 || yCoord > 48)
		{
			snake2Wins = true;
			stop();
		}
		
		if (xCoord2 < 3 || xCoord2 > 48 || yCoord2 < 3 || yCoord2 > 48)
		{
			snake1Wins = true;
			stop();
		}

		ticks+= increment;

		if (ticks > 690999)
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
		g.setColor(new Color(73, 94, 150));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.BLACK);
		g.fillRect(20, 20, WIDTH-40, HEIGHT-80);


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
		
		new GameOverScreen(determineWinner());
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	private String determineWinner()
	{
		if(snake1Wins)
			return "Green Snake Wins";
		else
			return "Blue Snake Wins";
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
