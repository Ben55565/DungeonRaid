package myGameGraphics;

import java.util.Random;

public class Screen {
	private int width, height;
	public int[] pixels;
	public int[] tiles = new int[64*64 ]; // making the screen as 64*64 tiles
	private Random rn = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < 64*64; i++) {
			tiles[i] = rn.nextInt(0xffffff); // choose any color from the 16.9 million available randomly(ffffff is white)
		}
	}

	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render() {
		for(int y = 0; y < height; y++) {
			if(y >= height || y < 0) break;
			for(int x = 0; x < width; x++) {
				if(x >= width  || x < 0) break;
				int tileIndex = (x >> 4) + (y >> 4) * 64; // find the correct tile matching for the specific pixel its on, using size of 16 *note to self - lower it when im more advanced.
				// >> - instead of dividing by 16, which is power of 2, >> is shifting the bits 4 places  right, so the division action achieved but in a faster way - using bits
				pixels[x + (y * width)] = tiles[tileIndex]; // making the current pixel matching the tile we found one line up
				
			}
		}
	}
}
