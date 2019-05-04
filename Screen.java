import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel implements Runnable, KeyListener
{

	private static final long serialVersionUID = 1L;
	
	private JFrame f;

	public static final int WIDTH = 500, HEIGHT = 500;

	private Thread thread;
	private boolean running = false;

	private Body b;
	private ArrayList<Body> snakeBody;

	private Apple apple;
	private ArrayList<Apple> apples;
	
	private PowerUp poUp;
	private ArrayList<PowerUp> powerUp;

	private Random r;

	private int xCoord, yCoord;
	private int size = 5;

	private boolean right = true, left = false, up = false, down = false;

	private int ticks = 0;

	public Screen()
	{
		 f = new JFrame();
		setFocusable(true);

		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		r = new Random();
		xCoord = r.nextInt(39);
		yCoord = r.nextInt(39);
		
		snakeBody = new ArrayList<Body>();
		apples = new ArrayList<Apple>();
		powerUp = new ArrayList<PowerUp>();
		start();
	}

	public void tick()
	{
		if (snakeBody.size() == 0)
		{
			b = new Body(xCoord, yCoord, 10);
			snakeBody.add(b);
		}
		if (apples.size() == 0)
		{
			int xCoor = r.nextInt(39);
			int yCoor = r.nextInt(39);

			apple = new Apple(xCoor, yCoor, 10);
			apples.add(apple);
		}
		if(powerUp.size() == 0)
		{
			int xCoor = r.nextInt(39);
			int yCoor = r.nextInt(39);
			
			poUp = new PowerUp(xCoor, yCoor, 10);
			powerUp.add(poUp);
		}
		
		
		for (int i = 0; i < apples.size(); i++)
		{
			if (xCoord == apples.get(i).getXCoord() && yCoord == apples.get(i).getYCoord())
			{
				size++;
				apples.remove(i);
				i++;
			}
		}
		
		for (int i = 0; i < powerUp.size(); i++)
		{
			if (xCoord == powerUp.get(i).getXCoord() && yCoord == powerUp.get(i).getYCoord())
			{
				// 0...1000 Inclusive
				int rand = r.nextInt(1001);
				
				if(rand % 2 == 0) //Good PowerUp
				{
					snakeBody.remove(0);
					size--;
				}
				else if(rand == 526) //Very Bad PowerUp
				{
					
				}
				else //Bad PowerUp
				{
					
				}
				
				powerUp.remove(i);
				i++;
			}
		}
		
		for (int i = 0; i < snakeBody.size(); i++)
		{
			if (xCoord == snakeBody.get(i).getXCoord() && yCoord == snakeBody.get(i).getYCoord())
			{
				if (i != snakeBody.size()-1)
				{
					stop();
				}
			}
		}
		if (xCoord < 0 || xCoord > 48 || yCoord < 0 || yCoord > 48)
		{
			stop();
		}

		ticks++;

		
		if (ticks > 1000000)
		{
			if (right)
				xCoord++;
			if (left)
				xCoord--;
			if (up)
				yCoord--;
			if (down)
				yCoord++;

			ticks = 0;

			b = new Body(xCoord, yCoord, 10);
			snakeBody.add(b);

			if (snakeBody.size() > size)
			{
				snakeBody.remove(0);
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
		for (int i = 0; i < apples.size(); i++)
		{
			apples.get(i).drawApple(g);
		}
		for(int i = 0; i < powerUp.size(); i++)
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
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
			//running = false;
		}
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
		if (key == KeyEvent.VK_RIGHT && !left)
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
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		
	}

	public void keyTyped(KeyEvent arg0)
	{
		
	}
}
