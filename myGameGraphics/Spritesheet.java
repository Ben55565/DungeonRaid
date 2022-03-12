package myGameGraphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet { // using the image of the sprite

	private String path;
	public final int SIZE;
	public int[] pixels;

	public static Spritesheet tiles = new Spritesheet("/textures/Untitled.png", 256);

	public Spritesheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		loadImage();
	}

	private void loadImage() { // function to load the sprite picture 
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); // this function creating the pixels for the image itself - translate the image to pixels
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
