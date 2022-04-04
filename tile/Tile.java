package tile;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass); // creating grass tile
	public static Tile flower = new FlowerTile(Sprite.flower); // creating grass tile
	public static Tile rock = new RockTile(Sprite.rock); // creating grass tile
	public static Tile voidTile = new VoidTile(Sprite.voidSprit); // just a tile representing black box

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) { // for polymorphism reasons

	}

	public boolean solid() { // checking if the player can go though this block or not
		return false;
	}

}
