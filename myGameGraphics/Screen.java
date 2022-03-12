package myGameGraphics;



import tile.Tile;

public class Screen {
	private final int MAP_SIZE = 64;
	
	// tiles are full block map. so when the game starts what shown on the screen is one tile.
	// i made each tile more detailed, check ahead that no problem accrue, if so, change back the file directory on Sprite sheet class,
	// in this class change back the pixels array calculations from & 7 to & 15
	
	private int width, height;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; // making the screen as 64*64 tiles


	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
	}

	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int xOffset, int yOffset) {
		for(int y = 0; y < height; y++) {
			int yp = y + yOffset;
			if(yp < 0 || yp >= height)
				continue;
			for(int x = 0; x < width; x++) {
				int xp = x + xOffset;
				if(xp < 0 || xp >= width)
					continue;
				pixels[xp + (yp * width)] = Sprite.grass.pixels[(x & 7) + (y & 7) * Sprite.grass.SIZE]; // making the current pixel matching the tile we found one line up
				
			}
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = yp + y;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = xp + x;
				if(xa < 0 || xa >= width || ya < 0 || ya >= width)
					break;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE]; // set the current offset pixel to be the tile pixel(simulate the moving background)
					
			}
			
		}
		
	}
	
}


/* Saved comments for myself to learn from:
 * 
 *	int tileIndex = ((xx >> 4) & MAP_SIZE-1) + ((yy >> 4) & MAP_SIZE-1) * MAP_SIZE; // find the correct tile matching for the specific pixel its on, using size of 16 *note to self - lower it when im more advanced.
 *	>> - instead of dividing by 16, which is power of 2, >> is shifting the bits 4 places  right, so the division action achieved but in a faster way - using bits
 *	& - creating some kind of loop, if we try to go beyond the 63 tile, it will return to the tile index 0
 * 
 */
 
