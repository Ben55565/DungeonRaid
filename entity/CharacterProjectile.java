package entity;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class CharacterProjectile extends Projectile {

	public static final int FIRERATE = 10; // higher is slower rate of fire

	public CharacterProjectile(int x, int y, double dir) { // vector holds angle and length which is perfect for firing
		super(x, y, dir);
		range = random.nextInt(100) + 100;
		damage = 4;
		speed = 3;

		sprite = Sprite.projectileCharacter;
		nx = Math.cos(angle) * speed; // cos of the angle will get the length with consideration of the speed
		ny = Math.sin(angle) * speed; // sin of the angle will get the angle consideration of the speed

	}

	public void update() {
		if (level.tileCollision(x, y, nx, ny, 10)) { // if the projectiles hit a collision based tile, remove them
			level.add(new ParticleSpawner((int)x, (int)y, 44, 50, level));
			remove();
		}
		move();
	}

	protected void move() { // making use of the vectors and moving the projectile
		x += nx;
		y += ny;
		if (distance() > range) {
			remove(); // setting here that if the distance of a specific projectile is greater the the range, mark it as removed
		}
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y))); // get the distance for projectile
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x + 8, (int) y + 8, this);
	}

}
