package level;

import java.util.ArrayList;
import java.util.List;
import entity.Entity;
import entity.Particle;
import entity.Projectile;
import myGameGraphics.Screen;
import tile.Tile;

public class Level {
	protected int[] tiles; // contain the color values of each level
	protected int width, height;
	protected int[] tilesMaping; // contain indexing of all tiles on the map
	public static Level spawn = new SpawnLevel("/textures/Levels/SpawnLevel.png");
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();

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

	public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset) { // check collision for entities, like projectiles for example - prevent them from going through a wall
		// x and y indicates the location of the entity, xa ya indicates its trajectory, size is the size of the entity object itself
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) { // checking for collision in each corner of the tile
			int xt = (x - corner % 2 * size + xOffset) >> 4;
			int yt = (y - corner / 2 * size + yOffset) >> 4; // the division and  addition is to perfect as much as possible the accuracy for the hitbox of the collision based objects
			if (getTile(xt, yt).solid())
				solid = true;
		}

		return solid;
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}

		remove(); // remove the particales that their time runs out
	}

	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) {
				entities.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) {
				projectiles.remove(i);
			}
		}
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) {
				particles.remove(i);
			}
		}
	}

	//	private void time() {
	//
	//	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else {
			entities.add(e);
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
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

		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}

	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.spawnGrass;
		if (tiles[x + y * width] == Tile.floorHex)
			return Tile.spawnFloor;
		if (tiles[x + y * width] == Tile.TallGrassHex)
			return Tile.spawnTallGrass;
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
		return Tile.spawnGrass;
	}

}
