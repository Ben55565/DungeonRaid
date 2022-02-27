package myGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import myGameGraphics.Screen;

public class DisplayWindow extends Canvas implements Runnable {
	// static variables
	private static final long serialVersionUID = 1L; // just to remove a warning in the class name
	public static int width = 300;
	public static int height = (width / 16) * 9; // giving aspect ration of 16:9
	public static int scale = 3; // scaling the window size, while the render stay the same
	// object variables
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); // each image will be sized by original width and height and later will be scaled
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // get pixels from the image and register them into an array to modify(access the image itself)

	private Thread displayThread;
	private boolean isRunning = false;
	private Screen screen = new Screen(width, height); // screen for dealing with the pixels
	private JFrame window; // creating the window for the game

	public JFrame getWindow() {
		return window;
	}

	public DisplayWindow() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		window = new JFrame();

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
		while (isRunning) {
			update(); // method for updating the frame each time, aiming for 60 fps
			render(); // method for generating the frames in speed limited by user hardware
		}
	}

	public void update() {

	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3); // buffer with triple buffering(= having faster render, storing 2 images in ram)
			return;
		}
		screen.clear(); // clearing the previous pixels
		screen.render(); // from screen class, calling the graphic render for each pixel
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics graphics = bs.getDrawGraphics();
		graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose(); // empty resources of the irrelevant graphics
		bs.show();

	}

}
