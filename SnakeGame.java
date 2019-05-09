import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JPanel implements Runnable, KeyListener
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

	private double increment = 1;
	private double ticks = 0;

	public SnakeGame()
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
			    else if(rand == 2) // Bad powerUp, increases speed by 20%
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
				
			}
		}

		for (int i = 0; i < snakeBody.size(); i++)
		{
			if (xCoord == snakeBody.get(i).getXCoord() && yCoord == snakeBody.get(i).getYCoord())
			{
				if (i != snakeBody.size() - 1)
				{
					stop();
				}
			}
		}
		if (xCoord < 0 || xCoord > 48 || yCoord < 0 || yCoord > 48)
		{
			stop();
		}

		ticks+= increment;

		if (ticks > 790999)
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
		f.dispose();
		new MainMenu();
		running = false;
		
		
		
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
			// running = false;
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
