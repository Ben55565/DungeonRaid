package myGameGraphics;

public class Sprite {
	
	public final int SIZE; // size of each individual sprite(if i have monsters for example and i want them to take specific size different from tiles)
	private int x, y; // coordinate of the sprite
	public int[] pixels;
	private Spritesheet sheet;
	
	public static Sprite grass = new Sprite(16,0,0, Spritesheet.tiles); // create a sprite itself, grass texture
	
	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SIZE = size;
		this.x = x * SIZE; // because i want it to be located in a specific place int the sheet
		this.y = y;
		this.sheet = sheet;
		pixels = new int[SIZE * SIZE]; // size of the sprite
		load();
	}
	private void load() {
		for(int  y = 0; y < SIZE; y++) { // creating sort of scan for the sprite from the entire sheet tiles
			for(int x = 0; x < SIZE; x++) {
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE]; // extracting the relevant pixels for this specific sprite from the sprite sheet
			}
		}
	}
	
	

}
