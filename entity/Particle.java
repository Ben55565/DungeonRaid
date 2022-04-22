package entity;

import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class Particle extends Entity{
	

	private Sprite sprite;
	private int timeAlive;
	private int time = 0;
	
	protected double xa, ya, za;
	protected double xx, yy, zz;
	
	public Particle(int x, int y, int timeAlive) {
		this.timeAlive = timeAlive + random.nextInt(80) - 40; // get a random number between -40 and 40 to add to the timeAlive, making each particle remove in different time
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.zz = random.nextFloat() + 2.0;
		sprite = Sprite.particleNormal;
		this.xa = random.nextGaussian() + 1.8; // gives a value between -1 and 1 considering Gauss bell(distributed more around 0 then 1 and -1)
		// added value is for compensate on hit on the left wall(probably will be done on all sides)
		this.ya = random.nextGaussian();
	}
	
	
	public void update() {
		time++;
		if(time >= 7400) // make sure time wont pass irrational number
			time = 0;
		if(time > timeAlive) {
			remove();
		}
		za -= 0.1; // every update subtract 0.1 from za,making a graduated decent of the so called height of the particles, making a curve
		if(zz < 0) {
			zz = 0;
			za *= -0.55; // reverse the direction the particles will go when they hit the "virtual floor - zz"
			xa *= 0.4; // half the rate the particles go on both axis, the higher the more spread they are
			ya *= 0.2;
					
		}
		this.xx += xa; // xx and yy are only because original x and y are ints, need to make assignment by double
		this.yy += ya;
		this.zz += za;
		
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx + 14, (int)yy - (int)zz, sprite, true); // addition to xx is for the hit on the left wall(probably will be done on all sides)
		
	}

}
