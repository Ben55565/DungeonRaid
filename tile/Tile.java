package tile;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;
import spawn_tiles.SpawnFloorTile;
import spawn_tiles.SpawnFlowerTile;
import spawn_tiles.SpawnGrassTile;
import spawn_tiles.SpawnHedgeTile;
import spawn_tiles.SpawnRockTile;
import spawn_tiles.SpawnWallTile;
import spawn_tiles.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass); // creating grass tile
	public static Tile flower = new FlowerTile(Sprite.flower); // creating grass tile
	public static Tile rock = new RockTile(Sprite.rock); // creating grass tile
	public static Tile voidTile = new VoidTile(Sprite.voidSprit); // just a tile representing black box

	// Spawn Tiles:
	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawnHedge);
	public static Tile spawnWall = new SpawnWallTile(Sprite.spawnWall);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawnWall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawnFloor);
	public static Tile spawnWallMoss = new SpawnWallTile(Sprite.spawnWallMoss);
	public static Tile spawnFlower = new SpawnFlowerTile(Sprite.spawnFlower);
	public static Tile spawnRock = new SpawnRockTile(Sprite.spawnRock);
	public static Tile spawnWaste = new SpawnRockTile(Sprite.spawnwaste);

	public final static int grassHex = 0xff00ff00;
	public final static int hedgeHex = 0xff007f0e;
	public final static int waterHex = 0xff0094ff;
	public final static int wallHex = 0xff000000;
	public final static int wall2Hex = 0xff7f3300;
	public final static int floorHex = 0xffffd800;
	public final static int flowerHex = 0xffff0000;
	public final static int rockHex = 0xff404040;
	public final static int mossHex = 0xff4800ff;
	public final static int wasteHex = 0xffff6a00;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) { // for Polymorphism reasons

	}

	public boolean solid() { // checking if the player can go though this block or not
		return false;
	}

}
