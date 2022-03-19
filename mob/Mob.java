package mob;

import entity.Entity;
import myGameGraphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0; // used to identify which direction the mob need to move: 0 up, 1 right, 2 down 3 left
	protected boolean moving = false;
	
	public void move(int xa, int ya) { // consider on the x - player can go: right, left, stay in place. consider on the y - player can go: up down, stay in place
		// -1, 0, 1 for the direction of the movement for x and y
		if(xa > 0)
			dir = 1;
		if(xa < 0)
			dir = 3;
		if(ya > 0)
			dir = 2;
		if(ya < 0)
			dir = 0;
		if(!collision()) {
		x += xa;
		y += ya;
		}
	}
	
	public void update() {
		
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
		
	}
	
}
