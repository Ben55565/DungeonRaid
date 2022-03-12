package tile;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 3, y << 3, this);

	}

}
