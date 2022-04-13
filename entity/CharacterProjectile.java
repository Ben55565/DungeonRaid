package entity;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class CharacterProjectile extends Projectile {

	public CharacterProjectile(int x, int y, double dir) { // vector holds angle and length which is perfect for firing
		super(x, y, dir);
		range = 200;
		damage = 4;
		speed = 5;
		rateOfFire = 15;
		sprite = Sprite.projectileCharacter;
		nx = Math.cos(angle) * speed; // cos of the angle will get the length with consideration of the speed
		ny = Math.sin(angle) * speed; // sin of the angle will get the angle consideration of the speed

	}
	
	public void update() {
		move();
	}
	
	protected void move() { // making use of the vectors and moving the projectile
		x += nx;
		y += ny;
	}
	
	public void render(Screen screen) {
		screen.renderProjectile(x, y, this);
	}

}
