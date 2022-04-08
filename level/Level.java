package level;

import myGameGraphics.Screen;
import tile.Tile;

public class Level {
	protected int[] tiles; // contain the color values of each level
	protected int width, height;
	protected int[] tilesMaping; // contain indexing of all tiles on the map
	public static Level spawn = new SpawnLevel("/textures/Levels/SpawnLevel.png");

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
		int x0 = xScroll >> 4; // left side of the screen. dividing by 16(via bits action - shift right) this because needed render per tile so pixel precision is not needed
		int x1 = (xScroll + screen.width + 16) >> 4; // right side of the screen. adding 8 - adding one more tile to render on the bottom and right(get rid of black bars)
		int y0 = yScroll >> 4; // top of the screen
		int y1 = (yScroll + screen.height + 16) >> 4; // bottom of the screen

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
		if (tiles[x + y * width] == Tile.floorHex)
			return Tile.spawnFloor;
		if (tiles[x + y * width] == Tile.flowerHex)
			return Tile.flower;
		if (tiles[x + y * width] == Tile.rockHex)
			return Tile.rock;
		if (tiles[x + y * width] == Tile.grassHex)
			return Tile.spawnGrass;
		if (tiles[x + y * width] == Tile.hedgeHex)
			return Tile.spawnHedge;
		if (tiles[x + y * width] == Tile.mossHex)
			return Tile.spawnWallMoss;
		if (tiles[x + y * width] == Tile.waterHex)
			return Tile.spawnWater;
		if (tiles[x + y * width] == Tile.wall2Hex)
			return Tile.spawnWall2;
		if (tiles[x + y * width] == Tile.wallHex)
			return Tile.spawnWall;
		if (tiles[x + y * width] == Tile.wasteHex)
			return Tile.spawnWaste;
		return Tile.voidTile;
	}

}
