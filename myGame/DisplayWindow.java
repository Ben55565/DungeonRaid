package myGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import myGameGraphics.Screen;
import keyInput.KeyBoard;
import level.Level;
import level.SpawnLevel;
import mob.Player;

public class DisplayWindow extends Canvas implements Runnable {
	// static variables
	private static final long serialVersionUID = 1L; // just to remove a warning in the class name
	public static int width = 500;
	public static int height = (width / 16) * 9; // giving aspect ration of 16:9
	public static int scale = 3; // scaling the window size, while the render stay the same
	public static String title = "Dungeon Raid";
	// object variables
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // each image will be sized by original width and height and later will be scaled
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // get pixels from the image and register them into an array to modify(access the image itself)
	private Level level;
	private Thread displayThread;
	private boolean isRunning = false;
	private Screen screen = new Screen(width, height); // screen for dealing with the pixels
	private JFrame window; // creating the window for the game
	private KeyBoard key;
	private Player player;

	public JFrame getWindow() {
		return window;
	}

	public DisplayWindow() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		setFocusable(true);
		window = new JFrame();
		level = new SpawnLevel("/textures/Levels/level1.png");
		key = new KeyBoard();
		addKeyListener(key);
		player = new Player(32*8,32*8,key);

	}

	public synchronized void start() {
		isRunning = true;
		displayThread = new Thread(this, "Display");
		displayThread.start();
	}

	public synchronized void stop() {
		isRunning = false;
		try {
			displayThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime(); // counting the CPU cycle in nano seconds before the loop
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; // 1 nano second divided by the 60 fps target
		double delta = 0;
		int frames = 0; // fps counter VAR
		int updates = 0;
		while (isRunning) {
			long now = System.nanoTime(); // current loop CPU cycle
			delta += (now - lastTime) / ns; // adding to delta the time difference
			lastTime = now; // updating each loop the last time as the last loop
			while (delta >= 1) { // will happened 60 times a second
				update(); // method for updating the frame each time, aiming for 60 fps
				updates++; //every time an update made for the pixels, Inc the updates VAR
				delta--;
			}
			render(); // method for generating the frames in speed limited by user hardware
			frames++;

			if (System.currentTimeMillis() - timer > 1000) { // as long as the difference between the start and now is greater then 1 second
				timer += 1000;
				window.setTitle(title + "    |    Stats: " + "ups: " + updates + ", fps: " + frames);
				updates = 0;
				frames = 0; // setting them back to zero each 60 renders per second
			}

		}
		stop();
	}

	public void update() {
		key.update();
		player.update();
	

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // buffer with triple buffering(= having faster render, storing 2 images in ram)
			return;
		}
		screen.clear(); // clearing the previous pixels
		//screen.render(x, y); // from screen class, calling the graphic render for each pixel
		int xScroll = player.x - screen.width / 2; // setting the player in the middle of the screen
		int yScroll = player.y - screen.height / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics graphics = bs.getDrawGraphics();
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose(); // empty resources of the irrelevant graphics
		bs.show();

	}

}
