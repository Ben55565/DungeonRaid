package myGameGraphics;

public class Sprite {

	public final int SIZE; // size of each individual sprite(if i have monsters for example and i want them to take specific size different from tiles)
	private int x, y; // coordinate of the sprite
	public int[] pixels;
	private Spritesheet sheet;

	public static Sprite grass = new Sprite(8, 0, 0, Spritesheet.tiles); // create a sprite itself, grass texture
	public static Sprite voidSprit = new Sprite(8, 0x65b4e6); // create a sprite itself, grass texture
	
	public static Sprite player0 = new Sprite(8, 0, 18, Spritesheet.tiles); // 19 is the y position in the sprite, multiplying by 8 cause the size of each one is 8
	public static Sprite player1 = new Sprite(8, 1, 18, Spritesheet.tiles);
	public static Sprite player2 = new Sprite(8, 2, 18, Spritesheet.tiles);
	public static Sprite player3 = new Sprite(8, 0, 19, Spritesheet.tiles);
	public static Sprite player4 = new Sprite(8, 1, 19, Spritesheet.tiles);
	public static Sprite player5 = new Sprite(8, 2, 19, Spritesheet.tiles);
	public static Sprite player6 = new Sprite(8, 0, 20, Spritesheet.tiles);
	public static Sprite player7 = new Sprite(8, 1, 20, Spritesheet.tiles);
	public static Sprite player8 = new Sprite(8, 2, 20, Spritesheet.tiles); // the player on my sprite takes 9 tiles, so i had to do that to get all the pieces

	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SIZE = size;
		this.x = x * SIZE; // because i want it to be located in a specific place in the sheet= each tile is multiplied by his size so when i change by 1, the tile is changed and not the pixel
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE]; // size of the sprite
		load();
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);

	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) { // creating sort of scan for the sprite from the entire sheet tiles
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE]; // extracting the relevant pixels for this specific sprite from the sprite sheet
			}
		}
	}

}
