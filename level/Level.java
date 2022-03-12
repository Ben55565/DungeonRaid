package level;

import myGameGraphics.Screen;

public class Level {
	
	protected int width, height;
	protected int[] tiles; // contain all tiles on the map
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width*height];
		generateLevel();
	} // hold list of all the tiles we need to render and managing them
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
	}

}
