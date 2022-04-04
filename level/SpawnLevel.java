package level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SpawnLevel extends Level {


	public SpawnLevel(String path) {
		super(path);

	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path)); // loading a image from path
			int w = width = image.getWidth(); // getting the image dimensions
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w); // converting  the image to array of pixels, and setting each pixel color
		} catch (IOException e) {
			System.out.println("Could not load level file.");

		}
	}


	protected void generateLevel() { // convert the array of pixels from load level to array of tiles, based of the color of each pixel in the array
		

	}

}
