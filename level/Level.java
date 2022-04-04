package level;

import myGameGraphics.Screen;
import tile.Tile;

public class Level {
	protected int[] tiles; // contain the color values of each level
	protected int width, height;
	protected int[] tilesMaping; // contain indexing of all tiles on the map

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesMaping = new int[width * height];
		generateLevel();
	} // hold list of all the tiles we need to render and managing them

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) { // using this method to pin the corners indexes(moving the screen also updating them, point 0,0 isnt always top-left corner
		screen.setOffset(xScroll, yScroll); // actual location of the player, the screen moves relative to him
		int x0 = xScroll >> 3; // left side of the screen. dividing by 16(via bits action - shift right) this because needed render per tile so pixel precision is not needed
		int x1 = (xScroll + screen.width + 8) >> 3; // right side of the screen. adding 8 - adding one more tile to render on the bottom and right(get rid of black bars)
		int y0 = yScroll >> 3; // top of the screen
		int y1 = (yScroll + screen.height + 8) >> 3; // bottom of the screen

		// all those together defining the render region
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen); // rendering each tile selected by the random get tile > random level 

			}
		}

	}

	// Grass = 0x267F00
	// Flower = 0x0094FF
	// Rock = 0x808080

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		if (tiles[x + y * width] == 0xff267f00)
			return Tile.grass;
		if (tiles[x + y * width] == 0xff0094ff)
			return Tile.flower;
		if (tiles[x + y * width] == 0xff808080)
			return Tile.rock;
		return Tile.voidTile;
	}

}
