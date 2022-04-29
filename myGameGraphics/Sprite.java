package myGameGraphics;

public class Sprite {

	public final int SIZE; // size of each individual sprite(if i have monsters for example and i want them to take specific size different from tiles)
	private int x, y; // coordinate of the sprite
	private int width, height;
	public int[] pixels;
	private Spritesheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, Spritesheet.tiles); // create a sprite itself, grass texture
	public static Sprite flower = new Sprite(16, 1, 0, Spritesheet.tiles); // create a sprite itself, grass texture
	public static Sprite rock = new Sprite(16, 2, 0, Spritesheet.tiles); // create a sprite itself, grass texture
	public static Sprite voidSprit = new Sprite(16, 0x65b4e6); // create a sprite itself, grass texture

	// Spawn level sprites:
	public static Sprite spawnGrass = new Sprite(16, 0, 0, Spritesheet.spawn);
	public static Sprite spawnWater = new Sprite(16, 1, 1, Spritesheet.spawn);
	public static Sprite spawnHedge = new Sprite(16, 2, 1, Spritesheet.spawn);
	public static Sprite spawnWall = new Sprite(16, 3, 1, Spritesheet.spawn);
	public static Sprite spawnFloor = new Sprite(16, 0, 2, Spritesheet.spawn);
	public static Sprite spawnWallMoss = new Sprite(16, 0, 1, Spritesheet.spawn);
	public static Sprite spawnFlower = new Sprite(16, 1, 0, Spritesheet.spawn);
	public static Sprite spawnRock = new Sprite(16, 2, 0, Spritesheet.spawn);
	public static Sprite spawnWall2 = new Sprite(16, 3, 0, Spritesheet.spawn);
	public static Sprite spawnwaste = new Sprite(16, 1, 2, Spritesheet.spawn);
	public static Sprite spawnTallGrass = new Sprite(16, 2, 2, Spritesheet.spawn);

	// Player sprites:

	public static Sprite playerDown = new Sprite(32, 0, 5, Spritesheet.tiles); // 24 because each tile is sized 8, the character is 3X3 , so i triple the size(8*3), and slice the tile number by three(the original 9 piece creation is in comments class)
	public static Sprite playerUp = new Sprite(32, 2, 5, Spritesheet.tiles);
	public static Sprite playerLeft = new Sprite(32, 1, 5, Spritesheet.tiles);
	public static Sprite playerRight = new Sprite(32, 3, 5, Spritesheet.tiles);

	public static Sprite playerWDown1 = new Sprite(32, 0, 6, Spritesheet.tiles); // the sprites for walking
	public static Sprite playerWUp1 = new Sprite(32, 2, 6, Spritesheet.tiles);
	public static Sprite playerWLeft1 = new Sprite(32, 1, 6, Spritesheet.tiles);
	public static Sprite playerWRight1 = new Sprite(32, 3, 6, Spritesheet.tiles);
	public static Sprite playerWDown2 = new Sprite(32, 0, 7, Spritesheet.tiles);
	public static Sprite playerWUp2 = new Sprite(32, 2, 7, Spritesheet.tiles);
	public static Sprite playerWLeft2 = new Sprite(32, 1, 7, Spritesheet.tiles);
	public static Sprite playerWRight2 = new Sprite(32, 3, 7, Spritesheet.tiles);
	
	// projectile sprites:
	
	public static Sprite projectileCharacter = new Sprite(16,0,0,Spritesheet.projectileCharacter); 
	
	// Particles sprites:
	
	public static Sprite particleNormal = new Sprite(2,0xff242424);

	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		this.x = x * SIZE; // because i want it to be located in a specific place in the sheet= each tile is multiplied by his size so when i change by 1, the tile is changed and not the pixel
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE]; // size of the sprite
		load();
	}
	
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		setColor(color);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);

	}

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
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
