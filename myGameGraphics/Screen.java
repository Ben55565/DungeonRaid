package myGameGraphics;

import java.util.Random;

public class Screen {
	private final int MAP_SIZE = 64;
	
	private int width, height;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; // making the screen as 64*64 tiles
	private Random rn = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = rn.nextInt(0xffffff); // choose any color from the 16.9 million available randomly(ffffff is white)
		}
	}

	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for(int y = 0; y < height; y++) {
			int yy = y + yOffset; // VAR for changing the tile color based on movement in the map
			//if(yy >= height || yy < 0) break;
			for(int x = 0; x < width; x++) {
				int xx = x + xOffset; // VAR for changing the tile color based on movement in the map
				//if(xx >= width  || xx < 0) break;
				int tileIndex = ((xx >> 4) & MAP_SIZE-1) + ((yy >> 4) & MAP_SIZE-1) * MAP_SIZE; // find the correct tile matching for the specific pixel its on, using size of 16 *note to self - lower it when im more advanced.
				// >> - instead of dividing by 16, which is power of 2, >> is shifting the bits 4 places  right, so the division action achieved but in a faster way - using bits
				// & - creating some kind of loop, if we try to go beyond the 63 tile, it will return to the tile index 0
				pixels[x + (y * width)] = tiles[tileIndex]; // making the current pixel matching the tile we found one line up
				
			}
		}
	}
}
