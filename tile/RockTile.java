package tile;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class RockTile extends Tile{

	public RockTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // translating tiles precision to pixels, multiplying by 8

	}
	
	public boolean solid() { // checking if the player can go though this block or not
		return true;
	}
}
