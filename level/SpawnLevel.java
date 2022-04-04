package level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import tile.Tile;

public class SpawnLevel extends Level {

	private int[] pixels;

	public SpawnLevel(String path) {
		super(path);

	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path)); // loading a image from path
			int w = image.getWidth(); // getting the image dimensions
			int h = image.getHeight();
			tiles = new Tile[w * h]; // setting the tiles array the size of the image dimensions
			pixels = new int[w * h];
			image.getRGB(0, 0, w, h, pixels, 0, w); // converting  the image to array of pixels, and setting each pixel color
		} catch (IOException e) {
			System.out.println("Could not load level file.");

		}
	}

	// Grass = 0x267F00
	// Flower = 0x0094FF
	// Rock = 0x808080
	protected void generateLevel() { // convert the array of pixels from load level to array of tiles, based of the color of each pixel in the array
		for (int i = 0; i < pixels.length; i++) {
			if (pixels[i] == 0xff267F00)
				tiles[i] = Tile.grass;
			if (pixels[i] == 0xff0094FF)
				tiles[i] = Tile.flower;
			if (pixels[i] == 0xff808080)
				tiles[i] = Tile.rock;
		}

	}

}
