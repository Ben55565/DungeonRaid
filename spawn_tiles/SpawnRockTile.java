package spawn_tiles;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;
import tile.Tile;

public class SpawnRockTile extends Tile {

	public SpawnRockTile(Sprite sprite) {
		super(sprite);

	}
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // translating tiles precision to pixels, multiplying by 16

	}
	
	public boolean solidForWalk() {
		return true;
	}

}
