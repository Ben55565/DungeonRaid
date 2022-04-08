package spawn_tiles;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;
import tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // translating tiles precision to pixels, multiplying by 16

	}

	public boolean solid() {
		return true;
	}

	public boolean breakable() { // will use that in the future
		return true;
	}

}
