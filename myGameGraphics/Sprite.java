package myGameGraphics;

public class Sprite {

	public final int SIZE; // size of each individual sprite(if i have monsters for example and i want them to take specific size different from tiles)
	private int x, y; // coordinate of the sprite
	public int[] pixels;
	private Spritesheet sheet;

	public static Sprite grass = new Sprite(8, 0, 0, Spritesheet.tiles); // create a sprite itself, grass texture
	public static Sprite voidSprit = new Sprite(8, 0x65b4e6); // create a sprite itself, grass texture

	public static Sprite playerDown = new Sprite(24, 0, 6, Spritesheet.tiles); // 24 because each tile is sized 8, the character is 3X3 , so i triple the size(8*3), and slice the tile number by three(the original 9 piece creation is in comments class)
	public static Sprite playerUp = new Sprite(24, 2, 6, Spritesheet.tiles);
	public static Sprite playerLeft = new Sprite(24, 1, 6, Spritesheet.tiles);
	public static Sprite playerRight = new Sprite(24, 3, 6, Spritesheet.tiles);
	
	public static Sprite playerWDown1 = new Sprite(24, 0, 7, Spritesheet.tiles); // the sprites for walking
	public static Sprite playerWUp1 = new Sprite(24, 2, 7, Spritesheet.tiles);
	public static Sprite playerWLeft1 = new Sprite(24, 1, 7, Spritesheet.tiles);
	public static Sprite playerWRight1 = new Sprite(24, 3, 7, Spritesheet.tiles);
	public static Sprite playerWDown2 = new Sprite(24, 0, 9, Spritesheet.tiles); 
	public static Sprite playerWUp2 = new Sprite(24, 2, 9, Spritesheet.tiles);
	public static Sprite playerWLeft2 = new Sprite(24, 1, 9, Spritesheet.tiles);
	public static Sprite playerWRight2 = new Sprite(24, 3, 9, Spritesheet.tiles);
	
	
	
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
