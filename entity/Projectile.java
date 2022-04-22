package entity;

import myGameGraphics.Sprite;

public abstract class Projectile extends Entity {

	final protected int xOrigin, yOrigin; // where the Projectile will spawn at
	protected double angle; // angle which the Projectile will travel towards
	public Sprite sprite;
	protected double x,y;
	protected double distance; // track how far a projectile got(to stop render it depends on the range)
	protected double nx, ny;
	protected double speed, range, damage;

	public Sprite getSprite() {
		return sprite;
	}

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

}
