package tile;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class FlowerTile extends Tile{

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 3, y << 3, this); // translating tiles precision to pixels, multiplying by 8

	}
	

}
