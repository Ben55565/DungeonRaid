package tile;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);

	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // translating tiles precision to pixels, multiplying by 8

	}

}
