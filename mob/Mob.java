package mob;

import entity.CharacterProjectile;
import entity.Entity;
import entity.Projectile;
import myGameGraphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 1; // used to identify which direction the mob need to move: 0 up, 1 right, 2 down 3 left
	protected boolean moving = false;

	public void move(int xa, int ya) { // consider on the x - player can go: right, left, stay in place. consider on the y - player can go: up down, stay in place
		// -1, 0, 1 for the direction of the movement for x and y
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;
		if (!collision(0, ya)) { // the separation of this condition to 2, allows sliding - checking separately if location at x value and at y value it is in collision tile(allowing moving right if the collision is only up and so on)
			y += ya;
		}
		if (!collision(xa, 0)) {
			x += xa;

		}


	}

	public void update() {

	}

	protected void shoot(int x, int y, double dir) {
		Projectile p = new CharacterProjectile(x, y, dir);
		level.add(p);

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) { // checking for collision in each corner of the tile
			int xt = ((x + xa) + corner % 2 * 12) / 16;
			int yt = ((y + ya) + corner / 2 * 12 + 10) / 16; // Adjust the corners of each tiles for collision - times 12 is the collision area, plus 10 is configuring the collision span(up and down for y, not needed for x)
			if (level.getTile(xt, yt).solid())
				solid = true;
		}

		return solid;
	}

	public void render() {

	}

}
