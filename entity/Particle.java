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
		this.xa = random.nextGaussian(); // gives a value between -1 and 1 considering Gauss bell(distributed more around 0 then 1 and -1)
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
			xa *= 0.5; // half the rate the particles go on both axis, the higher the more spread they are
			ya *= 0.2;
					
		}
		move((xx + xa), (yy + ya) + (zz + za));

	}
	
	private void move(double x, double y) {
		if(collision(x, y)) {
			this.xa *= -0.55;
			this.ya *= -0.5;
			this.za *= -0.2;
		}
		this.xx += xa; // xx and yy are only because original x and y are ints, need to make assignment by double
		this.yy += ya;
		this.zz += za;
		
		
		
		
	}
	
	public boolean collision(double x, double y) { // check collision for entities, like projectiles for example - prevent them from going through a wall
		// x and y indicates the location of the entity, xa ya indicates its trajectory, size is the size of the entity object itself
		boolean solid = false;
		for (int corner = 0; corner < 4; corner++) { // checking for collision in each corner of the tile
			double xt = (x - corner % 2 * 16) / 16;
			double yt = (y - corner / 2 * 16) / 16; // the division and  addition is to perfect as much as possible the accuracy for the hitbox of the collision based objects
			int ix = (int)Math.ceil(xt);
			int iy = (int)Math.ceil(yt);
			if(corner % 2 == 0) // if the particles hit the right side of the tile, round the var down to get the bound effect
				ix = (int)Math.floor(xt);
			if(corner / 2 == 0) // if the particles hit the bottom side of the tile, round the var down to get the bound effect
				iy = (int)Math.floor(yt);
			if (level.getTile(ix, iy).solid())
				solid = true;
		}

		return solid;
	}


	public void render(Screen screen) {
		screen.renderSprite((int)xx - 1, (int)yy - (int)zz - 1, sprite, true); // addition to xx is for the hit on the left wall(probably will be done on all sides)
		
	}

}
